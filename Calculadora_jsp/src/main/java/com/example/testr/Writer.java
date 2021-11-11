package com.example.calculadora_final;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *Clase para escritura de datos en .CSV
 * @author  Juan
 */
public class Writer {

    /**
     * Metodo escribir en el archivo .CSV
     * @param expresion -- Expresion evaluada
     * @param resultado --Resultado de expresion evaluada
     * @param fecha-- fecha en la que se hizo la evaluacion
     * @param hora--hora en la que se realiza la consulta
     */


public void Write(String expresion, String resultado,String fecha,String hora) throws IOException {
    File f=new File("C:/Users/admin/Videos/Calculadora_final/src/main/webapp/Expresiones.CSV");
    FileWriter fr=new FileWriter(f,true);
    try (BufferedWriter br=new BufferedWriter(fr)){

    br.write("Expresion evaluada: "+expresion+",  "+"Resultado: "+resultado+",  "+"Fecha: "+fecha+",  "+"Hora: "+hora+"\n");



    }
    catch (Exception e){
        System.err.println(e.getMessage());
    }
}




}







