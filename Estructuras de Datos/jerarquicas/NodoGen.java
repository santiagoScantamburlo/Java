/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santi
 */
public class NodoGen {
    
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    public NodoGen(Object nuevoElem, NodoGen hI, NodoGen hD) {
        this.elem = nuevoElem;
        this.hijoIzquierdo = hI;
        this.hermanoDerecho = hD;
    }
    
    public Object getElem() {
        return this.elem;
    }
    
    public NodoGen getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }
    
    public NodoGen getHermanoDerecho() {
        return this.hermanoDerecho;
    }
    
    public void setElem(Object nuevoElem) {
        this.elem = nuevoElem;
    }
    
    public void setHijoIzquierdo (NodoGen hI) {
        this.hijoIzquierdo = hI;
    }
    
    public void setHermanoDerecho(NodoGen hD) {
        this.hermanoDerecho = hD;
    }
}
