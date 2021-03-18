import java.util.Scanner;

public class recursividad2 {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int bomba = 0, numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println("Ingrese un numero");
            numero = pufu.nextInt();
            System.out.println("Ingrese un numero bomba");
            bomba = pufu.nextInt();
            if (bomba < numero) {
                valido = true;
            }
        }

        explotar(numero, bomba);
    }

    public static void explotar(int n, int b) {
        int n1, n2;

        if (n > b) {
            n1 = n / b;
            n2 = n - (n / b);
            if (n1 <= b) {
                System.out.print(n1);
                System.out.print(", ");
            }
            if (n2 <= b) {
                System.out.print(n2);
                System.out.print(", ");
            }
            explotar(n1, b);
            explotar(n2, b);
        }
    }
}
