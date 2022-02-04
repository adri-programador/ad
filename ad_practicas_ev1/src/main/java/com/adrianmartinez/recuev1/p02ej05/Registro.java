package com.adrianmartinez.recuev1.p02ej05;

import com.adrianmartinez.recuev1.p02ej05.util.P02Ej05Util;

public class Registro {
    private String dni;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int edad;

    public Registro() {
        dni = "";
        nombre = "";
        primerApellido = "";
        segundoApellido = "";
        edad = 0;
    }

    public Registro(String dni, String nombre, String primerApellido, String segundoApellido, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.edad = edad;
    }

    public String clave() {
        return dni;
    }

    public void clave(String dni) {
        this.dni = dni;
    }

    public void nombre(String nombre) {
        this.nombre = nombre;
    }

    public void primerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void segundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void edad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return P02Ej05Util.rellenarConEspacios(dni) +
                P02Ej05Util.rellenarConEspacios(nombre) +
                P02Ej05Util.rellenarConEspacios(primerApellido) +
                P02Ej05Util.rellenarConEspacios(segundoApellido) +
                P02Ej05Util.rellenarConEspacios(String.valueOf(edad)) + "\n";
    }


}
