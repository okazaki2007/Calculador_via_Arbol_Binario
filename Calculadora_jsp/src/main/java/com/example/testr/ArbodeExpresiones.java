/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testr;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Clase para generar arboles binarios a partir de expresiones aritmeticas
 * @author
 * @version 1a. ed.
 */
public class ArbodeExpresiones {

	Stack<Nodo1> pOperandos = new Stack<Nodo1>();
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
	private Nodo1 raiz;

	public Nodo1 getRaiz() {
		return this.raiz;
	}

	public void setRaiz(Nodo1 r) {
		this.raiz = r;
	}

	public boolean contruir(String con) {
		construirArbol(con);
		return true;
	}
	static String u;

	public Nodo1 construirArbol(String expresion) {
		u="";
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

				pOperandos.push(new Nodo1(token));
			} else if (token.equals(")")) { // Saca elementos hasta encontrar (
				while (!pOperadores.empty() && !pOperadores.peek().equals("(")) {
					guardarSubArbol();

				}
				pOperadores.pop();  // Saca el parentesis izquierdo
			} else {
				if (!pOperadores.empty()) {
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
				System.out.print(u);

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

	/*
	 * Metodo privado para almacenar en la pila un subarbol
	 */
	private void guardarSubArbol() {
		Nodo1 op2 = (Nodo1) pOperandos.pop();
		Nodo1 op1 = (Nodo1) pOperandos.pop();
		pOperandos.push(new Nodo1(op2, pOperadores.pop(), op1));

	}



	public ArrayList impNiveles(Nodo1 reco, int nivel, ArrayList l) {
		if (reco != null) {
			impNiveles(reco.getNodoIzquierdo(), nivel + 1, l);
			l.add( " Nivel "+ nivel+" = "+reco.getInformacion());
			impNiveles(reco.getNodoDerecho(), nivel + 1, l);
		}
		return l;
	}
	/**
	 * Metodo para imprimir un arbol en inorden
	 *
	 * @param n -- nodo raiz
	 * @return
	 */
	static String r;
	public String getInorden(Nodo1 n){
		r="";
		return imprime(n);
	}
	public String imprime(Nodo1 n) {
		if (n != null) {

			imprime(n.getNodoIzquierdo());
			r+=" "+n.getInformacion();
			imprime(n.getNodoDerecho());}



		return r;

	}







	/**
	 * ((3-4)*(3+5))
	 * (((a+b)+c)+d)
	 * Metodo para imprimir un arbol en postorden
	 *
	 * @param n -- nodo raiz
	 * @return
	 */
	public String getPostorden(Nodo1 n){
		System.out.print("\n");
		r="";
		return imprimePos(n);}

	public String imprimePos(Nodo1 n) {
		if (n != null) {

			imprimePos(n.getNodoIzquierdo());
			imprimePos(n.getNodoDerecho());
			r+=" "+n.getInformacion();

		}
		return r;
	}

	/**
	 * Metodo para imprimir un arbol en preorden
	 *
	 * @param n -- nodo raiz
	 * @return
	 */
	public String getPreOrden(Nodo1 n){
		r="";
		return imprimePre(n);}

	public String imprimePre(Nodo1 n) {
		if (n != null) {
			r+=" "+n.getInformacion();
			imprimePre(n.getNodoIzquierdo());
			imprimePre(n.getNodoDerecho());

		}
		return r;
	}






}

