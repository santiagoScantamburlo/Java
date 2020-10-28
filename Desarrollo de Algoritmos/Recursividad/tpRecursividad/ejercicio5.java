package tpRecursividad;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int num, aux, i = 1;

        System.out.print("Ingrese un numero: ");
        num = pufu.nextInt();
        aux = num;

        while (aux >= 10) {
            i *= 10;
            aux /= 10;
        }

        System.out.println(invertirNumero(num, i));
    }

    public static int invertirNumero(int n, int i) {
        int retorno = 0;

        if (n >= 10) {
            retorno += ((n % 10) * i) + invertirNumero(n / 10, i / 10);
        } else {
            retorno = n;
        }
        return retorno;
    }
}
