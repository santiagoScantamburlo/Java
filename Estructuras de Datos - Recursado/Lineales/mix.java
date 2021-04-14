public class mix {
    public static void main(String[] args) {
        Cola q1 = new Cola();
        Cola q2;
        q1.poner('A');
        q1.poner('B');
        q1.poner('$');
        q1.poner('C');
        q1.poner('$');
        q1.poner('D');
        q1.poner('E');
        q1.poner('F');

        q2 = generarOtraCola(q1);

        System.out.println(q2.toString());
    }

    public static Cola generarOtraCola(Cola q1) {
        Cola retorno = new Cola();
        Cola clon = q1.clone();
        Pila p1 = new Pila();

        while (!clon.esVacia()) {
            Object elem = clon.obtenerFrente();
            if (elem.toString().charAt(0) != '$') {
                p1.apilar(elem);
                retorno.poner(elem);
                clon.sacar();
            } else {
                ponerInverso(retorno, p1);
                retorno.poner(elem);
                clon.sacar();
            }
        }
        ponerInverso(retorno, p1);
        return retorno;
    }

    public static void ponerInverso(Cola retorno, Pila p1) {
        while (!p1.esVacia()) {
            Object elem = p1.obtenerTope();
            retorno.poner(elem);
            p1.desapilar();
        }
    }
}
