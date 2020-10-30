package tpRecursividad;

import java.util.Scanner;

/**
 * ejercicio4
 */
public class ejercicio4 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int num;

        System.out.print("Ingrese un numero: ");
        num = pufu.nextInt();

        if (verificarDigitos(num, num % 10)) {
            System.out.println("Todos los digitos son iguales");
        } else {
            System.out.println("Los digitos no son iguales");
        }
    }

    public static boolean verificarDigitos(int n, int i) {
        boolean retorno = false;

        if (n >= 10) { // Mientras que el numero sea mayor o igual a 10 verifica desarmandolo
            if (n % 10 == i) { // Si el ultimo digito es igual, entonces el retorno sera verdadero y llama al
                               // modulo quitandole el ultimo digito
                retorno = true && verificarDigitos(n / 10, i); // En caso de que en uno de los llamados no se cumpla la
                                                               // condicio el retorno sera falso
            }
        } else {
            // Si el numero es menor a 10, verifica que sean iguales, en caso de serlo
            // retorna verdadero
            if (n == i) {
                retorno = true;
            }
        }
        return retorno;
    }
}