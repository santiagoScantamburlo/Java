package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int num, resultado;

        System.out.println("Ingrese un numero: ");
        num = pufu.nextInt();

        resultado = sumarDigitos(num);

        System.out.println("La suma de los digitos de " + num + " es: " + resultado);
    }

    public static int sumarDigitos(int n) {
        int retorno = 0;

        if (n >= 10) {
            // Mientras que sea mayor o igual a 10, hace la suma del ultimo digito y luego
            // llama al modulo sacandolo
            retorno += n % 10 + sumarDigitos(n / 10);
        } else {
            // Si es menor a 10, solo lo retorna
            retorno += n;
        }
        return retorno;
    }
}
