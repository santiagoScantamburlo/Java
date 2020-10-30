package tpRecursividad;

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        int vocales;

        vocales = contarVocales();
        System.out.println("Se ingresaron " + vocales + " vocales");
    }

    public static int contarVocales() {
        Scanner pufu = new Scanner(System.in);
        int retorno;
        char letra;

        System.out.println("Ingrese una letra: ");
        letra = pufu.next().charAt(0);

        if (letra == '.') { // Pide caracteres mientras que el ingresado no sea un punto
            retorno = 0;
        } else {
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                // Si el caracter ingresado es una vocal, al retorno se le suma 1 mas el llamado
                // del modulo
                retorno = 1 + contarVocales();
            } else {
                // Sino, le asigna el llamado del modulo
                retorno = contarVocales();
            }
        }
        return retorno;
    }
}
