import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        String[][] matriz;
        int fil, col, indice = 0;
        boolean continuar = true;

        System.out.println("Ingrese la cantidad de filas de la matriz:");
        fil = pufu.nextInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz:");
        col = pufu.nextInt();

        matriz = new String[fil][col];

        while (continuar) {
            mostrarMatriz(matriz);
            menu();
            continuar = opcion(matriz, indice);
        }
    }

    public static int cargarMatriz(String[][] m, int indice) {
        Scanner pufu = new Scanner(System.in);
        String cadena = "";

        for (int i = (indice / m.length); i < m.length; i++) {
            for (int j = (indice % m[0].length); j < m[0].length; j++) {
                if (cadena.length() == 0) {
                    System.out.println("Ingrese una cadena de caracteres:");
                    cadena = pufu.next();
                    m[i][j] = cadena;
                } else {
                    cadena = pufu.next();
                    m[i][j] = cadena;
                }
            }
        }
        return indice;
    }

    public static void mostrarMatriz(String[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void menu() {
        System.out.println("Ingrese la opcion que desea:");
        System.out.println("1: Cargar mas palabras");
        System.out.println("2: Mostrar una posicion de la matriz");
        System.out.println("0: Salir");
    }

    public static boolean opcion(String[][] m, int i) {
        Scanner pufu = new Scanner(System.in);
        boolean retorno = true;
        int opcion;

        opcion = pufu.nextInt();

        switch (opcion) {
            case 1:
                i = cargarMatriz(m, i);
        }

        return retorno;
    }
}
