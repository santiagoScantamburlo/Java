public class Pila {
    private static final int TAMANIO = 10;
    private Object[] arreglo;
    private int tope;

    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        boolean exito;

        if (this.tope + 1 >= TAMANIO) {
            exito = false;
        } else {
            this.tope++;
            this.arreglo[this.tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito;

        if (esVacia()) {
            exito = false;
        } else {
            this.arreglo[this.tope] = null;
            exito = true;
            this.tope--;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object retorno;

        if (esVacia()) {
            retorno = null;
        } else {
            retorno = this.arreglo[this.tope];
        }
        return retorno;
    }

    public boolean esVacia() {
        boolean vacia;

        if (this.tope == -1) {
            vacia = true;
        } else {
            vacia = false;
        }
        return vacia;
    }

    public void vaciar() {
        while (!esVacia()) {
            this.arreglo[this.tope] = null;
            this.tope--;
        }
    }

    public Pila clone() {
        Pila clon = new Pila();
        clon.tope = this.tope;
        for (int i = 0; i <= this.tope; i++) {
            clon.arreglo[i] = this.arreglo[i];
        }
        return clon;
    }

    public String toString() {
        String retorno;
        int i = 0;

        if (!esVacia()) {
            retorno = "[";
            while (i <= this.tope) {
                if (i < this.tope) {
                    retorno += this.arreglo[i] + " - ";
                    i++;
                } else {
                    retorno += this.arreglo[i];
                    i++;
                }
            }
            retorno += "]";
        } else {
            retorno = "Pila vacia!";
        }
        return retorno;
    }

    public boolean esCapicua() {
        boolean capicua = true;
        Pila clon1 = this.clone(), clon2 = this.clone(), aux = new Pila();
        Object elemAux;

        while (!clon2.esVacia()) {
            elemAux = clon2.obtenerTope();
            clon2.desapilar();
            aux.apilar(elemAux);
        }
        while (!clon1.esVacia() && capicua) {
            if (clon1.obtenerTope().equals(aux.obtenerTope())) {
                capicua = true;
                clon1.desapilar();
                aux.desapilar();
            } else {
                capicua = false;
            }
        }
        return capicua;
    }
}