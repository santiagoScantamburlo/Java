package Dinamicas;

public class Lista {
    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar(Object elem, int pos) {
        boolean exito = false;

        if (pos >= 1 && pos <= this.longitud + 1) {
            if (pos == 1) {
                this.cabecera = new Nodo(elem, this.cabecera);
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            this.longitud++;
            exito = true;
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = false;
        Nodo aux = this.cabecera;

        if (pos > 0 && pos < this.longitud + 1) {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = aux.getEnlace().getEnlace();
                aux.setEnlace(nuevo);
            }
            this.longitud--;
            exito = true;
        }
        return exito;
    }

    public Object recuperar(int pos) {
        Object retorno = null;

        if (pos > 0 && pos <= this.longitud()) {
            Nodo aux = this.cabecera;
            int i = 1;
            while (pos != i) {
                aux = aux.getEnlace();
                i++;
            }
            retorno = aux.getElem();
        }
        return retorno;
    }

    public int localizar(Object buscado) {
        int pos = -1;
        Nodo aux = this.cabecera;
        boolean encontrado = false;
        int i = 1;

        while (i < this.longitud + 1 && !encontrado) {
            if (aux.getElem().toString().compareTo(buscado.toString()) == 0) {
                encontrado = true;
                pos = i;
            } else {
                aux = aux.getEnlace();
                i++;
            }
        }

        return pos;
    }

    public int longitud() {
        int retorno;
        if (this.cabecera != null) {
            retorno = this.longitud;
        } else {
            retorno = 0;
        }
        return retorno;
    }

    public boolean esVacia() {
        boolean vacia = false;

        if (this.longitud == 0) {
            vacia = true;
        }
        return vacia;
    }

    public void vaciar() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public Lista clone() {
        Lista clon = new Lista();
        clon = cloneAux(clon, this.cabecera);
        clon.longitud = this.longitud;

        return clon;
    }

    private Lista cloneAux(Lista aux, Nodo cab) {
        if (cab != null) {
            aux = cloneAux(aux, cab.getEnlace());
            Nodo n = new Nodo(cab.getElem(), aux.cabecera);
            aux.cabecera = n;
        }
        return aux;
    }

    public String toString() {
        String retorno = "Lista vacia!";
        if (this.cabecera != null) {
            retorno = "[";
            Nodo aux = this.cabecera;
            while (aux != null) {
                retorno = retorno + aux.getElem().toString();
                if (aux.getEnlace() != null) {
                    retorno += ",";
                }
                aux = aux.getEnlace();
            }
            retorno += "]";
        }
        return retorno;
    }
}
