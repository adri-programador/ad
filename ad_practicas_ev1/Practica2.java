package com.adrianmartinez.recuev1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Practica2 {
    
    public static void start() throws FileNotFoundException, IOException{
        String opciones = "";
        do{   
            System.out.println("\n\n--Practica2--");
            System.out.println("[1] ejercicio1");
            System.out.println("[2] ejercicio3");
            System.out.println("[3] ejercicio4");
            System.out.println("[4] ejercicio5");
            System.out.println("[5] ejercicio6");
            System.out.println("[6] volver al menu");
            System.out.println("Elija una opción: ");
            Scanner sc = new Scanner(System.in);
            opciones = sc.next(); // recojo el valor del próximo caracter .next / nextLine recoge info de toda la linea

            switch(opciones){
                case "1": 
                    Practica2Ej1.ejercicio1();
                    break;
                case "2":
                    Practica2Ej3.ejercicio3();
                    break;
                case "3":
                    Practica2Ej3.ejercicio4();
                    break;
                case "5":
                    break;
                case "6":
                    break;
            }
        } while(Integer.parseInt(opciones)<=6);
    }
}
