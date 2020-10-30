package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        String cadena;

        cadena = formarCadena();
        System.out.println(cadena);
    }

    public static String formarCadena() {
        Scanner pufu = new Scanner(System.in);
        String retorno = "";
        char caracter;

        System.out.println("Ingrese un caracter: ");
        caracter = pufu.next().charAt(0);

        if (caracter == '.') {//Si el caracter es un punto, lo retorna
            retorno += '.';
        } else { //En caso de que no sea un punto, llama al modulo y concatena el caracter ingresado
            retorno = formarCadena() + caracter;
        }
        return retorno;
    }
}
