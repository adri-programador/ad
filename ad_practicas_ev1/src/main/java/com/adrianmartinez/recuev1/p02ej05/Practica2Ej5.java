package com.adrianmartinez.recuev1.p02ej05;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Practica2Ej5 {
    private final int nFields;

    private Path tmp;

    public Practica2Ej5(int nFields) throws IOException {

        this.nFields = nFields;

        crearFicheroTemporal();
    }

    private void crearFicheroTemporal() throws IOException {
        tmp = Files.createTempFile(null, null);
    }

    public void insertarRegistro(String filePath, Registro recordToInsert) throws IOException {
        File oldDatabase = new File(filePath);
        BufferedReader database = new BufferedReader(new FileReader(oldDatabase));
        String linea;
        boolean shouldInsertNewRegister = false;
        int comparerResult = -1;
        do {
            linea = database.readLine();
            if (null != linea) {
                Registro insertedRecord = tokenizer(linea);
                if (!shouldInsertNewRegister) {
                    comparerResult = recordComparer(recordToInsert, insertedRecord);
                    if (comparerResult < 0) {
                        insertarRegistroFichero(recordToInsert);
                        shouldInsertNewRegister = true;
                    }
                }
                if (comparerResult != 0) {
                    insertarRegistroFichero(insertedRecord);
                }
            }
        } while(linea != null);

        FileChannel src = new FileInputStream(String.valueOf(tmp)).getChannel();
        FileChannel dest = new FileOutputStream(oldDatabase).getChannel();
        dest.transferFrom(src, 0, src.size());
    }

    private Registro tokenizer(String linea) {
        Registro newRecord = new Registro();
        int ini = 0;
        int FIELD_LENGTH = 10;
        int fin = FIELD_LENGTH;
        for(int i = 0; i < nFields;) {
            String newField = linea.substring(ini, fin);
            setDataToField(i, newRecord, newField.trim());
            ini = fin; fin += FIELD_LENGTH;
            i++;
        }
        return newRecord;
    }

    private void setDataToField(int nField, Registro newRecord, String trimmedData) {
        switch(nField) {
            case 0:
                newRecord.clave(trimmedData);
                break;
            case 1:
                newRecord.nombre(trimmedData);
                break;
            case 2:
                newRecord.primerApellido(trimmedData);
                break;
            case 3:
                newRecord.segundoApellido(trimmedData);
                break;
            case 4:
                newRecord.edad(Integer.parseInt(trimmedData));
                break;
        }
    }

    private int recordComparer(Registro recordToInsert, Registro insertedRecord) {
        return recordToInsert.clave().compareTo(insertedRecord.clave());
    }

    private void insertarRegistroFichero(Registro rToInsert) throws IOException {
        Files.write(tmp, rToInsert.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }

}