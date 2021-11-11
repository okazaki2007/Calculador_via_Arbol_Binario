package com.example.calculadora_final;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *Clase para obtener parametros de fecha y hora
 * @author  Jeff
 */

public class Fecha {


    /**
     * Metodo para devolver fecha actual
     * @return fecha local
     */


    public String getFormatoFecha(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
        return dtf.format(LocalDateTime.now());

    }

    /**
     * Metodo para devolver hora actual
     * @return hora local
     */

    public String getFormatoHora(){
        DateTimeFormatter dth = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dth.format(LocalDateTime.now());

    }



}
