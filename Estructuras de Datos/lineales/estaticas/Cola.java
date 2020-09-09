package lineales.estaticas;

/**
 *
 * @author Santi
 */
public class Cola {

    private static final int TAMANIO = 10;
    private int frente;
    private int fin;
    Object[] arreglo;

    public Cola() {
        this.arreglo = new Object[TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object elemento) {
        boolean exito = false;

        if (((this.fin + 1) % TAMANIO != this.frente)) {
            this.arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = true;

        if (this.frente == this.fin) {
            exito = false;
        } else {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object retorno;
        retorno = this.arreglo[this.frente];
        return retorno;
    }

    public boolean esVacia() {
        boolean vacia = false;

        if (this.frente == this.fin) {
            vacia = true;
        }
        return vacia;
    }

    public void vaciar() {
        for (int i = 0; i < this.arreglo.length; i++) {
            this.arreglo[i] = null;
        }
        this.frente = 0;
        this.fin = 0;
    }

    public Cola clone() {
        Cola clon = new Cola();
        int i = 0;

        while (i < this.TAMANIO) {
            clon.arreglo[i] = this.arreglo[i];
            i++;
        }
        clon.frente = this.frente;
        clon.fin = this.fin;
        return clon;
    }

    public String toString() {
        String retorno = "Cola vacia!";

        if (this.frente != this.fin) {
            retorno = "[";
            for (int i = this.frente; i != this.fin; i = (i + 1) % TAMANIO) {
                retorno += this.arreglo[i].toString();
                if ((i + 1) % TAMANIO != this.fin) {
                    retorno += ",";
                }
            }
            retorno += "]";
        }
        return retorno;
    }
}
