package TDA;

import java.util.Scanner;

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
                    cargado = true;
                    break;
                case 2:
                    mostrarDatosBoxeadores(arreglo, cargado);
                    break;
                case 3:
                    buscarVictorias(arreglo, cargado);
                    break;
                case 0:
                    continuar = false;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    public static void menu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Ingrese la accion a realizar: ");
        System.out.println("1: Cargar datos");
        System.out.println("2: Mostrar datos de boxeadores según categoría");
        System.out.println("3: Buscar los boxeadores a los que les puede ganar uno dado");
        System.out.println("0: Salir");
        System.out.println("--------------------------------------------------------------");
    }

    public static void cargarArreglo(Boxeador[] a) {
        Scanner pufu = new Scanner(System.in);
        Boxeador b;
        String apellido;
        double estatura;
        int peso;

        for (int i = 0; i < a.length; i++) {
            System.out.println("Ingrese el/los apellido/s del boxeador");
            apellido = pufu.nextLine();
            System.out.println("Ingrese la estatura del boxeador");
            estatura = pufu.nextDouble();
            System.out.println("Ingrese el peso del boxeador");
            peso = pufu.nextInt();

            b = new Boxeador(apellido, estatura, peso);
            a[i] = b;
        }
    }

    public static void mostrarDatosBoxeadores(Boxeador[] a, boolean cargado) {
        Scanner pufu = new Scanner(System.in);
        int i = 0;
        char categoria;

        System.out.println("Ingrese la categoria en la que desea buscar (P, C, S)");
        categoria = pufu.next().charAt(0);
        while(i < a.length && cargado) {
            if(a[i].getCategoria() == categoria) {
                System.out.println(a[i].toString());
                System.out.println("------------------------------------------------------");
            }
            i++;
        }
    }

    public static void buscarVictorias(Boxeador[] a, boolean cargado) {
        Scanner pufu = new Scanner(System.in);
        Boxeador b;
        String apellido;
        double estatura;
        int peso;
        char categoria;

        if(cargado) {
            apellido = "";
            System.out.println("Ingrese el/los apellido/s del boxeador");
            apellido = pufu.nextLine();
            System.out.println("Ingrese la estatura del boxeador");
            estatura = pufu.nextDouble();
            System.out.println("Ingrese el peso del boxeador");
            peso = pufu.nextInt();

            b = new Boxeador(apellido, estatura, peso);
            categoria = b.getCategoria();

            System.out.println("A continuacion se muestran los boxeadores contra los que puede ganar");
            for (int i = 0; i < a.length; i++) {
                if(a[i].getCategoria() == categoria) {
                    if(b.puedeGanarle(a[i])) {
                        System.out.println(a[i].toString());
                        System.out.println("-----------------------------------------------");
                    }
                }
            }
        }
    }
}