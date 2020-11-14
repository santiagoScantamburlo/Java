package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[][] matriz;
        int fil, col, num;
        boolean sumasIguales;

        System.out.println("Ingrese la cantidad de filas de la matriz: ");
        fil = pufu.nextInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz: ");
        col = pufu.nextInt();

        matriz = new int[fil][col];

        // Cargo la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Ingrese un numero: ");
                num = pufu.nextInt();
                matriz[i][j] = num;
            }
        }

        sumasIguales = recorrerMatriz(matriz, 0, 0);
        // Invoco al modulo que verifica si la suma de todas las columnas
        // es igual

        if (sumasIguales) {
            System.out.println("La suma de cada una de las columnas es igual a las demas");
        } else {
            System.out.println("La suma de cada una de las columnas no es igual a las demas");
        }
    }

    public static boolean recorrerMatriz(int[][] matriz, int j, int suma) {
        boolean retorno = false;
        int aux;

        if (j == 0) {
            // Si se encuentra en la primera columna, el retorno es verdadero y el valor de
            // verdad del llamado
            suma = sumaColumnas(matriz, j, 0);
            retorno = true && recorrerMatriz(matriz, j + 1, suma); // Pasa por parametro el valor de la primera columna
        } else {
            if (j == matriz[0].length - 1) {
                // Si se encuentra en la ultima columna, hace la suma y verifica la
                // igualdad con la suma de la primera
                aux = sumaColumnas(matriz, j, 0);
                if (aux == suma) {
                    retorno = true;
                }
            } else {
                // Si se encuentra en cualquier otra posicion, diferente a las de los casos
                // anteriores, si la suma de la columna actual es igual a la de la primera, pasa
                // a la siguiente
                aux = sumaColumnas(matriz, j, 0);
                if (aux == suma) {
                    retorno = true && recorrerMatriz(matriz, j + 1, suma);
                }
            }
        }
        return retorno;
    }

    public static int sumaColumnas(int[][] matriz, int j, int i) {
        int retorno;

        if (i == matriz.length - 1) {
            retorno = matriz[i][j];
        } else {
            retorno = matriz[i][j] + sumaColumnas(matriz, j, i + 1);
        }
        return retorno;
    }
}
