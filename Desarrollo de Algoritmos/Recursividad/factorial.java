import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int n, factorial;

        System.out.println("Ingrese el numero del que desea calcular el factorial");
        n = pufu.nextInt();
        factorial = calcularFactorial(n);
        System.out.println(n + "! = " + factorial);
    }

    public static int calcularFactorial(int n) {
        int retorno = 1;
        if(n != 0) {
            retorno *= n * calcularFactorial(n - 1);
        }
        return retorno;
    }
}
