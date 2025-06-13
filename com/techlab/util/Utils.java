package com.techlab.util;

import java.util.Scanner;

public class Utils {
    public static int leerEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        while (!sc.hasNextInt()){
            System.out.println("Debe ingresar un numero entero. Intente de nuevo: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static String leerCadena(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return sc.next();
    }

    public static double leerDouble(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.print(s);
        while (!sc.hasNextDouble()){
            System.out.println("Debe ingresar un numero double. Intente de nuevo: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
