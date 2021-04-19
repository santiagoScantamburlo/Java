/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

/**
 *
 * @author Santi
 */
public class ArbolBin {

    private NodoArbol raiz;

    //Constructor
    public ArbolBin() {
        this.raiz = null;
    }

    /**
     * *
     *
     * @param elem
     * @param padre
     * @param pos
     * @return boolean
     */
    public boolean insertar(Object elem, Object padre, char pos) {
        boolean exito = true;

        if (this.raiz == null) {
            this.raiz = new NodoArbol(elem, null, null);
        } else {
            exito = insertarRecursivo(this.raiz, elem, padre, pos);
        }
        return exito;
    }

    /**
     * *
     *
     * @param raiz
     * @param elem
     * @param padre
     * @param pos
     * @return boolean
     */
    private boolean insertarRecursivo(NodoArbol raiz, Object elem, Object padre, char pos) {
        NodoArbol nuevoNodo;
        boolean retorno = false;

        if (raiz.getElem().equals(padre)) {
            if (pos == 'i' || pos == 'I' && raiz.getIzquierdo() == null) {
                nuevoNodo = new NodoArbol(elem, null, null);
                raiz.setIzquierdo(nuevoNodo);
                retorno = true;
            }
            if (pos == 'd' || pos == 'D' && raiz.getDerecho() == null) {
                nuevoNodo = new NodoArbol(elem, null, null);
                raiz.setDerecho(nuevoNodo);
                retorno = true;
            }
        } else {
            if (raiz.getIzquierdo() != null) {
                retorno = retorno || insertarRecursivo(raiz.getIzquierdo(), elem, padre, pos);
            }
            if (raiz.getDerecho() != null && !retorno) {
                retorno = retorno || insertarRecursivo(raiz.getDerecho(), elem, padre, pos);
            }
        }
        return retorno;
    }

    /**
     * *
     * Retorna true si el arbol esta vacio, y false si tiene al menos un
     * elemento
     *
     * @return boolean
     */
    public boolean esVacio() {
        boolean vacio = true;

        if (raiz != null) {
            vacio = false;
        }
        return vacio;
    }

    /**
     * *
     * Devuelve el padre de un elemento dado. Si el arbol es vacio retorna
     * "Arbol vacio" Si el elemento se encuentra en la raiz retorna "El elemento
     * es raiz" Si no se cumple ninguna de las anteriores, busca por el metodo
     * padreRecursivo
     *
     * @param elem
     * @return Object
     */
    public Object padre(Object elem) {
        Object retorno = null;
        if (this.raiz != null) {
            if (!this.raiz.getElem().equals(elem)) {
                retorno = padreRecursivo(this.raiz, elem, this.raiz.getElem());
            }
        }
        return retorno;
    }

    private Object padreRecursivo(NodoArbol raiz, Object hijo, Object elemRaiz) {
        Object retorno = null;
        if (raiz != null) {
            if (raiz.getElem().equals(hijo)) {
                retorno = elemRaiz;
            } else {
                retorno = padreRecursivo(raiz.getIzquierdo(), hijo, raiz.getElem());
                if (retorno == null) {
                    retorno = padreRecursivo(raiz.getDerecho(), hijo, raiz.getElem());
                }
            }
        }
        return retorno;
    }

    /**
     * *
     * Devuelve la altura del lado con más niveles En caso de estar vacio
     * retorna -1 En caso de ser solo la raiz retorna 0
     *
     * @return int
     */
    public int altura() {
        int r = -1;
        if (this.raiz != null) {
            NodoArbol aux = this.raiz;
            r = alturaAux(aux);
        }
        return r;
    }

    private int alturaAux(NodoArbol aux) {
        int altD = 0;
        int altIzq = 0;
        if (aux != null) {
            altD = alturaAux(aux.getDerecho()) + 1;
            altIzq = altIzq + alturaAux(aux.getIzquierdo()) + 1;
            if (altIzq >= altD) {
                altD = altIzq;
            }
        }
        return altD;
    }

    /**
     * *
     * Devuelve el nivel en el que se encuentra un elemento dado En caso de no
     * encontrarse en el arbol devuelve -1 En caso de ser raiz devuelve 0
     *
     * @param elemento
     * @return int
     */
    public int nivel(Object elemento) {
        int retorno = -1;

        if (this.raiz != null) {
            retorno = retorno + nivelRecursivo(this.raiz, elemento);
        }
        return retorno;
    }

