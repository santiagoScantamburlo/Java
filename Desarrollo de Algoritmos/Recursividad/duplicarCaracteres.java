public class duplicarCaracteres {
    public static void main(String[] args) {
        String cadena = "saco";
        System.out.println(duplicar(cadena, cadena.length() - 1));
    }

    public static String duplicar(String cadena, int n) {
        String retorno;
        char letra = cadena.charAt(n);
        if (n == 0) {
            retorno = "" + letra + letra;
        } else {
            retorno = duplicar(cadena, n - 1) + letra + letra;
        }
        return retorno;
    }
}
