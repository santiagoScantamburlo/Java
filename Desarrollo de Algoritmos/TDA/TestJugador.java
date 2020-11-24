import java.util.Scanner;

public class TestJugador {
    public static Scanner pufu = new Scanner(System.in);

    public static void main(String[] args) {
        Jugador[] arreglo = new Jugador[3];
        boolean continuar = true, cargado = false;
        int opcion;

        while (continuar) {
            menu();
            opcion = pufu.nextInt();

            switch (opcion) {
                case 1:
                    cargarArreglo(arreglo);
                    cargado = true;
                    break;
                case 2:
                    cargarPuntaje(arreglo, cargado);
                    break;
                case 3:
                    consultarMasAlto(arreglo, cargado);
                    break;
                case 4:
                    mostrarRanking(arreglo, cargado);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }
        }
    }

    public static void menu() {
        System.out.println("Ingrese la opcion a realizar: ");
        System.out.println("1: Cargar arreglo");
        System.out.println("2: Cargar el puntaje de un jugador dado");
        System.out.println("3: Mostrar el puntaje mas alto de un jugador dado");
        System.out.println("4: Mostrar el ranking de los jugadores");
        System.out.println("0: Salir");
    }

    public static void cargarArreglo(Jugador[] a) {
        String nickname;
        Jugador j;

        for (int i = 0; i < a.length; i++) {
            System.out.println("Ingrese el nickname: ");
            nickname = pufu.nextLine();
            j = new Jugador(nickname);
            a[i] = j;
        }
    }

    public static void cargarPuntaje(Jugador[] a, boolean cargado) {
        Jugador j;
        String nickname;
        boolean encontrado = false;
        int puntos, i = 0;

        if (cargado) {
            System.out.println("Ingrese el nickname del jugador: ");
            nickname = pufu.nextLine();
            j = new Jugador(nickname);
            while (i < a.length && !encontrado) {
                if (a[i].equals(j)) {
                    System.out.println("Ingrese el puntaje: ");
                    puntos = pufu.nextInt();
                    a[i].sumarPuntos(puntos);
                    encontrado = true;
                } else {
                    i++;
                }
            }
        } else {
            System.out.println("El arreglo no esta cargado");
        }
    }

    public static void consultarMasAlto(Jugador[] a, boolean cargado) {
        int posicion = -1;

        if (cargado) {
            while (posicion < 0 && posicion >= a.length) {
                System.out.println("Ingrese una posicion para ver el puntaje mas alto: ");
                posicion = pufu.nextInt();
            }
            System.out.println("El puntaje mas alto del jugador " + a[posicion].getNickname() + " es: "
                    + a[posicion].puntajeMasAlto());
        }
    }

    public static void mostrarRanking(Jugador[] j, boolean cargado) {
        if (cargado) {
            for (int i = 0; i < j.length; i++) {
                System.out.println("Puntaje mas alto de " + j[i].getNickname() + " es: " + j[i].puntajeMasAlto());
            }
        }
    }
}