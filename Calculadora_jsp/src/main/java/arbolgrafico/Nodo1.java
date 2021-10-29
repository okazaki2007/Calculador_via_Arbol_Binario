package arbolgrafico;

/**
 * clase nodo secundaria
 * @author Juan David
 */
public class Nodo1 {

    private String informacion;
    private Nodo1 padre;
    private Nodo1 nodoIzquierdo;
    private Nodo1 nodoDerecho;

    /**
     * Metodo constructor que crea variables vacias del nodo
     */
    public Nodo1(){
        this.informacion="";
        this.nodoIzquierdo=null;
        this.nodoDerecho=null;
        this.padre=null;
    }

    /**
     * Metodo constructor que da valor al nodo
     * @param informacion -- Valor del nodo
     */
    public Nodo1(String informacion){
        this.informacion=informacion;
        this.nodoIzquierdo=null;
        this.nodoDerecho=null;
        this.padre=null;
    }

    /**
     * Metodo constructor que asigna valores a las variables creadas en el primer constructor
     * @param op1 -- Nodo operador derecho
     * @param pop -- Nodo con valor
     * @param op2 -- Nodo operador izquierdo
     */
    public  Nodo1(Nodo1 op1, String pop, Nodo1 op2) {
        this.nodoDerecho=op1;
        this.informacion=pop;
        this.nodoIzquierdo=op2;
        this.padre=null;

    }

    /**
     * Metodo que retorna el padre del nodo
     * @return Nodo padre
     */
    public Nodo1 getPadre() {
        return padre;
    }

    /**
     * Metodo que modifica el padre del nodo
     * @param padre -- Nuevo nodo padre
     */
    public void setPadre(Nodo1 padre) {
        this.padre = padre;
    }

    /**
     * Metodo que retorna la informacion del nodo
     * @return Informacion del nodo
     */
    public String getInformacion() {
        return informacion;
    }

    /**
     * Metodo que modifica la informacion del nodo
     * @param informacion -- Informacion del nodo
     */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    /**
     * Metodo que retorna el nodo izquierdo del nodo
     * @return Nodo izquierdo del nodo
     */
    public Nodo1 getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    /**
     * Metodo para modificar nodo a la izquierda del nodo
     * @param nodoIzquierdo-- Nuevo nodo a la izquierda
     */
    public void setNodoIzquierdo(Nodo1 nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }
    /**
     * Metodo que retorna el nodo derecho del nodo
     * @return Nodo derecho del nodo
     */
    public Nodo1 getNodoDerecho() {
        return nodoDerecho;
    }

    /**
     * Metodo para cambiar nodo a la derecha del nodo
     * @param nodoDerecho -- nuevo nodo a la derecha
     */
    public void setNodoDerecho(Nodo1 nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }


}