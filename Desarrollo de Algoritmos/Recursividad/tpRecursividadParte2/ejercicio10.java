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

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Ingrese un numero: ");
                num = pufu.nextInt();
                matriz[i][j] = num;
            }
        }

        sumasIguales = recorrerMatriz(matriz, 0);

        if (sumasIguales) {
            System.out.println("La suma de cada una de las columnas es igual a las demas");
        } else {
            System.out.println("La suma de cada una de las columnas no es igual a las demas");
        }
    }

    public static boolean recorrerMatriz(int[][] matriz, int j) {
        boolean retorno = false;
        int suma, aux;

        if (j == 0) {
            retorno = true && recorrerMatriz(matriz, j + 1);
        } else {
            if (j == matriz[0].length - 1) {
                suma = sumaColumnas(matriz, 0, 0);
                aux = sumaColumnas(matriz, j, 0);
                if (aux == suma) {
                    retorno = true;
                }
            } else {
                suma = sumaColumnas(matriz, 0, 0);
                aux = sumaColumnas(matriz, j, 0);
                if (aux == suma) {
                    retorno = true && recorrerMatriz(matriz, j + 1);
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
