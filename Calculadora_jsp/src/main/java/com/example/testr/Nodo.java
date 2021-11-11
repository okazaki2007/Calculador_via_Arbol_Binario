/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculadora_final;

/**
 *Clase tomada del internet, referenciada en la documentacion externa, editado por Juan David
 * @author ploks, Juan David
 */
public class Nodo {
    
    private int dato;
    private Nodo izq, der;
    /**
     * Metodo constructor
     * @param dato -- Dato para el nodo
     * @param izq -- Nodo a la izquierda
     * @param der -- Nodo a la derecha
     */

    public Nodo(int dato, Nodo izq, Nodo der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    /**
     * Metodo que retorna el dato del nodo
     * @return Dato del nodo
     */

    public int getDato() {
        return dato;
    }

    /**
     * Metodo para cambiar el dato del nodo
     * @param dato -- Nuevo dato para el nodo
     */

    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * Metodo que retorna el nodo a la izquierda del nodo
     * @return Nodo a la izquierda del nodo
     */

    public Nodo getIzq() {
        return izq;
    }
    /**
     * metodo para modificar cual nodo esta a la izquierda del nodo
     * @param izq -- Nuevo nodo para estar a la izquierda del nodo
     */

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    /**
     * Metodo que retorna el nodo a la derecha del nodo
     * @return Nodo a la derecha del nodo
     */
    public Nodo getDer() {
        return der;
    }

    /**
     * Metodo para cambiar el nodo a la derecha del nodo
     * @param der -- Nuevo nodo a estar a la derecha del nodo
     */

    public void setDer(Nodo der) {
        this.der = der;
    } 

}
