package com.adrianmartinez.recuev1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
            int opcion;
            do{
                System.out.println("--Menú--");
                System.out.println("[1] practica1");
                System.out.println("[2] practica2");
                System.out.println("[3] practica3");
                System.out.println("[4] practica4");
                System.out.println("[5] Finalizar programa");
                System.out.println("Elija una opción: ");
                opcion = sc.nextInt();
            } while(opcion < 1 || opcion > 5);

            switch(opcion){
                case 1:
                    practica1();
                    break;
                case 2:
                    practica2();
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    static void practica1(){
        System.out.println("La documentación sobre los Sistemas de Persistencia de Datos se encuentra en la ruta:");
        System.out.println("'\\ad_practicas_ev1\\src\\Practica1'");
    }
    static void practica2() throws IOException{
         Practica2.start(); 
    }
}
