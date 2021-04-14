package Dinamicas;

public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem) {
        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        this.tope = nuevo;
        return true;
    }

    public boolean desapilar() {
        boolean exito;

        if (this.tope == null) { // Verifica que la pila no este vacia
            exito = false; // Si esta vacia retorna falso
        } else {
            this.tope = this.tope.getEnlace(); // Sino, le asigna al tope su enlace
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object retorno;
        if (this.tope == null) { // Verifica que la pila no este vacia
            retorno = null; // Si esta vacia retorna null
        } else {
            retorno = this.tope.getElem(); // Sino, retorno el elemento almacenado en el tope
        }
        return retorno;
    }

    public boolean esVacia() {
        return this.tope == null;
    }

    public void vaciar() {
        this.tope = null; // Le asigna null al tope, y el garbage collector elimina el resto de la pila
    }

    public Pila clone() {
        Pila clon = new Pila();
        this.cloneRecursivo(clon, this.tope);
        return clon;
    }

    public void cloneRecursivo(Pila clon, Nodo enlace) {
        if (enlace != null) { // Si no esta en la primera posicion de la pila:
            Nodo enlaceTope = enlace.getEnlace(); // Pasa a la siguiente posicion
            cloneRecursivo(clon, enlaceTope); // Invoca al modulo que repite el proceso hasta llegar a la primera
                                              // posicion
            clon.tope = new Nodo(enlace.getElem(), clon.tope); // Le asigna al tope la primera posicion y comienza a
                                                               // volver en el paso recursivo
        }
    }

    public String toString() {
        String retorno;
        if (this.tope != null) { // Si la pila no esta vacia llama al paso recursivo
            retorno = "[" + toStringPaso(this.tope) + "]";
        } else { // Sino, retorna que la pila esta vacia
            retorno = "Pila vacia!";
        }
        return retorno;
    }

    private String toStringPaso(Nodo actual) {
        String elemento;
        if (actual.getEnlace() != null) { // Si no se encuentra en la primera posicion, sigue el paso recursivo y
                                          // concatena el elemento actual
            elemento = this.toStringPaso(actual.getEnlace()) + "," + actual.getElem().toString();
        } else { // Si esta en la primera posicion, concatena el elemento actual y vuelve
            elemento = actual.getElem().toString();
        }
        return elemento;
    }
}