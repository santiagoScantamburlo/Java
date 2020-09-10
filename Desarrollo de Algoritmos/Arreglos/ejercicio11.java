import java.util.Scanner;

public class ejercicio11 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        char[] arreglo;
        char caracter, buscado;
        int longitud;

        System.out.println("Ingrese la longitud del arreglo: ");
        longitud = pufu.nextInt();
        arreglo = new char[longitud];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese un caracter: ");
            caracter = pufu.next().charAt(0);
            arreglo[i] = caracter;
        }

        System.out.println("Ingrese el caracter que desea buscar: ");
        buscado = pufu.next().charAt(0);

        if (buscarCaracter(arreglo, buscado)) {
            System.out.println("El caracter '" + buscado + "' se encuentra en el arreglo");
            System.out.println(
                    "El caracter '" + buscado + "' se encuentra " + contarOcurrencias(arreglo, buscado) + " veces");
        }
    }

    public static boolean buscarCaracter(char[] arreglo, char buscado) {
        boolean encontrado = false;
        int i = 0;

        while (!encontrado) {
            if (arreglo[i] == buscado) {
                encontrado = true;
            } else {
                i++;
            }
        }
        return encontrado;
    }

    public static int contarOcurrencias(char[] arreglo, char buscado) {
        int ocurrencias = 0;

        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == buscado) {
                ocurrencias++;
            }
        }
        return ocurrencias;
    }
}
