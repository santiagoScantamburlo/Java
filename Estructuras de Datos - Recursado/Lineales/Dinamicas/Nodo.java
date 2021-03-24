package Dinamicas;
public class Nodo {
    private Object elem;
    private Nodo enlace;

    public Nodo(Object nuevoElem, Nodo nuevoNodo) {
        this.elem = nuevoElem;
        this.enlace = nuevoNodo;
    }

    public Object getElem() {
        return this.elem;
    }

    public Nodo getEnlace() {
        return this.enlace;
    }

    public void setElem(Object nuevoElem) {
        this.elem = nuevoElem;
    }

    public void setEnlace(Nodo nuevoNodo) {
        this.enlace = nuevoNodo;
    }
}
