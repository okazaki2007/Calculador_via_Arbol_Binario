package com.example.calculadora_final;

/**
 *Clase para obtener datos gestados en la pagina
 * @author  Jeff
 */

public class result {
    static String expresion="";
    static String resultado="";

    public String getExpresion(){
        return this.expresion;

    }

    public String getResultado(){
     return this.resultado;

    }

    public void setExpresion(String expresion){
        this.expresion=expresion;

    }
    public void setResultado(String resultado){
        this.resultado=resultado;

    }
}
