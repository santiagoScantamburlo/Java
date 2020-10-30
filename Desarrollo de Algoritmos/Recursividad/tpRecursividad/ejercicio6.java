package tpRecursividad;

import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        int multiplosTres;

        multiplosTres = contarMultiplos();
        System.out.println("Se ingresaron " + multiplosTres + " multiplos de 3");
    }

    public static int contarMultiplos() {
        Scanner pufu = new Scanner(System.in);
        int retorno, num;

        System.out.println("Ingrese un numero: ");
        num = pufu.nextInt();

        if (num == 0) {
            // Si el numero es 0, termina la secuencia
            retorno = 0;
        } else {
            if (num % 3 == 0) {
                // Si el numero es multiplo de 3, se le suma 1 al retorno mas el llamado del
                // modulo
                retorno = 1 + contarMultiplos();
            } else {
                // Sino, al retorno se le asigna el llamado del modulo
                retorno = contarMultiplos();
            }
        }
        return retorno;
    }
}
