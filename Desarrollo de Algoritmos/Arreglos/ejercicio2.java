import java.util.Scanner;

/**
 * ejercicio2
 */
public class ejercicio2 {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] array = new int[5];
        int num;

        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese un numero: ");
            num = pufu.nextInt();
            array[i] = num;
        }

        for (int i = 0; i < array.length; i++) {
            if (i + 1 != array.length) {
                System.out.print(array[i] + " - ");
            } else {
                System.out.println(array[i]);
            }
        }
    }
}