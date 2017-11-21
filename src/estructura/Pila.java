/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

public class Pila<T> {
    NodoDoble<T> cabecera;
    NodoDoble<T> fin;
    public int size;
    public Pila() {
        this.cabecera = null;
        this.size = 0;
    }
    
    public NodoDoble<T> getCabecera() {
        return cabecera;
    }

    public int getSize() {
        return size;
    }
    
    public void push(T nuevo) {
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
    
    public void poll(){
        if (cabecera!= null) {
            cabecera.sig = cabecera;
            size--;
        } else {
            System.out.println("No hay elementos en la pila");
        }
        
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
     
     
}
