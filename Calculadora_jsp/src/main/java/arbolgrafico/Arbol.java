
package arbolgrafico;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *Clase arbol
 * @author Juan David
 */
public class Arbol {

    private Nodo raiz;
    int cant;
    int altura;


    /**
     * Metodo para obtener la raiz
     * @return raiz -- nodo
     */
    public Nodo getRaiz() {
        return this.raiz;
    }

    /**
     * Metodo para cambiar el valor de la raiz
     * @param r -- Nuevo valor para la raiz
     */
    public void setRaiz(Nodo r) {
        this.raiz = r;
    }

    /**
     * Metodo constructor del arbol
     *
     */
    public Arbol() {
        this.raiz = null;
    }

    /**
     * Metodo para anhadir nodos al arbol
     * @param dato -- dato que va en el nodo que se anhadira
     * @return true
     */

    public boolean agregar(int dato) {
        Nodo nuevo = new Nodo(dato, null, null);
        insertar(nuevo, raiz);
        return true;
    }

    /**
     * Metodo para insertar nuevo nodo
     * @param nuevo -- Nodo a ser insertado
     * @param pivote -- pivote
     */
    public void insertar(Nodo nuevo, Nodo pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getDato() <= pivote.getDato()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());
                }
            } else {
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());
                }
            }
        }

    }

    /**
     * Metodo que retorna la cantidad de nodos del arbol
     * @return String, cantidad de nodos del arbol
     */
    public String cantidadNodos() {
        cant = 0;
        cantidadNodos(raiz);
        return ""+cant;
    }

    /**
     * Metodo para contar la cantidad de nodos del arbol
     * @param reco -- Nodo
     */
    private void cantidadNodos(Nodo reco) {
        if (reco != null) {
            cant++;
            cantidadNodos(reco.getIzq());
            cantidadNodos(reco.getDer());
        }
    }

    /**
     * Metodo que retorna la cantidad de hojas en el arbol
     * @return String, cantidad de hojas
     */
    public String cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(raiz);
        return ""+cant;
    }

    /**
     * Metodo para contar la cantidad de hojas en el arbol
     * @param reco -- Nodo
     */
      private void cantidadNodosHoja(Nodo reco) {
        if (reco != null) {
            if (reco.getIzq() == null && reco.getDer() == null) {
                cant++;
            }
            cantidadNodosHoja(reco.getIzq());
            cantidadNodosHoja(reco.getDer());
        }
    }

    /**
     * Metodo que retorna altura del arbol
     * @return String, altura del arbol
     */
    public String retornarAltura() {
        altura = 0;
        retornarAltura(raiz, 1);
        return ""+altura;
    }

    /**
     * Metodo para contar la altura del arbol
     * @param reco -- Nodo
     * @param nivel -- Nivel del nodo
     */
    private void retornarAltura(Nodo reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.getDer(), nivel + 1);
        }
    }

    /**
     * Metodo que encuentra y retorna el menor valor encontrado en el arbol
     * @return int, menor valor del arbol
     */
     public int menorValor() {
         Nodo reco = raiz;
        if (raiz != null) {
            
            while (reco.getIzq() != null) {
                reco = reco.getIzq();
            }
        }
        System.out.println(reco.getDato());
        return Integer.parseInt(("" + reco.getDato()));
    }

    /**
     * Metodo que encuentra y retorna mayor valor en el arbol
     * @return Int, mayor valor en el arbol
     */
    public String mayorValor() {
        Nodo reco = raiz;
        if (raiz != null) {
            while (reco.getDer() != null) {
                reco = reco.getDer();
            }
        }
        return ("" + reco.getDato());
    }
    

    int subizq = 0;
    int subder = 0;

    /**
     * Metodo que muestra el balance del arbol
     * @return String, que dice hacia que lado el arbol se balancea
     */
    public String imprimirBalance() {
         subizq = 0;
         subder = 0;

        Balance(this.raiz, true, 0);
        if (subizq - subder == 0) {
            return ("El balance es: 0 ");
        } else if (subizq - subder == -1) {
            return("El balance es -1, derecha");
        } else if (subizq - subder == 1) {
            return("El balance 1, izquierda");

        } else {
            return("No es balanceado.."
                    + "porque es mas grande el lado "
                    + ((subizq > subder) ? "Izquierdo" : "Derecho"));
        }

    }

    /**
     * Metodo para determinar el balance del arbol
     * @param reco -- Nodo
     * @param lado -- Lado del nodo
     * @param i -- Balance temporal del arbol
     */
    public void Balance(Nodo reco, boolean lado, int i) {

        if (reco != null) {

            if (reco.getDer() == null && reco.getIzq() == null) {
                if (lado) {
                    subder = (i > subder) ? i : subder;
                } else {
                    subizq = (i > subizq) ? i : subizq;
                }
            }

            Balance(reco.getDer(), lado, i + 1);
            if (i == 0) {
                lado = false;
            }
            Balance(reco.getIzq(), lado, i + 1);
        }

    }

    /**
     * Metodo que borra el menor valor del arbol
     * @return String, valor eliminado
     */
    public String borrarMenor() {
        Nodo reco=raiz.getIzq();
        if (raiz != null) {
            if (raiz.getIzq() == null) {
                raiz = raiz.getDer();
            } else {
                Nodo anterior = raiz;
                reco = raiz.getIzq();
                while (reco.getIzq() != null) {
                    anterior = reco;
                    reco = reco.getIzq();
                }
                
                anterior.setIzq(reco.getDer());
            }
        }
        return ("Valor eliminado: " + reco.getDato());
    }

    /**
     * Metodo que borra el mayor valor del arbol
     * @return Valor eliminado, string
     */
    public String borrarMayor() {
        Nodo reco=raiz.getIzq();
        if (raiz != null) {
            if (raiz.getDer() == null) {
                raiz = raiz.getIzq();
            } else {
                Nodo anterior = raiz;
                reco = raiz.getDer();
                while (reco.getDer() != null) {
                    anterior = reco;
                    reco = reco.getDer();
                }
                
                anterior.setDer(reco.getIzq());
            }
        }
        return ("Valor eliminado: " + reco.getDato());
    }


    String[] niveles;

    /**
     * Metodo que retorna la altura del arbol
     * @return altura del arbol
     */
    public int alturaArbol() {
        altura = 0;
        alturaArbol(raiz, 0);
        return altura;
    }

    /**
     * Metodo que encuentra la altura del arbol
     * @param pivote -- Nodo
     * @param nivel -- Nivel del nodo
     */
    private void alturaArbol(Nodo pivote, int nivel) {
        if (pivote != null) {
            alturaArbol(pivote.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            alturaArbol(pivote.getDer(), nivel + 1);
        }
    }

    /**
     * Metodo que muestra el nivel
     * @return ArrayList con lso niveles de cada nodo
     */
    public ArrayList imprimirNivel() {
        niveles = new String[altura + 1];
        ArrayList l=new ArrayList();
        imprimirNivel(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            l.add(niveles[i] + " ");
            System.out.println(niveles[i] + " ");
        }
        return l;
    }

    /**
     * Metodo que imprime los niveles de un nodo
     * @param pivote -- Nodo
     * @param nivel2 -- Nivel del nodo
     */
      public void imprimirNivel(Nodo pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = pivote.getDato() + ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.getDer(), nivel2 + 1);
            imprimirNivel(pivote.getIzq(), nivel2 + 1);
        }
    }

    /**
     * Metodo para invertir el arbol
     * @return True
     */
    public boolean cambiar() {
            cambiar(raiz, 1);

            return true;
    }

    /**
     * Metodo que se encarga del invertido del arbol recursivamente
     * @param reco -- Nodo temporal
     * @param nivel -- Nivel del nodo
     */
    private void cambiar(Nodo reco, int nivel) {
        if (reco != null) {
            reco.setDato(reco.getDato() * 3);
            cambiar(reco.getIzq(), nivel + 1);
            cambiar(reco.getDer(), nivel + 1);
        }
    }

    int numeroRamas = 0;

    /**
     * Metodo que retorna la rama mayor
     * @return Lista mayor
     */
    public ArrayList<String>ObtenerRamamayor(){
    obtenernumeroRamas(this.raiz, 0);
    return ObtenerRamamayor(this.raiz, 0, "", new ArrayList<String>());
    }

    /**
     * Metodo que encuentra el numero de ramas
     * @param pivote -- Nodo
     * @param contador -- Cantidad temporal de ramas
     */
    public void obtenernumeroRamas(Nodo pivote, int contador) {
        if (pivote != null) {
            contador++;
            obtenernumeroRamas(pivote.getIzq(), contador);
            obtenernumeroRamas(pivote.getDer(), contador);
        }
        if (contador > this.numeroRamas) {
            this.numeroRamas = contador;
        }
    }

    /**
     * Metodo que encuentra la rama mayor
     * @param pivote -- Nodo
     * @param contador -- Numero temporal de ramas
     * @param dato -- dato del nodo
     * @param lista -- lista de la rama
     * @return lista
     */
     public ArrayList<String> ObtenerRamamayor(Nodo pivote, int contador, String dato, ArrayList lista){
        if (pivote != null ) {
            dato+=pivote.getDato()+",";
            contador ++;
            lista=ObtenerRamamayor(pivote.getIzq(), contador, dato, lista);
            lista=ObtenerRamamayor(pivote.getDer(), contador, dato, lista);
            
            if (contador == this.numeroRamas) {
                lista.add(dato);
            }
        }
        return lista;
    }

    /**
     * Metodo que borra el valor en el arbol
     * @param x -- Valor a borrar
     * @return 0 si el dato no esta en el arbol, x si el valor si esta en el arbol
     */
    public int borrar(int x) {
        if (!this.buscar(x)) {
            return 0;
        }

        Nodo z = borrar(this.raiz, x);
        this.setRaiz(z);
        return x;

    }

    /**
     * Metodo que borra un valor en un nodo
     * @param r -- Nodo
     * @param x -- Valor a borrar
     * @return null si el dato no se encuentra, r si el dato si se encuentra
     */
    private Nodo borrar(Nodo r, int x) {
        if (r == null) {
            return null;//<--Dato no encontrado		
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            r.setIzq(borrar(r.getIzq(), x));
        } else if (compara < 0) {
            r.setDer(borrar(r.getDer(), x));
        } else {
            System.out.println("Encontro el dato:" + x);
            if (r.getIzq() != null && r.getDer() != null) {
                /*
                 *	Buscar el menor de los derechos y lo intercambia por el dato
                 *	que desea borrar. La idea del algoritmo es que el dato a borrar 
                 *	se coloque en una hoja o en un nodo que no tenga una de sus ramas.
                 **/
                Nodo cambiar = buscarMin(r.getDer());
                int aux = cambiar.getDato();
                cambiar.setDato(r.getDato());
                r.setDato(aux);
                r.setDer(borrar(r.getDer(), x));
                System.out.println("2 ramas");
            } else {
                r = (r.getIzq() != null) ? r.getIzq() : r.getDer();
                System.out.println("Entro cuando le faltan ramas ");
            }
        }
        return r;
    }

    /**
     * Busca un valor en el arbol
     * @param x -- valor a buscar
     * @return true o false segun este o no el dato en el arbol
     */
    public boolean buscar(int x) {
        return (buscar(this.raiz, x));


    }

    /**
     * Metodo que se encarga de la busqueda del dato en si
     * @param r -- Nodo
     * @param x -- Valor a buscar
     * @return False si el dato no esta, true si si esta
     */
    private boolean buscar(Nodo r, int x) {
        if (r == null) {
            return (false);
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            return (buscar(r.getIzq(), x));
        } else if (compara < 0) {
            return (buscar(r.getDer(), x));
        } else {
            return (true);
        }
    }

    /**
     *  Metodo que se encarga de buscar el nodo mas a la izquierda
     * @param r -- Nodo
     * @return r
     */
    private Nodo buscarMin(Nodo r) {
        for (; r.getIzq() != null; r = r.getIzq());
        return (r);
    }
       //imprimir preorden
    public ArrayList preOrden() {
        ArrayList l=new ArrayList();
        preOrden(raiz,l);
        return l;
    }

    /**
     * Metodo que imprime el arbol en preorden
     * @param reco -- nodo
     * @param l -- Lista de los nodos del arbol
     */
    private void preOrden(Nodo reco, ArrayList l) {
        if (reco != null) {
            l.add(reco.getDato() + " ");
            preOrden(reco.getIzq(),l);
            preOrden(reco.getDer(),l);
        }
    }

    /**
     * Metodo que imprime el arbol en orden inverso
     * @param reco -- Nodo
     * @param l -- lista con los nodos del arbol
     */
    private void inOrden(Nodo reco,ArrayList l) {
        if (reco != null) {
            inOrden(reco.getIzq(),l);
            l.add(reco.getDato() + " ");
            inOrden(reco.getDer(),l);
        }
    }

    /**
     * Metodo para imprimir el arbol en post orden
     * @return l, array con los nodos del arbol
     */
    public ArrayList postOrden() {
        ArrayList l=new ArrayList();
        postOrden(raiz,l);
        return l;
    }

    /**
     * Metodo que se encarga de imprimir el arbol en postorden
     * @param reco -- Nodo
     * @param l -- Lista de los nodos recorridos del arbol
     */
    private void postOrden(Nodo reco, ArrayList l) {
        if (reco != null) {
            postOrden(reco.getIzq(),l);
            postOrden(reco.getDer(),l);
            l.add(reco.getDato() + " ");
        }
    }

    /**
     * Metodo para imprimir el arbol con los niveles respectivos a cada nodo
     * @return l, lista con los nodos de la lista
     */
       public ArrayList impNiveles() {
        ArrayList l=new ArrayList();
        impNiveles(raiz, 1,l);
        return l;
    }

    /**
     * Metodo que se encarga de imprimir el arbol con los niveles
     * @param reco -- Nodo
     * @param nivel -- Nivel del nodo
     * @param l -- Lista de los nodos ya pasados del arbol
     */
    private void impNiveles(Nodo reco, int nivel,ArrayList l) {
        if (reco != null) {
            impNiveles(reco.getIzq(), nivel + 1, l);
            l.add(reco.getDato() + " Nivel: (" + nivel + ") ");
            impNiveles(reco.getDer(), nivel + 1, l);
        }
    }

    /**
     * Metodo que retorna las hojas del arbol
     * @return Lista de hijas del arbol
     */
    public ArrayList getHojas() {
        ArrayList l = new ArrayList();
        getHojas(this.raiz, l);
        return (l);
    }

    /**
     * Metodo que se encarga de encontrar las hojas del arbol
     * @param r -- Nodo
     * @param l -- Lista de nodos ya pasados
     */
    private void getHojas(Nodo r, ArrayList l) {
        if (r != null) {
            if (this.esHoja(r)) {
                l.add(r.getDato());
            }
            getHojas(r.getIzq(), l);
            getHojas(r.getDer(), l);
        }

    }

    /**
     * Metodo que revisa si un nodo es hoja
     * @param x -- Nodo
     * @return True si es hoja, false si no
     */
    protected boolean esHoja(Nodo x) {
        return (x != null && x.getIzq() == null && x.getDer() == null);
    }

    /**
     * Metodo que retorna si el nodo es padre
     * @param info -- valor del nodo
     * @return 0 si no es padre
     */
    public int padre(int info) {
        if (info == 0 || this.raiz == null) {
            return 0;
        }
        Nodo x = padre(this.raiz, info);
        if (x == null) {
            return 0;
        }
        return (x.getDato());
    }

    /**
     * Metodo que revisa si un Nodo es padre
     * @param x -- Nodo
     * @param info -- Valor del nodo
     * @return 0 si el nodo no es padre
     */
    private Nodo padre(Nodo x, int info) {
        if (x == null) {
            return null;
        }
        if ((x.getIzq() != null && x.getIzq().getDato()==(info)) || (x.getDer() != null && x.getDer().getDato()==(info))) {
            return (x);
        }
        Nodo y = padre(x.getIzq(), info);
        if (y == null) {
            return (padre(x.getDer(), info));
        } else {
            return (y);
        }
    }

    /**
     * Metodo que elimina las hojas
     */
    public void podar() {
        podar(this.raiz);
    }

    /**
     * Metodo que se encarga de borrar las hojas del arbol
     * @param x -- Nodo actual
     */
    private void podar(Nodo x) {
        if (x == null) {
            return;
        }
        if (this.esHoja(x.getIzq())) {
            x.setIzq(null);
        }
        if (this.esHoja(x.getDer())) {
            x.setDer(null);
        }
        podar(x.getIzq());
        podar(x.getDer());
    }
   
    
    
    

}
