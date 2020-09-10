import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        String[] arreglo;
        int longitud;

        System.out.println("Ingrese la longitud del arreglo: ");
        longitud = pufu.nextInt();
        arreglo = new String[longitud];

        cargarArreglo(arreglo);

        System.out.println("Cadena con las palabras: " + armarCadena(arreglo));
        System.out.println("Cadena inversa con las palabras: " + cadenaInversa(arreglo));
    }

    public static void cargarArreglo(String[] arreglo) {
        Scanner pufu = new Scanner(System.in);
        String cadena;

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese una palabra: ");
            cadena = pufu.next();
            arreglo[i] = cadena;
        }
    }

    public static String armarCadena(String[] arreglo) {
        String retorno = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (i + 1 != arreglo.length) {
                retorno += arreglo[i] + " ";
            } else {
                retorno += arreglo[i];
            }
        }
        return retorno;
    }

    public static String cadenaInversa(String[] arreglo) {
        String retorno = "";
        for (int i = arreglo.length - 1; i >= 0; i--) {
            if(i != 0) {
                retorno += arreglo[i] + " - ";
            } else {
                retorno += arreglo[i];
            }
        }
        return retorno;
    }
}
