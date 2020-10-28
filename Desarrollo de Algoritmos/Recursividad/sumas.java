import java.util.Scanner;

public class sumas {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int opcion, n1, n2;

        System.out.println("Ingrese la opcion que desea realizar: ");
        System.out.println("1: Rango hasta un numero dado");
        System.out.println("2: Rango de un numero dado a otro");
        System.out.println("3: Suma hasta un numero");
        opcion = pufu.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el numero hasta el que desea mostrar el rango");
                n1 = pufu.nextInt();
                System.out.println(rangoHasta(n1, 0));
                break;
            case 2:
                System.out.println("Ingrese de que numero quiere empezar");
                n1 = pufu.nextInt();
                System.out.println("Ingrese el numero hasta el que desea mostrar el rango");
                n2 = pufu.nextInt();
                System.out.println(rango(n1, n2, n1));
                break;
            case 3:
                System.out.println("Ingrese el numero hasta el que desea hacer la suma");
                n1 = pufu.nextInt();
                System.out.println(sumaHasta(n1));
                break;
        }
    }

    public static String rangoHasta(int n, int i) {
        String retorno = "";
        if (i != n) {
            if (i == 0) {
                retorno = "[" + i + ", " + rangoHasta(n, i + 1);
            } else {
                retorno += i + ", " + rangoHasta(n, i + 1);
            }
        } else {
            retorno = i + "]";
        }
        return retorno;
    }

    public static String rango(int n1, int n2, int i) {
        String retorno = "";
        if (i != n2) {
            if (i == n1) {
                retorno = "[" + i + "," + rango(n1, n2, i + 1);
            } else {
                retorno += i + ", " + rango(n1, n2, i + 1);
            }
        } else {
            retorno = i + "]";
        }
        return retorno;
    }

    public static int sumaHasta(int n) {
        return 1;
    }
}
