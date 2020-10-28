import java.util.Scanner;

public class piramide {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int n = 4, i = 1;

        mostrarPiramide(n, i);
    }

    public static void mostrarPiramide(int n, int i) {
        if (n != 0) {
            if (i == n) {
                System.out.println(n);
                mostrarPiramide(n - 1, 1);
            } else {
                System.out.print(n + " ");
                mostrarPiramide(n, i + 1);
            }
        }
    }
}
