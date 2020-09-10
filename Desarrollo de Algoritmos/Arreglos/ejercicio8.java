import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        char[] arreglo;
        int longitud = 0, opcion;
        boolean valida = false, continuar = true;

        while (!valida) {
            System.out.println("Ingrese la longitud del arreglo: ");
            longitud = pufu.nextInt();
            if (longitud <= 100) {
                valida = true;
            }
        }
        arreglo = new char[longitud];

        cargarArreglo(arreglo);

        while (continuar) {
            menu();
            opcion = pufu.nextInt();
            switch (opcion) {
                case 1:
                    mostrarArreglo(arreglo);
                    break;
                case 2:
                    buscarLetra(arreglo);
                    break;
                case 3:
                    contarOcurrencias(arreglo);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }
        }
    }

    public static void cargarArreglo(char[] arreglo) {
        Scanner pufu = new Scanner(System.in);
        boolean esLetra;
        char letra = '\0';
        for (int i = 0; i < arreglo.length; i++) {
            esLetra = false;
            while (!esLetra) {
                System.out.println("Ingrese una letra: ");
                letra = pufu.next().charAt(0);
                if (Character.isLetter(letra)) {
                    esLetra = true;
                }
            }
            arreglo[i] = letra;
        }
    }

    public static void menu() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ingrese la opcion que desea realizar: ");
        System.out.println("1: Ver el contenido del arreglo");
        System.out.println("2: Verificar si una letra se encuentra en el arreglo");
        System.out.println("3: Contar las ocurrencias de una letra");
        System.out.println("0: Terminar");
        System.out.println("-----------------------------------------------------------");
    }

    public static void mostrarArreglo(char[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (i + 1 != arreglo.length) {
                System.out.print(arreglo[i] + " - ");
            } else {
                System.out.println(arreglo[i]);
            }
        }
    }

    public static void buscarLetra(char[] arreglo) {
        Scanner pufu = new Scanner(System.in);
        int i = 0;
        char letra;
        boolean encontrada = false;

        System.out.println("Ingrese una letra: ");
        letra = pufu.next().charAt(0);

        while (!encontrada && i < arreglo.length) {
            if (arreglo[i] == letra) {
                encontrada = true;
                System.out.println("La letra se encuentra en el arreglo");
            } else {
                i++;
            }
        }
        if (!encontrada) {
            System.out.println("La letra no se encuentra en el arreglo");
        }
    }

    public static void contarOcurrencias(char[] arreglo) {
        Scanner pufu = new Scanner(System.in);
        int ocurrencias = 0;
        char letra;

        System.out.println("Ingrese una letra: ");
        letra = pufu.next().charAt(0);

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == letra) {
                ocurrencias++;
            }
        }
        System.out.println("La letra '" + letra + "' se repite " + ocurrencias + " veces");
    }
}