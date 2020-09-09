/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Santi
 */
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object elem) {
        Nodo nuevo = new Nodo(elem, this.tope);
        this.tope = nuevo;
        return true;
    }

    public boolean desapilar() {
        boolean exito;
        
        if(this.tope != null) {
            Nodo aux = this.tope.getEnlace();
            this.tope = aux;
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object retorno;
        if(this.tope == null) {
            retorno = null;
        } else {
            retorno = this.tope.getElem();
        }
        return retorno;
    }

    public boolean esVacia() {
        boolean retorno;

        if (this.tope != null) {
            retorno = false;
        } else {
            retorno = true;
        }
        return retorno;
    }

    public void vaciar() {
        while (this.tope != null) {
            this.tope = this.tope.getEnlace();
        }
    }

    public Pila clone() {
        Pila clon = new Pila();
        this.clonePasoRecursivo(clon, this.tope);
        return clon;
    }

    private void clonePasoRecursivo(Pila clon, Nodo enlace) {
        if (enlace != null) { //Mientras que no este en la primera posicion de la pila hace el llamado recursivo
            Nodo enlaceTope = enlace.getEnlace(); //Toma el enlace del tope
            clonePasoRecursivo(clon, enlaceTope); //Hace el llamado recursivo pero ahora el enlace es el siguiente al del tope
            clon.tope = new Nodo(enlace.getElem(), clon.tope); //Apila una vez llega al final de la pila
        }
    }

    public String toString() {
        String retorno;

        if (this.tope != null) { //Mientras que la pila no sea vacia, la recorre de forma recursiva
            retorno = "[" + toStringPaso(this.tope) + "]"; //Hace el llamado recursivo recorriendo desde el tope hasta el principio de la pila
        } else {
            retorno = "Pila Vacia!";
        }
        return retorno;
    }

    private String toStringPaso(Nodo actual) {
        String elemento;
        if (actual.getEnlace() != null) {
            //Obtenemos el valor del nodo
            //Concatenamos el llamado con el elemento del siguiente
            elemento = this.toStringPaso(actual.getEnlace()) + "," + actual.getElem().toString();
        } else {
            elemento = actual.getElem().toString(); //Retorna el primer elemento de la pila
        }
        return elemento;
    }
}
