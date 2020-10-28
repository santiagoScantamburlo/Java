package tpRecursividad;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int num;

        System.out.print("Ingrese un numero: ");
        num = pufu.nextInt();

        System.out.println(invertirNumero(num));
    }

    public static String invertirNumero(int n) {
        String retorno = "";

        if (n >= 10) {
            retorno += n % 10 + invertirNumero(n / 10);
        } else {
            retorno += n;
        }
        return retorno;
    }
}
