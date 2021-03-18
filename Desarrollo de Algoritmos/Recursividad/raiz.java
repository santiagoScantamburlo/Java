import java.util.Scanner;

public class raiz {
    public static Scanner pufu = new Scanner(System.in);

    public static void main(String[] args) {
        int n, raiz;
        System.out.println("Ingrese un numero para buscar su raiz: ");
        n = pufu.nextInt();

        raiz = calcularRaiz(1, n);

        System.out.println("La raiz de " + n + " es: " + raiz);
    }

    public static int calcularRaiz(int i, int n) {
        int retorno = -1;
        if (i * i == n) {
            retorno = i;
        } else {
            if (i * i < n) {
                if ((i + 1) * (i + 1) > n) {
                    retorno = i;
                } else {
                    retorno = calcularRaiz(i + 1, n);
                }
            }
        }
        return retorno;
    }
}