    /**
     * *
     * llamado recursivo para poder contar los niveles de un elemento en un
     * arbol
     *
     * @param raiz
     * @param elemento
     * @return
     */
    private int nivelRecursivo(NodoArbol raiz, Object elemento) {
        //evaluamos si el elemento esta en los hijos de la raiz
        int retorno = 1;
        boolean encontrado = false;

        if (raiz.getElem().equals(elemento)) {
            retorno = 1;
        } else {
            //si el HI no es null, nos metemos
            if (raiz.getIzquierdo() != null) {
                int retornoIzquierda = nivelRecursivo(raiz.getIzquierdo(), elemento);
                if (retornoIzquierda > 0) {
                    retorno = 1 + retornoIzquierda;
                }
            } else {
                if (raiz.getDerecho() != null) {
                    int retornoDerecha = nivelRecursivo(raiz.getIzquierdo(), elemento);
                    if (retornoDerecha > 0 && !encontrado) {
                        retorno = 1 + retornoDerecha;
                    }
                }
            }
        }
        if (retorno == 0) {
            retorno = -1;
        }
        return retorno;
    }

    //Se hace uso del garbage collector para eliminar la estructura
    public void vaciar() {
        this.raiz = null;
    }

    /**
     * *
     * Retorna un arbol binario que es un clon del original
     *
     * @return ArbolBin
     */
    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();

