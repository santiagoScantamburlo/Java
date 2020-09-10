import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        String[] arreglo;
        String palabra, palabraMasLarga = "";
        int longitud, masLarga = 0;

        System.out.println("Ingrese la longitud del arreglo: ");
        longitud = pufu.nextInt();
        arreglo = new String[longitud];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese una palabra: ");
            palabra = pufu.next();
            arreglo[i] = palabra;
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].length() >= masLarga) {
                palabraMasLarga = arreglo[i];
                masLarga = palabraMasLarga.length();
            }
        }

        System.out.println("La palabra ''" + palabraMasLarga + "'' es la mas larga");
    }
}
