import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        char[][] matriz;
        int orden;

        System.out.println("Ingrese el orden de la matriz:");
        orden = pufu.nextInt();

        matriz = new char[orden][orden];

        cargarMatriz(matriz);
        System.out.println("La diagonal de la matriz es: ");
        mostrarDiagonal(matriz);
    }

    public static void cargarMatriz(char[][] m) {
        Scanner pufu = new Scanner(System.in);
        char caracter;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.println("Ingrese un caracter:");
                caracter = pufu.next().charAt(0);
                m[i][j] = caracter;
            }
        }
    }

    public static void mostrarDiagonal(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i][i] + " ");
        }
    }
}
