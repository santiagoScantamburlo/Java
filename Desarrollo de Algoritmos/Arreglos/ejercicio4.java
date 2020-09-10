import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int num;
        int[] arreglo = new int[10];

        System.out.println("Ingrese un numero: ");
        num = pufu.nextInt();

        for (int i = 1; i <= arreglo.length; i++) {
            arreglo[i - 1] = num * i;
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (i + 1 != arreglo.length) {
                System.out.print(arreglo[i] + " ");
            } else {
                System.out.println(arreglo[i]);
            }
        }
    }
}
