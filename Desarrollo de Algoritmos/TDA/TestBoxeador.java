import java.util.Scanner;
import utiles.TecladoIn;

public class TestBoxeador {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int opcion, cant;
        boolean cargado = false, continuar = true;
        Boxeador[] arreglo;

        System.out.println("Ingrese la cantidad de boxeadores que va a cargar");
        cant = pufu.nextInt();
        arreglo = new Boxeador[cant];

        while (continuar) {
            menu();
            opcion = pufu.nextInt();

            switch (opcion) {
                case 1:
                    cargarArreglo(arreglo);
                    cargado = true; // Se modifica el valor de verdad ya que se cargo el arreglo
                    break;
                case 2:
                    mostrarDatosBoxeadores(arreglo, cargado);
                    break;
                case 3:
                    buscarVictorias(arreglo, cargado);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    // Este modulo muestra todas las opciones disponibles para ejecutar
    public static void menu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Ingrese la accion a realizar: ");
        System.out.println("1: Cargar datos");
        System.out.println("2: Mostrar datos de boxeadores según categoría");
        System.out.println("3: Buscar los boxeadores a los que les puede ganar uno dado");
        System.out.println("0: Salir");
        System.out.println("--------------------------------------------------------------");
    }

    // Este modulo se encarga de cargar todas las posiciones del arreglo
    public static void cargarArreglo(Boxeador[] a) {
        Scanner pufu = new Scanner(System.in);
        Boxeador b;
        String apellido;
        double estatura;
        int peso;

        for (int i = 0; i < a.length; i++) {
            System.out.println("Ingrese el/los apellido/s del boxeador");
            apellido = TecladoIn.readLine();
            System.out.println("Ingrese la estatura del boxeador");
            estatura = pufu.nextDouble();
            System.out.println("Ingrese el peso del boxeador");
            peso = pufu.nextInt();

            b = new Boxeador(apellido, estatura, peso);
            a[i] = b;
        }
    }

    // Este modulo muestra por pantalla los datos de todos los boxeadores cargados
    public static void mostrarDatosBoxeadores(Boxeador[] a, boolean cargado) {
        Scanner pufu = new Scanner(System.in);
        int i = 0;
        char categoria;

        System.out.println("Ingrese la categoria en la que desea buscar (P, C, S)");
        categoria = pufu.next().charAt(0);
        while (i < a.length && cargado) { // Si el arreglo no esta cargado no es recorrido
            if (a[i].getCategoria() == categoria) { // Verifica si
                System.out.println(a[i].toString());
                System.out.println("------------------------------------------------------");
            }
            i++;
        }
    }

    // Este modulo recorre el arreglo buscando los boxeadores a los que les puede
    // ganar un competidor ingresado
    public static void buscarVictorias(Boxeador[] a, boolean cargado) {
        Scanner pufu = new Scanner(System.in);
        int pos = -1;
        char categoria;

        if (cargado) { // No inicia la busqueda si el arreglo no esta cargado
            while (pos < 0 || pos >= a.length) {
                System.out.println("Ingrese la posicion del boxeador que desea comparar: ");
                pos = pufu.nextInt();
            }
            Boxeador b = a[pos];
            categoria = b.getCategoria();

            System.out.println("A continuacion se muestran los boxeadores contra los que puede ganar: ");
            for (int i = 0; i < a.length; i++) {
                if (a[i].getCategoria() == categoria && b.puedeGanarle(a[i])) { // Verifica si son de la misma categoria
                    System.out.println(a[i].toString());
                    System.out.println("-----------------------------------------------");

                }
            }
        }
    }
}