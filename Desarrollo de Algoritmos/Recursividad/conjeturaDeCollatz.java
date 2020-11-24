public class conjeturaDeCollatz {

    public static void main(String[] args) {
        recursivo(83);
    }

    public static void recursivo(int n) {
        if (n != 1) {
            if (n % 2 == 0) {
                System.out.print(n + " / 2 = ");
                n /= 2;
                System.out.println(n);
                if (n % 2 != 0) {
                    System.out.println("");
                }
                recursivo(n);
            } else {
                System.out.print("(" + n + " * 3) + 1 = ");
                n = ((n * 3) + 1);
                System.out.println(n);
                recursivo(n);
            }
        } else {
            System.out.println(n);
        }
    }
}