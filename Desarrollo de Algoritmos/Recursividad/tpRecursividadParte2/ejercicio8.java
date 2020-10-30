package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        String cadena, vocalesOrden, vocalesInverso;

        System.out.println("Ingrese una cadena de caracteres: ");
        cadena = pufu.nextLine();

        vocalesOrden = mostrarVocalesEnOrden(cadena, cadena.length() - 1, 0);
        vocalesInverso = mostrarVocalesEnOrdenInverso(cadena, cadena.length() - 1, 0);

        System.out.println(cadena + " <=> " + vocalesOrden);
        System.out.println(cadena + " <=> " + vocalesInverso);
    }

    public static String mostrarVocalesEnOrden(String c, int n, int i) {
        String retorno = "";
        char letra = c.charAt(i);
        if (i == n) {
            // Si se encuentra en la ultima posicion y la letra es vocal, la concatena
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A'
                    || letra == 'E' || letra == 'I' || letra == 'U' || letra == 'U') {
                retorno += letra;
            }
        } else {
            // Si no se encuentra en la ultima posicion y la letra es vocal, la concatena y
            // luego llama al modulo
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A'
                    || letra == 'E' || letra == 'I' || letra == 'U' || letra == 'U') {
                retorno += letra + mostrarVocalesEnOrden(c, n, i + 1);
            } else {
                // Sino, concatena el llamado al modulo
                retorno += mostrarVocalesEnOrden(c, n, i + 1);
            }
        }
        return retorno;
    }

    public static String mostrarVocalesEnOrdenInverso(String c, int n, int i) {
        String retorno = "";
        char letra = c.charAt(i);
        if (i == n) {
            // Si se encuentra en la ultima posicion y la letra es vocal, la concatena
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A'
                    || letra == 'E' || letra == 'I' || letra == 'U' || letra == 'U') {
                retorno += letra;
            }
        } else {
            // Si no se encuentra en la ultima posicion y la letra es vocal, llama al modulo
            // y luego concatena
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A'
                    || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
                retorno += mostrarVocalesEnOrdenInverso(c, n, i + 1) + letra;
                // Sino, concatena el llamado al modulo
            } else {
                retorno += mostrarVocalesEnOrdenInverso(c, n, i + 1);
            }
        }
        return retorno;
    }
}
