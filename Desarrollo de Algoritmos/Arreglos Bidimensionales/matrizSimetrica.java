import java.util.Scanner;

public class matrizSimetrica {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int orden;
        int[][] matriz;
        int elem;

        System.out.println("Ingrese el orden de la matriz: ");
        orden = pufu.nextInt();

        matriz = new int[orden][orden];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Ingrese un numero");
                elem = pufu.nextInt();
                matriz[i][j] = elem;
            }
        }

        System.out.println("La matriz es simetrica: " + verificarSimetria(matriz));
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean verificarSimetria(int[][] matriz) {
        boolean esSimetrica = true;
        int i = 0, j = 0;
        int num;

        while (esSimetrica && i < matriz.length) {
            while (esSimetrica && j < matriz[0].length) {
                num = matriz[i][j];
                if(num != matriz[j][i]) {
                    esSimetrica = false;
                } else {
                    j++;
                }
            }
            i++;
            j = i;
        }
        return esSimetrica;
    }
}