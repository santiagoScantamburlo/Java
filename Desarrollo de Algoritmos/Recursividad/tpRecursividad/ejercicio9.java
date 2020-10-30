package tpRecursividad;

import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        char[] arreglo;
        int longitud;
        char caracter, buscado;
        boolean encontrado;

        System.out.println("Ingrese la longitud del arreglo");
        longitud = pufu.nextInt();
        arreglo = new char[longitud];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Ingrese un caracter: ");
            caracter = pufu.next().charAt(0);
            arreglo[i] = caracter;
        }
        System.out.println("Ingrese el caracter que desea buscar: ");
        buscado = pufu.next().charAt(0);

        encontrado = buscarCaracter(arreglo, longitud - 1, buscado, 0);

        if (encontrado) {
            System.out.println("El caracter se encuentra dentro del arreglo");
        } else {
            System.out.println("El caracter no se encuentra dentro del arreglo");
        }
    }

    public static boolean buscarCaracter(char[] a, int n, char buscado, int i) {
        boolean retorno = false;

        if (i == n) {
            // Si se llega a la ultima posicion, si el caracter es igual al buscado retorna
            // verdadero
            if (a[i] == buscado) {
                retorno = true;
            }
        } else {
            // Sino, si el caracter es igual al buscado retorna verdadero
            if (a[i] == buscado) {
                retorno = true;
            } else {
                // Sino, retorna falso o el valor de verdad de verdad del llamado del modulo con
                // la siguiente posicion del arreglo
                retorno = false || buscarCaracter(a, n, buscado, i + 1);
            }
        }
        return retorno;
    }
}
