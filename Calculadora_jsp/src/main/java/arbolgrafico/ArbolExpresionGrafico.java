
package arbolgrafico;

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class ArbolExpresionGrafico extends JPanel {

    private ArbodeExpresiones miArbol;
    private HashMap posicionNodos = null;
    private HashMap subtreeSizes = null;
    private boolean dirty = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0, 0);
    private FontMetrics fm = null;


    /**
     * Constructor
     * @param miArbol -- Arbol base
     */
    public ArbolExpresionGrafico(ArbodeExpresiones miArbol) {
        this.miArbol = miArbol;
        this.setBackground(Color.WHITE);
        posicionNodos = new HashMap();
        subtreeSizes = new HashMap();
        dirty = true;
        repaint();
    }



    /**
     * Calcula las posiciones de los respectivos subarboles y de cada nodo que
     * forma parte de ese subárbol, para conocer en que posición van a ir dibujados
     * los rectángulos representativos del arbol de la expresion.
     */
    private void calcularPosiciones() 
    {
         posicionNodos.clear();
         subtreeSizes.clear();
         // Nodo root = this.miArbol.getRaiz();
         arbolgrafico.Nodo1 root = this.miArbol.getRaiz();
         if (root != null) 
         {
             calcularTamanoSubarbol(root);
             calcularPosicion(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
         }
    }
    
    /**
     * Calcula el tamaño de cada subárbol y lo agrega al objeto subtreeSizes de la clase
     * de tipo HashMap que va a contener la coleccion de todos los 
     * subárboles que contiene un arbol.
     * @param n:Objeto de la clase NodoB T que se utiliza como
     * referencia calcular el tamano de cada subarbol.
     * @return Dimension con el tamano de cada subarbol.
     */

     private Dimension calcularTamanoSubarbol(arbolgrafico.Nodo1 n)
    {
          if (n == null) 
              return new Dimension(0,0);
 
          Dimension ld = calcularTamanoSubarbol(n.getNodoIzquierdo());
          Dimension rd = calcularTamanoSubarbol(n.getNodoDerecho());
          
          int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
          int w = ld.width + child2child + rd.width;
          
          Dimension d = new Dimension(w, h);
          subtreeSizes.put(n, d);
          
          return d;
    }
    
    /**
     * Calcula la ubicacion de cada nodo de cada subarbol y agrega cada nodo con
     * un objeto de tipo Rectangule que tiene la ubicacion y la informacion especifica de donde
     * va a ser dibujado.
     * @param n: Objeto de tipo NodoB T que se utiliza como
     * referencia para calcular la ubicación de cada nodo.
     * @param left: int con alineacion y orientacion a la izquierda.
     * @param right: int con alineacion y orientacion a la derecha.
     * @param top: int con el tope.
     */

     private void calcularPosicion(arbolgrafico.Nodo1 n, int left, int right, int top)
    {
      if (n == null) 
          return;
      
      Dimension ld = (Dimension) subtreeSizes.get(n.getNodoIzquierdo());
      if (ld == null) 
          ld = empty;
      
      Dimension rd = (Dimension) subtreeSizes.get(n.getNodoDerecho());
      if (rd == null) 
          rd = empty;
      
      int center = 0;
      
      if (right != Integer.MAX_VALUE)
          center = right - rd.width - child2child/2;
      else if (left != Integer.MAX_VALUE)
          center = left + ld.width + child2child/2;
      int width = fm.stringWidth(n.getInformacion()+"");
 
      posicionNodos.put(n,new Rectangle(center - width/2 - 3, top, width + 6, fm.getHeight()));
      
      calcularPosicion(n.getNodoIzquierdo(), Integer.MAX_VALUE, center - child2child/2, top + fm.getHeight() + parent2child);
      calcularPosicion(n.getNodoDerecho(), center + child2child/2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
    }
    
    
    /**
     * Dibuja el árbol teniendo en cuenta las ubicaciones de los nodos y los 
     * subárboles calculadas anteriormente.
     * @param g: Objeto de la clase Graphics2D que permite realizar el dibujo de las líneas, rectangulos y del String de la informacion que contiene el Nodo.
     * @param n: Objeto de la clase NodoB T que se utiliza como referencia para dibujar el árbol.
     * @param puntox: int con la posición en x desde donde se va a dibujar la línea hasta el siguiente hijo.
     * @param puntoy: int con la posición en y desde donde se va a dibujar la línea hasta el siguiente hijo.
     * @param yoffs: int con la altura del FontMetrics.
     */
    

public void dibujarArbol(Graphics2D g, arbolgrafico.Nodo1 n, int puntox, int puntoy, int yoffs)
    {
     if (n == null) 
         return;
     
     Rectangle r = (Rectangle) posicionNodos.get(n);
     g.draw(r);
     g.drawString(n.getInformacion()+"", r.x + 3, r.y + yoffs);
   
     if (puntox != Integer.MAX_VALUE)
       
     g.drawLine(puntox, puntoy, (int)(r.x + r.width/2), r.y);
     
     dibujarArbol(g, n.getNodoIzquierdo(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
     dibujarArbol(g, n.getNodoDerecho(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
     
   }
    
   /**
     * Sobreescribe el metodo paint y se encarga de pintar el arbol
     * @param g: Objeto de la clase Graphics.
     */
   public void paint(Graphics g) 
   {
         super.paint(g);
         fm = g.getFontMetrics();

         if (dirty) 
         {
           calcularPosiciones();
           dirty = false;
         }
         
         Graphics2D g2d = (Graphics2D) g;
         g2d.translate(getWidth() / 2, parent2child);
       //  dibujarArbol(g2d, this.miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, 
                   dibujarArbol(g2d, this.miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, 
                  fm.getLeading() + fm.getAscent());
         fm = null;
   }
   
 }




