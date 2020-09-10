import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] arreglo;
        int num, promedio, longitud, suma = 0;

        System.out.println("Ingrese la longitud del arreglo: ");
        longitud = pufu.nextInt();
        arreglo = new int[longitud];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese un numero: ");
            num = pufu.nextInt();
            arreglo[i] = num;
        }

        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        promedio = suma / longitud;
        System.out.println("El promedio de los valores almacenados es: " + promedio);
    }
}
