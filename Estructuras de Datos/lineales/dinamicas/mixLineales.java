package lineales.dinamicas;

/**
 *
 * @author Santi
 */
public class mixLineales {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Lista lista = new Lista();
        Pila pila = new Pila();
        int[] arreglo = { 1, 2, 3, 4, 5 };

        for (int i = 0; i < arreglo.length; i++) {
            cola.poner(arreglo[i]);
        }
        System.out.println(cola.toString());

        Cola colaClon = cola.clone();

        while (!colaClon.esVacia()) {
            Object aux = colaClon.obtenerFrente();
            lista.insertar(aux, lista.longitud() + 1);
            pila.apilar(aux);
            colaClon.sacar();
        }
        System.out.println("Lista: " + lista.toString());
        System.out.println("Pila: " + pila.toString());

        while (!pila.esVacia()) {
            Object aux = pila.obtenerTope();
            lista.insertar(aux, lista.longitud() + 1);
            pila.desapilar();
        }
        System.out.println("Lista: " + lista.toString());
    }
}
