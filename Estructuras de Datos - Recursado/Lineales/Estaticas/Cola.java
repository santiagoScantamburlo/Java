public class Cola {

    private Object[] arreglo;
    private static final int TAMANIO = 10;
    private int frente;
    private int fin;

    public Cola() {
        this.arreglo = new Object[TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object nuevoElem) {
        boolean exito = true;
        if (this.fin + 1 == this.frente) {
            exito = false;
        } else {
            this.arreglo[this.fin] = nuevoElem;
            this.fin = (this.fin + 1) % TAMANIO;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = true;
        if (this.frente == this.fin) {
            exito = false;
        } else {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente) % TAMANIO;
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object retorno;
        if (this.frente != this.fin) {
            retorno = this.arreglo[this.frente];
        } else {
            retorno = false;
        }
        return retorno;
    }

    public boolean esVacia() {
        boolean vacia;
        if (this.frente == this.fin) {
            vacia = true;
        } else {
            vacia = false;
        }
        return vacia;
    }

    public void vaciar() {
        int i = this.frente;
        while (i != this.fin) {
            this.arreglo[i] = null;
            i = (i + 1) % TAMANIO;
        }
        this.frente = 0;
        this.fin = 0;
    }

    public Cola clone() {
        Cola clon = new Cola();
        int i = this.frente;
        clon.frente = this.frente;
        clon.fin = this.fin;

        while (i != this.fin) {
            clon.arreglo[i] = this.arreglo[i];
            i = (i + 1) % TAMANIO;
        }
        return clon;
    }

    public String toString() {
        String retorno = "";
        if (this.frente == this.fin) {
            retorno = "Cola vacia!";
        } else {
            retorno += "[";
            int i = this.frente;
            while (i != this.fin) {
                if (i + 1 == this.fin) {
                    retorno += this.arreglo[i];
                } else {
                    retorno += this.arreglo[i] + ", ";
                }
                i = (i + 1) % TAMANIO;
            }
            retorno += "]";
        }
        return retorno;
    }
}