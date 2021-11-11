
package com.example.calculadora_final;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Jeff, Juan Quesada
 */
public class SimuladorArbolBinario {


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
     //  return (this.miArbol.agregar(dato));
     // return (this.a);
      return (this.miArbol.contruir(dato));
    }

    public ArrayList Nivel(){
        ArrayList f=new ArrayList();
        ArrayList it=this.miArbol.impNiveles(miArbol.getRaiz(),0,f);

        return f;
    }



    /**
     * Metodo que retorna la lista de los nodos del arbol en forma string en preorden
     * @return Lista de nodos en preorden
     */

  public String preOrden() {
      String it = this.miArbol.getPreOrden(miArbol.getRaiz());

      return it;
  }



    /**
     * Metodo que retorna la lista de los nodos del arbol en forma string en postorden
     * @return Lista de nodos en postorden concadenados en un String
     */
    public String inOrden() {
        String it = this.miArbol.getInorden(miArbol.getRaiz());//el problema esta aqui
        return it;

    }




    /**
     * Metodo que retorna la lista de nodos en forma string  en  inorden
     * @return Lista de nodos en orden inorden
     */

    public String posOrden() {
       String it = this.miArbol.getPostorden(miArbol.getRaiz());
       return it;

    }


    /**
     * Metodo que se encarga de evaluar el string en si
     * @param a -- String
     * @return resutlado de la operacion
     */
    public static Double calculation(String a)
    {
        Stack<Double> values=new Stack<Double>();
        Stack<Character> op=new Stack<Character>();
        for(int i=0;i<a.length()-1;i++)
        {
            if(a.charAt(i)>='0'&&a.charAt(i)<='9')
            {
                String add="";
                while(i<a.length()-1&&a.charAt(i)>='0'&&a.charAt(i)<='9')

                    add=add+a.charAt(i++);
                values.push((double) Double.parseDouble(add));
                i--;
            }
            else if(a.charAt(i)=='(')
                op.push(a.charAt(i));
            else if(a.charAt(i)==')')
            {
                while(op.peek()!='(')
                    values.push((double) calculate(op.pop(),values.pop(),values.pop()));
                op.pop();
            }
            else if(a.charAt(i)=='+'||a.charAt(i)=='-'||a.charAt(i)=='*'||a.charAt(i)=='%'||a.charAt(i)=='/'||a.charAt(i)=='^' )
            {
                while(!op.empty()&&check(a.charAt(i),op.peek()))
                    values.push((double) calculate(op.pop(),values.pop(),values.pop()));
                op.push(a.charAt(i));
            }
        }
        while (!op.empty())
            values.push((double) calculate(op.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    /**
     * Metodo que se encarga de la operacion en si
     * @param op -- String operando
     * @param b -- Segundo Numero de la operacion
     * @param a -- Primer numero en la operacion
     * @return Resultado de la operacion
     */
    public static double calculate(char op,double b,double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '^':
                return Math.pow(a, b);

            case '%':
                return  (a/100)*b;

        }
        return 0;
    }

    /**
     * Metodo que revisa la prioridad de los operandos
     * @param op1 -- operando 1
     * @param op2 -- operando 2
     * @return True si los operandos estan en orden de prioridad
     */
    public static boolean check(char op1,char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if (( op1=='%' ||op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-' ))
            return false;
        if ((op1 == '^') && (op2 == '+' || op2 == '-'))
            return false;
        if ((op1 == '^') && (op2=='%' ||op2 == '*' || op2 == '/' ))
            return false;
        if(op1=='^'&& op2=='^')
            return true;
        else
            return true;
    }




}
