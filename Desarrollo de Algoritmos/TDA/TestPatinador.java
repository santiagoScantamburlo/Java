package TDA;

import java.util.Scanner;

public class TestPatinador {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        boolean cargado = false, continuar = true;
        int cant, opcion;
        Patinador[] arreglo;

        System.out.println("Ingrese la cantidad de patinadores a cargar");
        cant = pufu.nextInt();

        arreglo = new Patinador[cant];

        while (continuar) {
            menu();
            opcion = pufu.nextInt();

            switch (opcion) {
                case 1:
                    cargarDatos(arreglo);
                    cargado = true;
                    break;
                case 2:
                    mostrarDatosPatinadores(arreglo, cargado);
                    break;
                case 3:
                    subirDeCategoria(arreglo, cargado);
                    break;
                case 0:
                    continuar = false;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Ingrese la opcion deseada: ");
        System.out.println("1: Cargar datos");
        System.out.println("2: Mostras patinadores de una categoria dada");
        System.out.println("3: Ascender de categoria a un patinador");
        System.out.println("0: Salir");
        System.out.println("------------------------------------------------------------");
    }

    public static void cargarDatos(Patinador[] a) {
        Scanner pufu = new Scanner(System.in);
        Patinador p;
        int edad;
        char categoria;
        for (int i = 0; i < a.length; i++) {
            String apellido, nombre, dni;
            System.out.println("Ingrese el apellido del participante");
            apellido = pufu.nextLine();
            System.out.println("Ingrese el nombre del participante");
            nombre = pufu.nextLine();
            System.out.println("Ingrese el dni del participante");
            dni = pufu.nextLine();
            System.out.println("Ingrese la edad del participante");
            edad = pufu.nextInt();
            System.out.println("Ingrese la categoria del participante");
            categoria = pufu.next().charAt(0);

            p = new Patinador(apellido, nombre, dni, edad, categoria);
            a[i] = p;
        }
    }

    public static void mostrarDatosPatinadores(Patinador[] a, boolean cargado) {
        Scanner pufu = new Scanner(System.in);
        char cat;
        if (cargado) {
            System.out.println("Ingrese la categoria en la que quiere buscar (P/I/C/B/A");
            cat = pufu.next().charAt(0);

            for (int i = 0; i < a.length; i++) {
                if (a[i].getCategoria() == cat) {
                    System.out.println(a[i].toString());
                    System.out.println("------------------------------------------------");
                }
            }
        } else {
            System.out.println("No hay participantes cargados");
        }
    }

    public static void subirDeCategoria(Patinador[] a, boolean cargado) {
        Scanner pufu = new Scanner(System.in);
        int i = 0;
        boolean encontrado = false;
        String dni;

        if(cargado) {
            System.out.println("Ingrese el dni del patinador que tiene que subir de categoria");
            dni = pufu.nextLine();
            Patinador p = new Patinador(dni);

            while(i < a.length && !encontrado) {
                if(a[i].equals(p)) {
                    a[i].asciendeCategoria();
                    encontrado = true;
                }
            }
        } else {
            System.out.println("No hay participantes cargados");
        }
    }
}