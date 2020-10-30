package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] arreglo;
        int longitud, num, sumaPar, sumaImpar;

        System.out.println("Ingrese la longitud del arreglo: ");
        longitud = pufu.nextInt();
        arreglo = new int[longitud];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese un numero: ");
            num = pufu.nextInt();
            arreglo[i] = num;
        }

        sumaPar = sumaPosiciones(arreglo, longitud - 1, 0); //Paso por parametro la primer posicion par
        System.out.println(sumaPar);
        sumaImpar = sumaPosiciones(arreglo, longitud - 1, 1); //Paso por parametro la primer posicion impar
        System.out.println(sumaImpar);
    }

    public static int sumaPosiciones(int[] a, int n, int i) {
        int sumaI = 0, sumaP = 0, retorno;
        if (i < n) { // Mientras que i sea menor a n verifica si es una posicion par o impar
            if (i % 2 == 0) {
                // Si es par, hace la suma y suma el valor de la siguiente posicion par
                sumaP += a[i] + sumaPosiciones(a, n, i + 2);
                retorno = sumaP;
            } else {
                // Si es impar, hace la suma y suma el valor de la siguiente posicion impar
                sumaI += a[i] + sumaPosiciones(a, n, i + 2);
                retorno = sumaI;
            }
        } else if (i == n) { // Si se encuentra en la ultima posicion, el retorno sera ese valor
            retorno = a[i];
        } else {// En caso de que por sumar de a 2, la posicion supere a la longitud del
                // arreglo, siempre se retornará 0
            retorno = 0;
        }
        return retorno;
    }
}
