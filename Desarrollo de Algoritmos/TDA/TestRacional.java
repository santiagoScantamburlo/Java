public class TestRacional {
    public static void main(String[] args) {
        Racional racional = new Racional(14, 22);
        System.out.println(racional.toString());
        racional.simplificar();
        System.out.println(racional.toString());
    }
}
