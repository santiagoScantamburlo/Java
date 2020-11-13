import java.util.Scanner;

public class buscarPrimos {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int n1, n2;
        do {
            System.out.println("Ingrese el rango dentro del que desea buscar numeros primos");
            n1 = pufu.nextInt();
            n2 = pufu.nextInt();
        } while (n1 >= n2 || n1 <= 0 || n2 <= 0);
        int i = n1;
        buscarPrimo(n1, n2, i);
    }

    public static void buscarPrimo(int n1, int n2, int i) {
        if (i != n2) {
            if (esPrimo(1, i)) {
                System.out.print(i + " - ");
                buscarPrimo(n1, n2, i + 1);
            } else {
                buscarPrimo(n1, n2, i + 1);
            }
        }
    }

    public static boolean esPrimo(int n, int i) {
        boolean retorno;
        if (i != 1) {
            if (n == i / 2) {
                if (((i / 2) % n) == 0) {
                    retorno = true;
                } else {
                    retorno = false;
                }
            } else {
                if (i % n == 0 && n != 1) {
                    retorno = false;
                } else {
                    retorno = true && esPrimo(n + 1, i);
                }
            }
        } else {
            retorno = false;
        }
        return retorno;
    }
}
