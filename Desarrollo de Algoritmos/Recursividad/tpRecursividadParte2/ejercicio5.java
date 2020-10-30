package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] arreglo;
        int num, longitud;
        boolean creciente;

        System.out.println("Ingrese la longitud del arreglo: ");
        longitud = pufu.nextInt();
        arreglo = new int[longitud];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese un numero: ");
            num = pufu.nextInt();
            arreglo[i] = num;
        }
        creciente = verificarOrden(arreglo, longitud - 1, 0);

        if (creciente) {
            System.out.println("Los numeros estan ordenados de forma creciente");
        } else {
            System.out.println("Los numeros no estan ordenados de forma creciente");
        }
    }

    public static boolean verificarOrden(int[] a, int n, int i) {
        boolean retorno = false;

        if (i == n - 1) { // Si el indice se encuentra en la anteultima posicion, verifica si es menor a
                          // la ultima
            if (a[i] <= a[n]) { // Si es menor, el valor de retorno es verdadero
                retorno = true;
            }
        } else { // Si no se encuentra en la anteultima posicion, verifica que sea menor al
                 // numero de la siguiente
            if (a[i] <= a[i + 1]) { // Si es menor, el retorno es verdadero y pasa a la siguiente posicion
                retorno = true && verificarOrden(a, n, i + 1); // En caso de que uno de los numeros no cumpla con la
                                                               // forma creciente, el retorno sera falso
            }
        }
        return retorno;
    }
}
