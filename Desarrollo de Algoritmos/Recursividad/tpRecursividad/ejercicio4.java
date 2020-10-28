package tpRecursividad;

import java.util.Scanner;

/**
 * ejercicio4
 */
public class ejercicio4 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int num;

        System.out.print("Ingrese un numero: ");
        num = pufu.nextInt();

        if (verificarDigitos(num, num % 10)) {
            System.out.println("Todos los digitos son iguales");
        } else {
            System.out.println("Los digitos no son iguales");
        }
    }

    public static boolean verificarDigitos(int n, int i) {
        boolean retorno = false;

        if (n >= 10) {
            if (n % 10 == i) {
                retorno = true && verificarDigitos(n / 10, i);
            }
        } else {
            if (n == i) {
                retorno = true;
            }
        }
        return retorno;
    }
}