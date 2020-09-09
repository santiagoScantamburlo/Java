/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import lineales.dinamicas.Lista;

/**
 *
 * @author Santiago Scantamburlo
 */
public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    public boolean insertarAux(NodoABB raiz, Comparable elemento) {
        boolean exito = true;
        if (elemento.compareTo(raiz.getElem()) == 0) {
            //Retorna falso si el elemento es repetido
            exito = false;
        } else if (elemento.compareTo(raiz.getElem()) < 0) {
            //Si tiene HI baja a la izquierda, sino inserta
            if (raiz.getIzquierdo() != null) {
                exito = insertarAux(raiz.getIzquierdo(), elemento);
            } else {
                raiz.setIzquierdo(new NodoABB(elemento));
            }
        } else if (raiz.getDerecho() != null) {
            //Si tiene HD baja a la derecha, sino inserta
            exito = insertarAux(raiz.getDerecho(), elemento);
        } else {
            raiz.setDerecho(new NodoABB(elemento));
        }
        return exito;
    }

    public Lista listar() {
        Lista lista = new Lista();
        listarAux(this.raiz, lista);
        return lista;
    }

    public void listarAux(NodoABB nodo, Lista lista) {
        if (nodo != null) {
            listarAux(nodo.getDerecho(), lista);
            lista.insertar(nodo.getElem(), 1);
            listarAux(nodo.getIzquierdo(), lista);
        }
    }

    public boolean pertenece(Comparable buscado) {
        boolean pertenece = false;
        NodoABB nodo = this.raiz;
        Comparable elemento;
        while (nodo != null && !pertenece) {
            elemento = nodo.getElem();
            if (elemento.equals(buscado)) {
                pertenece = true;
            } else if (elemento.compareTo(buscado) > 0) {
                nodo = nodo.getIzquierdo();
            } else if (elemento.compareTo(buscado) < 0) {
                nodo = nodo.getDerecho();
            }
        }
        return pertenece;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Comparable minimoElem() {
        Comparable elemento = null;
        NodoABB nodo = this.raiz;
        //Baja por la izquierda
        while (nodo != null) {
            elemento = nodo.getElem();
            nodo = nodo.getIzquierdo();
        }
        return elemento;
    }

    public Comparable maximoElem() {
        Comparable elemento = null;
        NodoABB nodo = this.raiz;
        //Baja por la derecha
        while (nodo != null) {
            elemento = nodo.getElem();
            nodo = nodo.getDerecho();
        }
        return elemento;
    }

    //Hago uso del mismo de Arbol Binario
    public String toString() {
        String retorno = "Arbol vacio";

        if (this.raiz != null) {
            retorno = toStringAux(this.raiz);
        }
        return retorno;
    }

    private String toStringAux(NodoABB raiz) {
        String retornoAux = "";

        if (raiz != null) {
            retornoAux = raiz.getElem().toString() + ":";

            NodoABB izq = raiz.getIzquierdo();
            NodoABB der = raiz.getDerecho();

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

    public Lista listarRango(int minimo, int maximo) {
        Lista lista = new Lista();
        listarRangoAux(this.raiz, lista, minimo, maximo);
        return lista;
    }

    private void listarRangoAux(NodoABB raiz, Lista lista, int minimo, int maximo) {
        if (raiz != null) {
            Comparable elemento = raiz.getElem();
            if (elemento.compareTo(maximo) < 0) {
                listarRangoAux(raiz.getDerecho(), lista, minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
                lista.insertar(elemento, 1);
            }
            if (elemento.compareTo(minimo) > 0) {
                listarRangoAux(raiz.getIzquierdo(), lista, minimo, maximo);
            }
        }
    }

    public boolean eliminar(Comparable elem) {
        boolean exito = false;
        if (this.raiz != null) {
            exito = eliminarAux(elem, this.raiz, null);
        }
        return exito;
    }

    private boolean eliminarAux(Comparable elem, NodoABB actual, NodoABB padre) {
        boolean retorno = false;
        if (actual != null) {
            int temp = elem.compareTo(actual.getElem());
            if (temp < 0) {
                retorno = eliminarAux(elem, actual.getIzquierdo(), actual);
            } else if (temp > 0) {
                retorno = eliminarAux(elem, actual.getDerecho(), actual);
            } else {
                //Encuentra el nodo.     
                if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                    caso1(elem, padre);
                } else {
                    if (actual.getIzquierdo() == null || actual.getDerecho() == null) {
                        caso2(elem, actual, padre);
                    } else {
                        caso3(actual);
                    }
                }
                retorno = true;
            }
        }
        return retorno;
    }

    private void caso1(Comparable elemento, NodoABB padre) {
        if (padre == null) {
            //Caso especial al intentar eliminar la raiz
            this.raiz = null;
        } else {
            int temp = elemento.compareTo(padre.getElem());
            if (temp < 0) {
                padre.setIzquierdo(null);
            } else {
                padre.setDerecho(null);
            }
        }

    }

    private void caso2(Comparable elem, NodoABB hijo, NodoABB padre) {
        //Busco al candidato para reemplazar al nodo, sabiendo que uno sera null
        NodoABB der = hijo.getDerecho();
        NodoABB izq = hijo.getIzquierdo();
        if (padre == null) {
            //Caso especial.
            if (der == null) {
                this.raiz = izq;
            } else {
                this.raiz = der;
            }
        } else {
            //Verifico la rama derecha o izquierda.
            int temp = elem.compareTo(padre.getElem());
            if (temp < 0) {
                if (izq == null) {
                    padre.setIzquierdo(der);
                } else {
                    padre.setIzquierdo(izq);
                }
            } else {
                if (izq == null) {
                    padre.setDerecho(der);
                } else {
                    padre.setDerecho(izq);
                }
            }
        }

    }

    private void caso3(NodoABB actual) {
        NodoABB hijoA = actual.getIzquierdo(), nodoPadreA = actual;
        while (hijoA.getDerecho() != null) {
            nodoPadreA = hijoA;
            hijoA = hijoA.getDerecho();
        }
        actual.setElem(hijoA.getElem());
        NodoABB hijoDer = hijoA.getDerecho();
        if (actual.getIzquierdo() == hijoA) {
            actual.setIzquierdo(hijoDer);
        } else {
            nodoPadreA.setIzquierdo(hijoDer);
        }
    }

    public boolean eliminarMinimo() {
        boolean exito = false;
        if (this.raiz != null) {
            eliminarMinimoAux(this.raiz, null);
            exito = true;
        }
        return exito;
    }

    private void eliminarMinimoAux(NodoABB hijo, NodoABB padre) {
        while (hijo.getIzquierdo() != null) {
            padre = hijo;
            hijo = hijo.getIzquierdo();
        }
        eliminarAux(hijo.getElem(), padre, hijo);
    }


    public boolean eliminarMaximo() {
        boolean exito = false;
        if (this.raiz != null) {
            eliminarMaximoAux(this.raiz, null);
            exito = true;
        }
        return exito;
    }

    private void eliminarMaximoAux(NodoABB hijo, NodoABB padre) {
        while (hijo.getDerecho() != null) {
            padre = hijo;
            hijo = hijo.getDerecho();
        }
        eliminarAux(hijo.getElem(), padre, hijo);
    }
}
