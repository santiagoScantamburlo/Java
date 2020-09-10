import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int n, num, longitud;
        int[] arreglo;

        System.out.println("Ingrese la longitud del arreglo: ");
        longitud = pufu.nextInt();
        arreglo = new int[longitud];
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese un numero: ");
            num = pufu.nextInt();
            arreglo[i] = num;
        }

        System.out.println("Ingrese N: ");
        n = pufu.nextInt();

        for (int i = 0; i < arreglo.length; i++) {
            if (i % 2 != 0) {
                arreglo[i] = n;
            }
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (i + 1 != arreglo.length) {
                System.out.print(arreglo[i] + " - ");
            } else {
                System.out.println(arreglo[i]);
            }
        }
    }
}
