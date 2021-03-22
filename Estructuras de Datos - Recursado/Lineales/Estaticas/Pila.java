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

        if (this.tope == -1) {
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

        if (this.tope == -1) {
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
        while (this.tope != -1) {
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
}