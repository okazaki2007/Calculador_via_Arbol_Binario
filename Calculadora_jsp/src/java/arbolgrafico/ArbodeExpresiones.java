
package arbolgrafico;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Clase para generar arboles binarios a partir de expresiones aritmeticas
 * @author  Jeff
 *
 */
public class ArbodeExpresiones {
	Stack<Nodo1> pOperandos = new Stack<Nodo1>();
	Stack<String> pOperadores = new Stack<String>();



	final String blanco;           // Cadena de espacios en blanco
	final String operadores;       // Cadena con operadores para expresiones

	/**
	 * Constructor por omision
	 */


	public ArbodeExpresiones() {


		blanco = " \t";
		operadores = ")+-*/%^(";  //acomodados por precedencia;
	}


	private Nodo1 raiz;

	/**
	 * Metodo para obtener acceso a la raiz del arbol
	 * @return this.raiz -- raiz del arbol, privatizada
	 */
	public Nodo1 getRaiz() {
		return this.raiz;
	}

	/**
	 * Metodo para modificar la raiz del arbol
	 * @param r -- nuevo valor para la raiz del arbol
	 */
	public void setRaiz(Nodo1 r) {
		this.raiz = r;
	}

	/**
	 * Metodo para construir el arbol
	 * @param con -- Expresion del nodo
	 * @return True (1)
	 */
	public boolean contruir(String con) {
		construirArbol(con);
		return true;
	}

	/**
	 *  Metodo que construye el arbol en si
	 * @param expresion -- expresion matematica del arbol
	 * @return raiz -- nodo principal del arbol
	 */
	public Nodo1 construirArbol(String expresion) {
		StringTokenizer tokenizer;
		String token;


		tokenizer = new StringTokenizer(expresion, blanco + operadores, true);
		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();
			if (blanco.indexOf(token) >= 0)
				;               // Es un espacio en blanco, se ignora
			else if (operadores.indexOf(token) < 0) {
				// Es operando y lo guarda como nodo del arbol
				Nodo1 a;
				pOperandos.push(new Nodo1(token));
			} else if (token.equals(")")) { // Saca elementos hasta encontrar (
				while (!pOperadores.empty() && !pOperadores.peek().equals("(")) {
					guardarSubArbol();
				}
				pOperadores.pop();  // Saca el parentesis izquierdo
			} else {
				if (!token.equals("(") && !pOperadores.empty()) {
					//operador diferente de cualquier parentesis
					String op = (String) pOperadores.peek();
					while (!op.equals("(") && !pOperadores.empty()
							&& operadores.indexOf(op) >= operadores.indexOf(token)) {
						guardarSubArbol();
						if (!pOperadores.empty())
							op = (String) pOperadores.peek();
					}
				}

				pOperadores.push(token);  //Guarda el operador


			}

		}
		//Sacar todo lo que queda
		raiz = (Nodo1) pOperandos.peek();
		while (!pOperadores.empty()) {
			if (pOperadores.peek().equals("(")) {
				pOperadores.pop();
			} else {
				guardarSubArbol();
				raiz = (Nodo1) pOperandos.peek();
			}
		}
		return raiz;
	}

	/**
	 * Metodo privado para almacenar en la pila un subarbol
	 */
	private void guardarSubArbol() {
		Nodo1 op2 = (Nodo1) pOperandos.pop();
		Nodo1 op1 = (Nodo1) pOperandos.pop();
		pOperandos.push(new Nodo1(op2, pOperadores.pop(), op1));

	}

	/**
	 * Metodo para imprimir un arbol en inorden
	 *
	 * @param n -- nodo raiz
	 * @return imprime(n) -- String vacio
	 */
	public String getInorden(Nodo1 n){
		System.out.print("\n");
		return imprime(n);
	}

	/**
	 * Metodo para imprimir nodo
	 * @param n -- Nodo
	 * @return String vacio
	 */
	public String imprime(Nodo1 n) {
		if (n != null) {
			imprime(n.getNodoIzquierdo());
			System.out.print(n.getInformacion() + "");
			imprime(n.getNodoDerecho());}




		return "";
	}





	/**
	 * ((3-4)*(3+5))
	 * (((a+b)+c)+d)
	 * Metodo para imprimir un arbol en postorden
	 *
	 * @param n -- nodo raiz
	 * @return imprimePos(n) -- null
	 */
	public ArrayList getPostorden(Nodo1 n){
		System.out.print("\n");
		return imprimePos(n);}

	/**
	 * Metodo para imprimir el nodo de un arbol en postorden
	 * @param n -- nodo
	 * @return Null
	 */
	public ArrayList imprimePos(Nodo1 n) {
		if (n != null) {

			imprimePos(n.getNodoIzquierdo());
			imprimePos(n.getNodoDerecho());
			System.out.print(n.getInformacion() +  " ");
		}
		return null;
	}

	/**
	 * Metodo para imprimir un arbol en preorden
	 *
	 * @param n -- nodo raiz
	 * @return ImprimePre(n) -- Null
	 */
	public ArrayList getPreOrden(Nodo1 n){
		System.out.print("\n");
		return imprimePre(n);}

	/**
	 * Metodo para imprimir el nodo del arbol en preorden
	 * @param n -- Nodo
	 * @return Null
	 */
	public ArrayList imprimePre(Nodo1 n) {
		if (n != null) {
			System.out.print(n.getInformacion() + " ");
			imprimePre(n.getNodoIzquierdo());
			imprimePre(n.getNodoDerecho());

		}
		return null;
	}

	/**
	 * Metodo para mostrar el dibujo del arbol
	 * @return ArbolExpresionGrafico(this) -- dibujo del arbol
	 */
	public JPanel getdibujo() {


		return new ArbolExpresionGrafico(this);


	}

	/**
	 * Metodo para dibujar el arbol
	 * @return ArbolExpresionGrafico(this) -- dibujo del arbol
	 */

	public JPanel getPaint(){
		return new ArbolExpresionGrafico(this);
	}


}

