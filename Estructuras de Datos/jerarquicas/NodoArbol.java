/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.dinamicas;

/**
 *
 * @author Santi
 */
public class NodoArbol {
    
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    public NodoArbol(Object nuevoElemento, NodoArbol izq, NodoArbol der) {
        this.elem = nuevoElemento;
        this.izquierdo = izq;
        this.derecho = der;
    }
    
    public Object getElem() {
        return this.elem;
    }
    
    public NodoArbol getIzquierdo() {
        return this.izquierdo;
    }
    
    public NodoArbol getDerecho() {
        return this.derecho;
    }
    
    public void setElem(Object nuevoElemento) {
        this.elem = nuevoElemento;
    }
    
    public void setIzquierdo(NodoArbol nuevoIzq) {
        this.izquierdo = nuevoIzq;
    }
    
    public void setDerecho(NodoArbol nuevoDer) {
        this.derecho = nuevoDer;
    }
}
