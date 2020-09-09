/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.*;

/**
 *
 * @author Santi
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object nuevoElem, Object padre) {
        boolean exito;

        if (this.raiz != null) {
            exito = insertarAux(this.raiz, nuevoElem, padre);
        } else {
            this.raiz = new NodoGen(nuevoElem, null, null);
            exito = true;
        }
        return exito;
    }

    private boolean insertarAux(NodoGen raiz, Object nuevoElem, Object padre) {
        boolean retorno = false;

        //Verifica si el elemento raiz es el padre
        if (raiz.getElem().equals(padre)) {
            //Verifica que la raiz tenga HI
            if (raiz.getHijoIzquierdo() != null) {
                NodoGen aux = raiz.getHijoIzquierdo();
                while (aux.getHermanoDerecho() != null) {
                    aux = aux.getHermanoDerecho();
                }
                //Se le asigna un nuevo hermano al HI
                aux.setHermanoDerecho(new NodoGen(nuevoElem, null, null));
                retorno = true;
            } else {
                //En caso de no tener HI, el elemento ingresado se convierte en el HI
                raiz.setHijoIzquierdo(new NodoGen(nuevoElem, null, null));
                retorno = true;
            }
        } else {
            //En caso de que no sea el padre, se mueve al siguiente hijo
            NodoGen aux = raiz.getHijoIzquierdo();

            while (aux != null && !retorno) {
                retorno = retorno || insertarAux(aux, nuevoElem, padre);
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }

    public boolean pertenece(Object elem) {
        boolean pertenece = false;
        if (this.raiz != null) {
            pertenece = perteneceAux(this.raiz, elem);
        }
        return pertenece;
    }

    private boolean perteneceAux(NodoGen raiz, Object elem) {
        boolean retorno = false;

        //Verifica si el elemento es la raiz
        if (raiz.getElem().equals(elem)) {
            retorno = true;
        } else {
            //En caso de no serlo continua recorriendo los hijos
            NodoGen aux = raiz.getHijoIzquierdo();
            while (aux != null && !retorno) {
                retorno = retorno || perteneceAux(aux, elem);
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }

    public Lista ancestros(Object hijo) {
        Lista ls = new Lista();
        //Verifica que la raiz no sea el elemento buscado
        if (!hijo.equals(this.raiz.getElem())) {
            ancestrosAux(hijo, this.raiz, ls);
        }
        return ls;
    }

    private boolean ancestrosAux(Object buscado, NodoGen raiz, Lista lista) {
        boolean encontrado = false;
        if (raiz != null) {
            if (raiz.getElem().equals(buscado)) {
                encontrado = true;
            } else {
                encontrado = ancestrosAux(buscado, raiz.getHijoIzquierdo(), lista);
                //Si el hijo fue encontrado entonces inserta a su padre en la lista
                if (encontrado) {
                    lista.insertar(raiz.getElem(), 1);
                } else {
                    encontrado = ancestrosAux(buscado, raiz.getHermanoDerecho(), lista);
                }
            }
        }
        return encontrado;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public int altura() {
        int altura = -1;
        if (this.raiz != null) {
            altura += alturaAux(this.raiz);
        }
        return altura;
    }

    private int alturaAux(NodoGen raiz) {
        int retorno = 0;

        if (raiz != null) {
            retorno = 1;
            NodoGen aux = raiz.getHijoIzquierdo();
            int retornoH = 0;

            while (aux != null) {
                int llamados = alturaAux(aux);
                //Busca la mayor altura
                if (retornoH <= llamados) {
                    retornoH = llamados;
                }
                aux = aux.getHermanoDerecho();
            }
            retorno += retornoH;
        }
        return retorno;
    }

    public int nivel(Object elem) {
        int retorno = -1;
        if (this.raiz != null) {
            retorno += nivelAux(this.raiz, elem);
        }
        return retorno;
    }

    private int nivelAux(NodoGen raiz, Object buscado) {
        int retorno = 0;

        //Verifica si la raiz posee el elemento buscado
        if (raiz != null) {
            if (raiz.getElem().equals(buscado)) {
                retorno = 1;
            } else {
                //Si no lo posee empieza a buscar por sus hijos
                NodoGen aux = raiz.getHijoIzquierdo();
                int retornoHijos;

                while (aux != null && retorno == 0) {
                    retornoHijos = nivelAux(aux, buscado);
                    if (retornoHijos > 0) {
                        retorno = retornoHijos + 1;
                    }
                    aux = aux.getHermanoDerecho();
                }
            }
        }
        return retorno;
    }

    public Object padre(Object elem) {
        Object padre = null;
        if (this.raiz != null) {
            //Verifica que la raiz no sea su propio padre
            if (!this.raiz.getElem().equals(elem)) {
                padre = padreAux(this.raiz, elem);
            }
        }
        return padre;
    }

    private Object padreAux(NodoGen raiz, Object buscado) {
        Object retorno = null;
        if (raiz != null) {
            NodoGen aux = raiz.getHijoIzquierdo();
            boolean encontrado = false;
            while (!encontrado && aux != null) {
                if (aux.getElem().equals(buscado)) {
                    retorno = raiz.getElem();
                    encontrado = true;
                } else {
                    Object retornoHijo = padreAux(aux, buscado);
                    //Si el retorno de los hijos es distinto de null entonces encontro al padre
                    if (retornoHijo != null) {
                        retorno = retornoHijo;
                        encontrado = true;
                    }
                }
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }

    public Lista listarPreorden() {
        Lista lista = new Lista();
        listarPreordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPreordenAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            listarPreordenAux(nodo.getHermanoDerecho(), lista);
            listarPreordenAux(nodo.getHijoIzquierdo(), lista);
            lista.insertar(nodo.getElem(), 1);
        }
    }

    public Lista listarInorden() {
        Lista lista = new Lista();
        inordenAux(this.raiz, lista);
        lista = lista.invertir();
        return lista;
    }

    private void inordenAux(NodoGen raiz, Lista lista) {
        if (raiz != null) {
            NodoGen hijoIzquierdo = raiz.getHijoIzquierdo();
            if (hijoIzquierdo != null) {
                inordenAux(hijoIzquierdo, lista);
            }
            lista.insertar(raiz.getElem(), 1);
            if (hijoIzquierdo != null) {
                NodoGen hijo = hijoIzquierdo.getHermanoDerecho();
                while (hijo != null) {
                    inordenAux(hijo, lista);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        posordenAux(this.raiz, lista);
        lista = lista.invertir();
        return lista;
    }

    private void posordenAux(NodoGen raiz, Lista lista) {
        if (raiz != null) {
            NodoGen hijo = raiz.getHijoIzquierdo();
            while (hijo != null) {
                posordenAux(hijo, lista);
                hijo = hijo.getHermanoDerecho();
            }
            lista.insertar(raiz.getElem(), 1);
        }
    }

    public Lista listarNiveles() {
        Lista lista = new Lista();
        if (this.raiz != null) {
            Cola cola = new Cola();
            NodoGen nodo, hijo;
            cola.poner(this.raiz);
            while (!cola.esVacia()) {
                nodo = (NodoGen) cola.obtenerFrente();
                lista.insertar(nodo.getElem(), 1);
                cola.sacar();
                hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    cola.poner(hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
            lista.invertir();
        }
        return lista;
    }

    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        //Verifica que el arbol a clonar no sea vacio
        if (this.raiz != null) {
            clon.raiz = cloneAux(this.raiz); //La raiz sera igual al enlace de hijos y hermanos del arbol original clonados
        }
        return clon;
    }

    private NodoGen cloneAux(NodoGen raiz) {
        NodoGen hijoClon = null;
        //En caso de que el nodo que entra por parámetro no sea vacio, se le asigna como HI y HED el llamado recursivo de ambos procedentes del arbol original
        if (raiz != null) {
            hijoClon = new NodoGen(raiz.getElem(), cloneAux(raiz.getHijoIzquierdo()), cloneAux(raiz.getHermanoDerecho()));
        }
        return hijoClon;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen raiz) {
        String retorno = "";

        if (raiz != null) {
            retorno += raiz.getElem().toString() + "-->";
            NodoGen aux = raiz.getHijoIzquierdo();
            while (aux != null) {
                retorno += aux.getElem().toString() + ",";
                aux = aux.getHermanoDerecho();
            }
            aux = raiz.getHijoIzquierdo();
            while (aux != null) {
                retorno += "\n" + toStringAux(aux);
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }
}
