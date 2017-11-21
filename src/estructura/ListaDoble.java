/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ListaDoble<T> implements Iterable<T> {

    NodoDoble<T> cabecera;
    NodoDoble<T> fin;
    public int size;
    Comparator<T> comparador;

    public ListaDoble() {
        this.cabecera = null;
        this.fin = null;
        size = 0;
    }
    
    public NodoDoble<T> getFin(){
        return fin;
    }

    public NodoDoble<T> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoDoble<T> cabecera) {
        this.cabecera = cabecera;
    }

    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    public void insertarAlInicio(T nuevo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevo);
        if (cabecera == null) {
            cabecera = nuevoNodo;
            fin = nuevoNodo;
        } else {
            nuevoNodo.sig = cabecera;
            cabecera.ant = nuevoNodo;
            cabecera = nuevoNodo;
        }
        size++;
    }

    public void insertarAlFinal(T nuevo) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevo);
        if (cabecera == null) {
            cabecera = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.sig = nuevoNodo;
            nuevoNodo.ant = fin;
            fin = nuevoNodo;
        }
        size++;
    }

    public T getDato(int pos) {
        if (pos >= size || pos < 0) {
            return null;
        } else {
            NodoDoble<T> aux = null;
            if (pos <= size / 2) {
                aux = cabecera;
                int i = 0;
                while (i != pos) {
                    aux = aux.sig;
                    i++;
                }
                return aux.dato;
            } else {
                aux = fin;
                int i = size - 1;
                while (pos != i) {
                    aux = aux.ant;
                    i--;
                }
                return aux.dato;
            }
        }
    }

    public void eliminarPos(int pos) {
        if (pos >= size || pos < 0) {
            System.out.println("Error eliminar");
        } else {
            if (pos == 0) {
                if (size == 1) {
                    cabecera = null;
                } else {
                    cabecera = cabecera.sig;
                    cabecera.ant = null;
                }
            } else {
                if (pos == size - 1) {
                    fin = fin.ant;
                    fin.sig = null;
                } else {
                    NodoDoble<T> aux = null;
                    if (pos <= size / 2) {
                        aux = cabecera;
                        int i = 0;
                        while (i != pos) {
                            aux = aux.sig;
                            i++;
                        }
                    } else {
                        aux = fin;
                        int i = size - 1;
                        while (pos != i) {
                            aux = aux.ant;
                            i--;
                        }
                    }
                    aux.ant.sig = aux.sig;
                    aux.sig.ant = aux.ant;
                }
            }
            size--;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorDescendente();
    }

    private class IteradorDescendente implements Iterator<T> {

        NodoDoble<T> aux;

        public IteradorDescendente() {
            aux = cabecera;
        }

        @Override
        public boolean hasNext() {
            return aux != null;
        }

        @Override
        public T next() {
            T datoG = aux.dato;
            aux = aux.sig;
            return datoG;
        }

    }

    public Iterator<T> getDescendingIterator() {
        return new IteradorDescendente();
    }

    @Override
    public String toString() {
        String cadena = "";
        NodoDoble<T> aux = cabecera;
        while (aux != null) {
            cadena += aux.dato + "";
            aux = aux.sig;
        }
        return cadena;
    }

    public void ordenarPorBurbuja() {
        for (NodoDoble<T> i = cabecera; i != null; i = i.sig) {
            for (NodoDoble<T> j = i; j != null; j = j.sig) {
                if (comparador.compare(i.dato, j.dato) > 0) {
                    //Intercambiar
                    intercambiar(i, j);
                }
            }
        }
    }

    private void intercambiar(NodoDoble<T> i, NodoDoble<T> j) {
        T aux = i.dato;
        i.dato = j.dato;
        j.dato = aux;
    }

    public Stream<T> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
 
    
    
    //Ximena
    public void limpiarLista(){
        cabecera = fin = null;
    }
}