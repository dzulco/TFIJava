package com.techlab.util;

import java.util.Scanner;

public class Utils {
    public static int leerEntero(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        while (!sc.hasNextInt()){
            System.out.println("Debe ingresar un numero entero. Intente de nuevo: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
