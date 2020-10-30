package tpRecursividadParte2;

import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int num, factorial;

        System.out.println("Ingrese un numero para calcular su factorial: ");
        num = pufu.nextInt();

        factorial = calcularFactorial(num);
        System.out.println(num + "! = " + factorial);
    }

    public static int calcularFactorial(int n) {
        int retorno = 1;
        if (n != 1) { // Mientras que n sea diferente de 1, multiplica el retorno por el valor de n, y
                      // luego por el llamado del modulo, con n - 1
            retorno *= n * calcularFactorial(n - 1);
        }
        return retorno;
    }
}
