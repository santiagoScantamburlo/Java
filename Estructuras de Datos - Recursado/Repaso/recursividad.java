import java.util.Scanner;

/**
 * operacionesStrings
 */
public class recursividad {
    public static Scanner pufu = new Scanner(System.in);

    public static void main(String[] args) {
        String cadena;
        System.out.println("Ingrese una cadena de caracteres: ");

        cadena = pufu.nextLine();

        System.out.println(primeraPosicionLetra(cadena, cadena.length() - 1, 0));
        System.out.println(ultimaPosicionLetra(cadena, cadena.length() - 1));
        System.out.println(cadenaMasInvertida(cadena, cadena.length() - 1));
    }

    public static int primeraPosicionLetra(String c, int n, int i) {
        int retorno = -1;

        if (i < n) {
            if (Character.isLetter(c.charAt(i))) {
                retorno = i;
            } else {
                retorno = primeraPosicionLetra(c, n, i + 1);
            }
        } else {
            if (Character.isLetter(c.charAt(i))) {
                retorno = i;
            }
        }
        return retorno;
    }

    public static int ultimaPosicionLetra(String c, int i) {
        int retorno = -1;

        if (i > 0) {
            if (Character.isLetter(c.charAt(i))) {
                retorno = i;
            } else {
                retorno = ultimaPosicionLetra(c, i - 1);
            }
        } else {
            if (Character.isLetter(c.charAt(i))) {
                retorno = i;
            }
        }
        return retorno;
    }

    public static String cadenaMasInvertida(String c, int n) {
        String retorno = "";

        if (n < 0) {
            retorno = c;
        } else {
            retorno = cadenaMasInvertida(c + c.charAt(n), n - 1);
        }
        return retorno;
    }
}