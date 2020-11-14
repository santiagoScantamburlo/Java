package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio9 {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[][] matriz;
        int fil, col, num, exito;

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
        recorrerMatriz(matriz, 0); // Invoco al modulo que va a recorrer la matriz y mostrar la suma de las filas
    }

    public static void recorrerMatriz(int[][] matriz, int i) {
        if (i == matriz.length - 1) { // Si llega a la ultima fila llama al modulo que hace la suma y la muestra
            System.out.println("Suma fila " + (i + 1) + ": " + sumaFilas(matriz, i, 0));
        } else {
            // Si no esta en la ultima posicion muestra la suma y aumenta hace el llamado
            // con la siguiente fila
            System.out.println("Suma fila " + (i + 1) + ": " + sumaFilas(matriz, i, 0));
            recorrerMatriz(matriz, i + 1);
        }
    }

    public static int sumaFilas(int[][] matriz, int i, int j) {
        int retorno;
        if (j == matriz[0].length - 1) {
            // Si se encuentra en la ultima posicion de la fila retorna el valor
            retorno = matriz[i][j];
        } else {
            // Sino suma el valor con el llamado de la siguiente posicion
            retorno = matriz[i][j] + sumaFilas(matriz, i, j + 1);
        }
        return retorno;
    }
}