        if (this.raiz != null) { //Verifica que la raiz no sea nula y crea un nuevo arbol vacio y llama al metodo auxiliar
            clon.raiz = new NodoArbol(this.raiz.getElem(), null, null);
            cloneAux(this.raiz, clon.raiz);
        }
        return clon;
    }

    /**
     * *
     * Realiza el recorrido del arbol original y asigna los elementos al clon
     *
     * @param raizOriginal
     * @param raizClon
     */
    private void cloneAux(NodoArbol raizOriginal, NodoArbol raizClon) {
        //Evalua si el original tiene hijo izquierdo
        if (raizOriginal.getIzquierdo() != null) {
            //Crea un nodo con los elementos del hijo izquierdo
            NodoArbol clonIzq = new NodoArbol(raizOriginal.getIzquierdo().getElem(), null, null);
            raizClon.setIzquierdo(clonIzq);
            cloneAux(raizOriginal.getIzquierdo(), raizClon.getIzquierdo());
        }
        //Evalua si el original tiene hijo derecho
        if (raizOriginal.getDerecho() != null) {
            //Crea un nodo con los elementos del hijo derecho
            NodoArbol clonDer = new NodoArbol(raizOriginal.getDerecho().getElem(), null, null);
            raizClon.setDerecho(clonDer);
            cloneAux(raizOriginal.getDerecho(), raizClon.getDerecho());
        }
    }

    //Recorridos de arboles
    /**
     * *
     * Recorre el arbol en preorden, haciendo uso de un metodo auxiliar
     *
     * @return Lista
     */
    public Lista listarPreorden() {
        Lista preorden = new Lista();
        //Llama al metodo auxiliar para recorrer el arbol
        preordenAux(this.raiz, 1, preorden);
        return preorden;
    }

    /**
     * *
     * Metodo auxiliar para recorrer de forma recursiva el arbol en preorden
     *
     * @param raiz
     */
    private void preordenAux(NodoArbol raiz, int i, Lista l) {
        if (raiz != null) {
            l.insertar(raiz.getElem(), i);
            preordenAux(raiz.getDerecho(), i + 1, l);
            preordenAux(raiz.getIzquierdo(), i + 1, l);
        }
    }

    /**
     * *
     * Recorre el arbol en inorden, haciendo uso de un metodo auxiliar
     *
     * @return Lista
     */
    public Lista listarInorden() {
        Lista inorden = new Lista();
        //Llama al metodo auxiliar para recorrer el arbol
        inordenAux(this.raiz, 1, inorden);
        return inorden;
    }

    /**
     * *
     * Metodo auxiliar para recorrer de forma recursiva el arbol en inorden
     *
     * @param raiz
     * @param i
     * @param l
     */
    private void inordenAux(NodoArbol raiz, int i, Lista l) {
        if (raiz != null) {
            inordenAux(raiz.getDerecho(), i, l);
            l.insertar(raiz.getElem(), i);
            inordenAux(raiz.getIzquierdo(), i++, l);
        }
    }

    /**
     * *
     * Recorre el arbol en posorden, haciendo uso de un metodo auxiliar
     *
     * @return Lista
     */
    public Lista listarPosorden() {
        Lista posorden = new Lista();
        //Llama al metodo auxiliar para recorrer el arbol
        posordenAux(this.raiz, 1, posorden);
        return posorden;
    }

    /**
     * *
     * Metodo auxiliar para recorrer de forma recursiva el arbol en posorden
     *
     * @param raiz
     * @param i
     * @param l
     */
    private void posordenAux(NodoArbol raiz, int i, Lista l) {
        if (raiz != null) {
            l.insertar(raiz.getElem(), i);
            posordenAux(raiz.getDerecho(), i, l);
            posordenAux(raiz.getIzquierdo(), i, l);
        }
    }

    /**
     * *
     * Recorre el arbol y, haciendo uso de una pila, guarda los hijos y los
     * lista segun el nivel y de izquierda a derecha
     *
     * @return
     */
    public Lista porNivel() {
        //Se hace uso de una pila para recorrer los niveles
        Lista niveles = new Lista();
        Pila aux = new Pila();
        //Pone la raiz en la pila
        aux.apilar(this.raiz.getElem());
        porNivelAux(aux, this.raiz);

        //Mientras que la pila no sea vacia, asigna el tope a la lista y desapila
        while (!aux.esVacia()) {
            niveles.insertar(aux.obtenerTope(), 1);
            aux.desapilar();
        }
        return niveles;
    }

    private void porNivelAux(Pila p, NodoArbol raiz) {
        if (raiz.getIzquierdo() != null) {
            p.apilar(raiz.getIzquierdo().getElem());
        }
        if (raiz.getDerecho() != null) {
            p.apilar(raiz.getDerecho().getElem());
        }
        if (raiz.getIzquierdo() != null) {
            porNivelAux(p, raiz.getIzquierdo());
        }
        if (raiz.getDerecho() != null) {
            porNivelAux(p, raiz.getDerecho());
        }
    }

    /**
     * *
     * Metodo que devuelve un String de la forma del arbol en preorden Los
     * elementos son listados de la forma: elemento: HI: elementoIzq HD:
     * elementoDer Si no tiene hijo izquierdo o derecho, se pone - Si el arbol
     * esta vacio devuelve "Arbol vacio"
     *
     * @return String
     */
    public String toString() {
        String retorno = "Arbol vacio";

        if (this.raiz != null) {
            retorno = toStringAux(this.raiz);
        }
        return retorno;
    }

    /**
     * *
     * Metodo recursivo que recorre el arbol armando su String
     *
     * @param raiz
     * @return String
     */
    private String toStringAux(NodoArbol raiz) {
        String retornoAux = "";

        if (raiz != null) {
            retornoAux = raiz.getElem().toString() + ":";

            NodoArbol izq = raiz.getIzquierdo();
            NodoArbol der = raiz.getDerecho();

            if (izq != null) {
                retornoAux += " HI: " + izq.getElem().toString();
            } else {
                retornoAux += " HI: -";
            }

            if (der != null) {
                retornoAux += " HD: " + der.getElem().toString();
            } else {
                retornoAux += " HD: -";
            }

            retornoAux += "\n";

            if (izq != null) {
                retornoAux += toStringAux(izq);
            }

            if (der != null) {
                retornoAux += toStringAux(der);
            }
        }
        return retornoAux;
    }

    public Lista ancestros(Object elemento) {
        Lista lista = new Lista();
        ancestrosAux(this.raiz, lista, elemento);
        return lista;
    }

    public boolean ancestrosAux(NodoArbol raiz, Lista lista, Object elemento) {
        boolean encontrado = false;
        if (raiz != null) {
            if (raiz.getElem().equals(elemento)) {
                encontrado = true;
            } else if (ancestrosAux(raiz.getIzquierdo(), lista, elemento) || ancestrosAux(raiz.getDerecho(), lista, elemento)) {
                //Busca primero a la izquierda. En caso de no encontrarlo baja por la derecha
                lista.insertar(raiz.getElem(), 1);
                encontrado = true;
            }
        }
        return encontrado;
    }
}
