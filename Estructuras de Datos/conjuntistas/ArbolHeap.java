/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Santi
 */
public class ArbolHeap {

    private static final int TAMANIO = 10;
    private Comparable[] heap;
    private int ultimo = 0;

    public ArbolHeap() {
        this.heap = new Comparable[TAMANIO];
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = false;
        if (this.ultimo + 1 < TAMANIO) {
            this.ultimo++;
            this.heap[this.ultimo] = elemento;
            hacerSubir(this.ultimo);
            exito = true;
        }
        return exito;
    }

    private void hacerSubir(int posHijo) {
        int posP;
        Comparable temp = this.heap[posHijo];
        boolean continuar = true;
        while (continuar) {
            posP = posHijo / 2;
            if (posP >= 1) {
                if (this.heap[posP].compareTo(temp) > 0) {
                    this.heap[posHijo] = this.heap[posP];
                    this.heap[posP] = temp;
                    posHijo = posP;
                } else {
                    continuar = false;
                }
            } else {
                continuar = false;
            }

        }
    }

    public boolean eliminarCima() {
        boolean exito;
        if (this.ultimo == 0) {
            exito = false;
        } else {
            this.heap[1] = this.heap[this.ultimo];
            this.ultimo--;
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                // temp tiene al menos un hijo (izq) y lo considera menor
                if (posH < this.ultimo) {
                    // hijo menor tiene hermano derecho
                    // el hijo derecho es menor que los dos
                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        posH++;
                    }
                }
                // compara al hijo menor con el padre
                if (this.heap[posH].compareTo(temp) < 0) {
                    // el hijo es menor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    // el padre es menor que sus hijos, está bien ubicado
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
    }

    public String toString() {
        String s = "";
        int izq, der;

        if (this.ultimo == 0) {
            s = "Heap vacio!";
        } else {
            for (int i = 1; i <= this.ultimo; i++) {
                System.out.print(this.heap[i] + ": ");
                izq = i * 2;
                der = izq + 1;
                if (izq <= this.ultimo && this.heap[izq] != null) {
                    System.out.print("HI--> " + this.heap[izq]);
                } else {
                    System.out.print("HI--> -");
                }
                System.out.print("\t");
                if (der <= this.ultimo && this.heap[der] != null) {
                    System.out.println("HD--> " + this.heap[der]);
                } else {
                    System.out.println("HD--> -");
                }
            }
        }
        return s;
    }

    public Comparable recuperarCima() {
        return this.heap[1];
    }

    public boolean esVacio() {
        return this.ultimo == 0;
    }

    public void vaciar() {
        for (int i = 0; i <= this.ultimo; i++) {
            this.heap[i] = null;
        }
        this.ultimo = 0;
    }

    public ArbolHeap clone() {
        ArbolHeap clon = new ArbolHeap();
        int i = 0;

        while (i <= this.ultimo) {
            clon.heap[i] = this.heap[i];
            i++;
        }
        clon.ultimo = this.ultimo;
        return clon;
    }
}
