
package arbolgrafico;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ploks
 */
public class SimuladorArbolBinario {

    static String w;
    //  Arbol miArbol = new Arbol();
     ArbodeExpresiones miArbol = new ArbodeExpresiones();

    public SimuladorArbolBinario() {
    }

    public boolean insertar(String dato) {
     //  return (this.miArbol.agregar(dato));
     // return (this.a);
      return (this.miArbol.contruir(dato));
    }

    public String borrar(Integer dato) {
       // Integer x = this.miArbol.borrar(dato);
       // if (x == null) {
            return ("No existe el dato en el arbol");
      //  }
      //  return ("Borrado el dato: " + x.toString());
    }

  public ArrayList preOrden() {
      ArrayList it = this.miArbol.getPreOrden(miArbol.getRaiz());

      return it;
  }



    public String inOrden() {
        String it = this.miArbol.getInorden(miArbol.getRaiz());//el problema esta aqui
        return it;

    }




    public String posOrden() {
       ArrayList it = this.miArbol.getPostorden(miArbol.getRaiz());
       return (recorrido(it, "Recorrido PosOrden"));

    }


    public String imprimirPorNiveles() {
       // ArrayList it = this.miArbol.impNiveles();
       // return (recorrido(it, "Imprimir Por niveles"));
        return "hola";
    }

    public String darHojas() {
       // ArrayList it = this.miArbol.getHojas();
       // return (recorrido(it, "Hojas del Arbol"));
        return "hola";
    }

    public String darPadre(Integer hijo) {
        /*
        if (this.miArbol.getRaiz().getDato() == (hijo)) {
            return ("La raiz no tiene padre");
        }
        Integer padre = this.miArbol.padre(hijo);
        if (padre == null) {
            return ("No existe el Dato: " + hijo.toString());
        }
        return ("El padre de: " + hijo + "\n es : " + padre.toString());
        */
         return "hola";
    }

    public String esta(Integer dato) {
       // boolean siEsta = this.miArbol.buscar(dato);
      //  String r = "El dato:" + dato.toString() + "\n";
      //  r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
       // return (r);
       return "hola";
    }

    private String recorrido(ArrayList it, String msg) {
/*
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "\n";
            i++;
        }
        return (r);

*/
        return "";
    }

    public String CantidadNodos(){
      //  return this.miArbol.cantidadNodos();
        return "hola";
    }

    public String CantidadHojas(){
      //  return this.miArbol.cantidadNodosHoja();
        return "hola";
    }
    public String alturaArbol(){
       //return this.miArbol.al;
         return "hola";
    }
    public String menorValor(){
       // return this.miArbol.menorValor();
         return "hola";
    }
    public String mayorValor(){
       // return this.miArbol.mayorValor();
         return "hola";
    }
    public String balance(){
       // return this.miArbol.imprimirBalance();
         return "hola";
    }
    public String borrarMenor(){
        //return this.miArbol.borrarMenor();
          return "hola";
    }
    public String borrarMayor(){
        //return this.miArbol.borrarMayor();
          return "hola";
    }
    public String porNivel(){
        //this.miArbol.alturaArbol();
       //ArrayList it = miArbol.A.imprimirNivel();
        //return (recorrido(it, "Imprimir Por niveles en orden!!!"));
         return "hola";
    }
    public String cambiar() {
       // this.miArbol.cambiar();
       // return "Valores cambiados!!!";
         return "hola";
    }
    public String ramaMayor() {
       // ArrayList it = this.miArbol.ObtenerRamamayor();
        //return (recorrido(it, "Rama(s) con mas valores"));
          return "hola";
    }


    public void podarArbol() {
     //  this.miArbol.podar();

    }
    public JPanel getPaint(){
        return this.miArbol.getPaint();
    }


public JPanel getDibujo() {

        return this.miArbol.getdibujo();
    }

}
