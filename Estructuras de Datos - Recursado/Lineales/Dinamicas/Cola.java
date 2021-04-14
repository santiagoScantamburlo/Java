package Dinamicas;

public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object nuevoElem) {
        boolean exito = true;
        Nodo nuevo = new Nodo(nuevoElem, null);
        if (this.fin != null) {
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        } else {
            this.fin = nuevo;
            this.frente = nuevo;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = false;
        if (this.frente == null) {
            this.fin = null;
        } else {
            this.frente = this.frente.getEnlace();
            exito = true;
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object retorno;
        if (this.frente == null) {
            retorno = null;
        } else {
            retorno = this.frente.getElem();
        }
        return retorno;
    }

    public boolean esVacia() {
        boolean vacia = true;
        if (this.frente != null) {
            vacia = false;
        }
        return vacia;
    }

    public void vaciar() {
        this.frente = null;
        this.fin = null;
    }

    public Cola clone() {
        Cola clon = new Cola();

        if (this.frente != null) {
            Nodo frente = this.frente;
            clon = cloneAux(clon, frente);
        }
        return clon;
    }

    private Cola cloneAux(Cola clonAux, Nodo frente) {
        Object elem;

        if (frente.getEnlace() != null) {
            elem = frente.getElem();
            clonAux = cloneAux(clonAux, frente.getEnlace());
            Nodo n = new Nodo(elem, clonAux.frente);
            clonAux.frente = n;
        } else {
            elem = frente.getElem();
            Nodo n = new Nodo(elem, null);
            clonAux.fin = n;
            clonAux.frente = n;
        }
        return clonAux;
    }

    public String toString() {
        String retorno;

        if (this.frente != null) {
            retorno = "[" + toStringPaso(this.frente) + "]";
        } else {
            retorno = "Cola vacia!";
        }
        return retorno;
    }

    public String toStringPaso(Nodo frente) {
        String retornoAux;

        if (frente.getEnlace() != null) {
            retornoAux = frente.getElem().toString() + "," + toStringPaso(frente.getEnlace());
        } else {
            retornoAux = frente.getElem().toString();
        }
        return retornoAux;
    }
}
