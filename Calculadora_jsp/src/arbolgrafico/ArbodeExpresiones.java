/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgrafico;


import java.util.*;
import javax.swing.JPanel;

/**
 * Clase para generar arboles binarios a partir de expresiones aritmeticas
 * @author  Amparo L�pez Gaona
 * @version 1a. ed.
 */
public class ArbodeExpresiones {
	Stack<arbolgrafico.Nodo1> pOperandos = new Stack<arbolgrafico.Nodo1>();
	Stack<String> pOperadores = new Stack<String>();


	// Pila pOperandos;               // Pila de operandos
	// Pila pOperadores;              // Pila de operadores
	final String blanco;           // Cadena de espacios en blanco
	final String operadores;       // Cadena con operadores para expresiones

	/**
	 * Constructor por omision
	 */


	public ArbodeExpresiones() {

		//pOperandos = new Pila();
		//pOperadores = new Pila();
		blanco = " \t";
		operadores = ")+-*/%^(";  //acomodados por precedencia;
	}

	/**
	 * Metodo para construir un arbol para una expresion aritmetica dada.
	 *
	 * @param expresion -- Cadena con la expresion aritmetica
	 * @return NodoArbol -- nodo raiz del arbol creado
	 */
	private arbolgrafico.Nodo1 raiz;

	public arbolgrafico.Nodo1 getRaiz() {
		return this.raiz;
	}

	public void setRaiz(arbolgrafico.Nodo1 r) {
		this.raiz = r;
	}

	public boolean contruir(String con) {
		construirArbol(con);
		return true;
	}

	public arbolgrafico.Nodo1 construirArbol(String expresion) {
		StringTokenizer tokenizer;
		String token;
		//Nodo1 raiz = null;

		tokenizer = new StringTokenizer(expresion, blanco + operadores, true);
		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();
			if (blanco.indexOf(token) >= 0)
				;               // Es un espacio en blanco, se ignora
			else if (operadores.indexOf(token) < 0) {
				// Es operando y lo guarda como nodo del arbol
				arbolgrafico.Nodo1 a;
				pOperandos.push(new arbolgrafico.Nodo1(token));
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
				//System.out.print(pOperadores.peek()+" ");

			}

		}
		//Sacar todo lo que queda
		raiz = (arbolgrafico.Nodo1) pOperandos.peek();
		while (!pOperadores.empty()) {
			if (pOperadores.peek().equals("(")) {
				pOperadores.pop();
			} else {
				guardarSubArbol();
				raiz = (arbolgrafico.Nodo1) pOperandos.peek();
			}
		}
		return raiz;
	}

	/*
	 * Metodo privado para almacenar en la pila un subarbol
	 */
	private void guardarSubArbol() {
		arbolgrafico.Nodo1 op2 = (arbolgrafico.Nodo1) pOperandos.pop();
		arbolgrafico.Nodo1 op1 = (arbolgrafico.Nodo1) pOperandos.pop();
		pOperandos.push(new arbolgrafico.Nodo1(op2, pOperadores.pop(), op1));

	}

	/**
	 * Metodo para imprimir un arbol en inorden
	 *
	 * @param n -- nodo raiz
	 * @return
	 */
	public String getInorden(Nodo1 n){
		System.out.print("\n");
		return imprime(n);
	}

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
	 * @return
	 */
	public ArrayList getPostorden(Nodo1 n){
		System.out.print("\n");
		return imprimePos(n);}

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
	 * @return
	 */
	public ArrayList getPreOrden(Nodo1 n){
		System.out.print("\n");
		return imprimePre(n);}

	public ArrayList imprimePre(Nodo1 n) {
		if (n != null) {
			System.out.print(n.getInformacion() + " ");
			imprimePre(n.getNodoIzquierdo());
			imprimePre(n.getNodoDerecho());

		}
		return null;
	}

	public JPanel getdibujo() {
		// return new ArbolExpresionGrafico(this);

		return new ArbolExpresionGrafico(this);


	}


	public JPanel getPaint(){
		return new ArbolExpresionGrafico(this);
	}

	/*public static void main(String[] pps) {
		ArbodeExpresiones expr = new ArbodeExpresiones();

		Scanner leer = new Scanner(System.in);
		System.out.println("Digite la expresion aritmetica");
		String expresion = leer.nextLine();
			if (pps.length < 1)
		System.out.println("Debe ejecutarse: ArbolExp \"expresion con espacios y parentesis\" ");
		else
		for (int i = 0; i < pps.length; i++) {
			arbolgrafico.Nodo1 raiz = expr.construirArbol(expresion);
			System.out.print("El arbol es ");
			expr.imprime(raiz);
			System.out.print("\nEl arbol en postfija es ");
			expr.imprimePos(raiz);
			//		System.out.println("\n");
			//	System.out.print("\nEl arbol en prefija es ");
			expr.imprimePre(raiz);
			//System.out.println("\n\n");


			System.out.println("preorde ");
			expr.imprimePre(raiz);
			//  }
		}

	}

	 */
}

