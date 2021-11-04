
package arbolgrafico;


import javax.swing.*;
import java.util.ArrayList;

/**
 *Modificado por Jeff
 * @author ploks, Jeff
 */
public class SimuladorArbolBinario {

    static String w;

     ArbodeExpresiones miArbol = new ArbodeExpresiones();

    /**
     * Metodo constructor
     */
    public SimuladorArbolBinario() {
    }

    /**
     * Metodo que insterta dato en el arbol
     * @param dato -- dato a instertar
     * @return arbol con el dato insertado
     */
    public boolean insertar(String dato) {

      return (this.miArbol.contruir(dato));
    }


    /**
     * Metodo que retorna la lista de los nodos del arbol en preorden
     * @return Lista de nodos en preorden
     */
  public ArrayList preOrden() {
      ArrayList it = this.miArbol.getPreOrden(miArbol.getRaiz());

      return it;
  }

    /**
     * Metodo que retorna la lista de los nodos del arbol en postorden
     * @return Lista de nodos en postorden
     */
    public ArrayList posOrden() {
        ArrayList it = this.miArbol.getPostorden(miArbol.getRaiz());

        return it;
    }

    /**
     * Metodo que retorna la lista de nodos en orden inverso
     * @return Lista de nodos en orden inverso
     */
    public String inOrden() {
        String it = this.miArbol.getInorden(miArbol.getRaiz());
        return it;

    }

    /**
     * Metodo que obtiene el dibujo pintado del arbol
     * @return Dibujo del arbol
     */
    public JPanel getPaint(){
        return this.miArbol.getPaint();
    }

    /**
     * Metodo que obtiene el dibujo del arbol
     * @return Dibujo del arbol
     */
    public JPanel getDibujo() {

        return this.miArbol.getdibujo();
    }

}
