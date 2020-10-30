package tpRecursividad;

import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] arreglo;
        int longitud, num, mayorNum;

        System.out.print("Ingrese la longitud del arreglo: ");
        longitud = pufu.nextInt();
        arreglo = new int[longitud];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese un numero");
            num = pufu.nextInt();
            arreglo[i] = num;
        }

        mayorNum = buscarMayor(arreglo, longitud - 1, 0);
        System.out.println(mayorNum);
    }

    public static int buscarMayor(int[] a, int n, int i) {
        int retorno, mayor;

        if (i == 0) { // Si se encuentra en la primera posicion, el mayor es el primer numero del
                      // arreglo
            mayor = a[i];
            retorno = buscarMayor(a, n, i + 1); // A retorno le asigno el valor de la siguiente posicion del arreglo
            if (retorno >= mayor) {
                // Si el valor de la siguiente posicion es mayor o igual a al actual, entonces
                // lo reemplaza
                mayor = retorno;
            }
        } else if (i < n) { // Mientras que no se encuentre en la ultima posicion, a retorno se le asigna el
                            // valor de la siguiente
            mayor = a[i]; // A mayor le asigno el valor de la posicion actual
            retorno = buscarMayor(a, n, i + 1);
            if (retorno >= mayor) {
                // Si el valor de la siguiente posicion es mayor o igual a la actual, entonces
                // lo reemplaza
                mayor = retorno;
            }
        } else {
            // Si llega a la ultima posicion, se retorna el valor almacenado en ella
            mayor = a[i];
        }
        return mayor;
    }
}
