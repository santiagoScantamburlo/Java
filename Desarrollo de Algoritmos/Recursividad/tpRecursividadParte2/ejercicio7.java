package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        String[] arreglo;
        String palabra;
        int longitud;

        System.out.println("Ingrese la longitud del arreglo: ");
        longitud = pufu.nextInt();
        arreglo = new String[longitud];

        for (int i = 0; i < arreglo.length; i++) {
            palabra = "";
            System.out.println("Ingrese una palabra");
            palabra = pufu.next();
            arreglo[i] = palabra;
        }

        recorrerArreglo(arreglo, longitud - 1, 0);
    }

    public static void recorrerArreglo(String[] a, int n, int i) {
        if(i == n) {
            //Si esta en la ultima posicion del arreglo, muestra la longitud y el primer caracter
            System.out.println(a[i].length() + " " + a[i].charAt(0));
        } else {
            //Sino, muestra la longitud y el primer caracter, y luego pasa a la siguiente posicion
            System.out.println(a[i].length() + " " + a[i].charAt(0));
            recorrerArreglo(a, n, i + 1);
        }
    }
}
