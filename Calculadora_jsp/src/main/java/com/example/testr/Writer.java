package com.example.testr;
import java.io.*;



public class Writer {
public void Write(String expresion, String resultado,String fecha,String hora) throws IOException {
    File f=new File("C:/Users/admin/Videos/Proyecto_2/src/main/webapp/Expresiones.CSV");
    FileWriter fr=new FileWriter(f,true);
    try (BufferedWriter br=new BufferedWriter(fr)){

    br.write("Expresion evaluada: "+expresion+",  "+"Resultado: "+resultado+",  "+"Fecha: "+fecha+",  "+"Hora: "+hora+"\n");



    }
    catch (Exception e){
        System.err.println(e.getMessage());
    }
}




}







