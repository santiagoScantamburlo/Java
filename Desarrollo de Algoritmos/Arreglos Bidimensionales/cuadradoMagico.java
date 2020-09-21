import java.util.Scanner;

public class cuadradoMagico {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int orden, num;
        int[][] matriz;

        System.out.println("Ingrese el orden de la matriz: ");
        orden = pufu.nextInt();
        matriz = new int[orden][orden];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Ingrese un numero: ");
                num = pufu.nextInt();
            }
        }

        System.out.println("Es un cuadrado magico: " + verificarCuadrado(matriz));
    }

    public static boolean verificarCuadrado(int[][] matriz) {
        boolean esCuadrado = true;
        
        return esCuadrado;
    }
}
