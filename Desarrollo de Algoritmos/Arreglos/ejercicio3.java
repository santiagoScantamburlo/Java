import utiles.TecladoIn;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        char[] arreglo = new char[10];
        String cadena = "";
        boolean valida = false, continuar = true;
        int opcion;

        while (!valida) {
            System.out.println("Ingrese una cadena de 10 caracteres: ");
            cadena = TecladoIn.readLine();
            if (cadena.length() == 10) {
                valida = true;
            }
        }

        cargarArreglo(arreglo, cadena);
        while (continuar) {
            menu();
            opcion = pufu.nextInt();

            switch (opcion) {
                case 1:
                    mostrarOrdenado(arreglo);
                    break;
                case 2:
                    mostrarInvertido(arreglo);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
            }
        }

    }

    public static void cargarArreglo(char[] arreglo, String cadena) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = cadena.charAt(i);
        }
    }

    public static void menu() {
        System.out.println("Seleccione la accion que desea realizar");
        System.out.println("1: Mostrar cadena en orden");
        System.out.println("2: Mostrar cadena invertida");
        System.out.println("0: Terminar");
    }

    public static void mostrarOrdenado(char[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);

        }
        System.out.println();
    }

    public static void mostrarInvertido(char[] arreglo) {
        for (int i = arreglo.length - 1; i >= 0; i--) {
            System.out.print(arreglo[i]);
        }
        System.out.println();
    }
}
