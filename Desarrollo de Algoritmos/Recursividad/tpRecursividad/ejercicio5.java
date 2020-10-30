package tpRecursividad;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int num, aux, i = 1;

        System.out.print("Ingrese un numero: ");
        num = pufu.nextInt();
        aux = num;

        while (aux >= 10) {// Itera mientras que el auxiliar sea mayor o igual a 10 y multiplico i * 10 en
                           // cada iteracion
            i *= 10;
            aux /= 10;
        }

        System.out.println(invertirNumero(num, i));
    }

    public static int invertirNumero(int n, int i) {
        int retorno = 0;

        if (n >= 10) {// Mientras que el numero sea mayor o igual a 10 multiplico el ultimo digito por
                      // i, y le sumo el retorno del siguiente llamado
            retorno += ((n % 10) * i) + invertirNumero(n / 10, i / 10); // Para el siguiente llamado elimino el ultimo
                                                                        // digito de n, y saco un 0 de i
        } else {
            //Sino, retorno el valor de n solo
            retorno = n;
        }
        return retorno;
    }
}
