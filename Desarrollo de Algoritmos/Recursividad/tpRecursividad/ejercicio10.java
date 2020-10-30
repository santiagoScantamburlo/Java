package tpRecursividad;

import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        String cadena;
        char caracter;
        int ocurrencias;

        System.out.println("Ingrese una cadena de caracteres: ");
        cadena = pufu.nextLine();
        System.out.println("Ingrese el caracter que desea buscar en la cadena: ");
        caracter = pufu.next().charAt(0);

        ocurrencias = contarOcurrencias(cadena, caracter, cadena.length() - 1, 0);

        System.out.println("El caracter '" + caracter + "' se repite " + ocurrencias + " veces en la cadena");
    }

    public static int contarOcurrencias(String cadena, char buscado, int n, int i) {
        int retorno = 0;

        if (i == n) {
            // Si llega a la ultima posicion de la cadena
            if (cadena.charAt(i) == buscado) {
                // Si el caracter es igual al buscado, retorna 1
                retorno = 1;
            }
        } else {
            // Sino, mientras no llegue al final
            if (cadena.charAt(i) == buscado) {
                // Si el caracter es igual al buscado, el retorno es 1 mas el llamado del
                // modulo, con la siguiente posicion de la cadena
                retorno = 1 + contarOcurrencias(cadena, buscado, n, i + 1);
            } else {
                // Sino, el retorno es el llamado del modulo con la siguiente posicion de la
                // cadena
                retorno = contarOcurrencias(cadena, buscado, n, i + 1);
            }
        }
        return retorno;
    }
}
