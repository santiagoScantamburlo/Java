/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Santi
 */
public class Pila {

    private Object[] arreglo;
    private int tope;
    private static final int tamanio = 10;

    public Pila() {
        this.arreglo = new Object[tamanio];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        boolean exito;

        if (this.tope + 1 >= this.tamanio) {
            exito = false;
        } else {
            this.tope++;
            this.arreglo[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito;

        if (this.tope >= 0) {
            this.arreglo[tope] = null;
            this.tope--;
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object retorno;

        if (this.tope != -1) {
            retorno = this.arreglo[tope];
        } else {
            retorno = null;
        }
        return retorno;
    }

    public boolean esVacia() {
        boolean vacia;

        if (this.tope != -1) {
            vacia = false;
        } else {
            vacia = true;
        }
        return vacia;
    }

    public Pila clone() {
        Pila clon = new Pila();
        int i = 0;

        while (i <= this.tope) {
            clon.arreglo[i] = this.arreglo[i];
            i++;
        }
        clon.tope = this.tope;
        return clon;
    }

    public void vaciar() {
        int i = 0;
        while (i <= this.tope) {
            this.arreglo[i] = null;
        }
    }

    public String toString() {
        String cadena;
        int i = 0;

        if (!esVacia()) { //Mientras que la pila no sea vacia, recorre desde la primera posicion hasta el tope
            cadena = "[";
            while (i <= this.tope) {
                cadena = cadena + this.arreglo[i].toString();
                if (i < this.tope) {
                    cadena = cadena + ",";
                }
                i++;
            }
            cadena = cadena + "]";
        } else {
            cadena = "Pila Vacia!";
        }
        return cadena;
    }
}
