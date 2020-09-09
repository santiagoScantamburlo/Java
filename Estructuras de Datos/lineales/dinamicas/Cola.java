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
public class Cola {

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object elemento) {
        boolean exito = true;
        Nodo n = new Nodo(elemento, null);

        if (this.fin != null) {
            this.fin.setEnlace(n);
            this.fin = n;
        } else {
            this.fin = n;
            this.frente = n;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = false;

        if (this.frente != null) {
            this.frente = frente.getEnlace();
            exito = true;
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object retorno = null;

        if (this.frente != null) {
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
        Object elemento;
        
        if(frente.getEnlace() != null) {
            elemento = frente.getElem();
            clonAux = cloneAux(clonAux, frente.getEnlace());
            Nodo n = new Nodo(elemento, clonAux.frente);
            clonAux.frente = n;
        } else {
            elemento = frente.getElem();
            Nodo n = new Nodo(elemento, null);
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
        
        if(frente.getEnlace() != null) {
            retornoAux = frente.getElem().toString() + "," + toStringPaso(frente.getEnlace()); 
        } else {
            retornoAux = frente.getElem().toString();
        }
        return retornoAux;
    }
}
