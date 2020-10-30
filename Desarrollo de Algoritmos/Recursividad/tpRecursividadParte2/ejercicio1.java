package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int a, b, resultado;

        System.out.println("Ingrese un numero a dividir: ");
        a = pufu.nextInt();
        System.out.println("Ingrese el numero por el que va a dividir: ");
        b = pufu.nextInt();

        resultado = calcularDivision(a, b);

        System.out.println(a + "/" + b + ": " + resultado);
    }

    public static int calcularDivision(int a, int b) {
        int retorno;

        if (a > b) {// Mientras que 'a' sea menor a 'b', hace la resta entre ambos y suma 1 al
                    // retorno, luego vuelve a llamar hasta que sean iguales o 'b' sea mayor a 'a'
            a -= b;
            retorno = 1 + calcularDivision(a, b);
        } else if (a == b) {
            // Si 'a' es igual a 'b', retorna 1
            retorno = 1;
        } else {
            // Si 'b' es mayor a 'a', retorna 0
            retorno = 0;
        }
        return retorno;
    }
}
