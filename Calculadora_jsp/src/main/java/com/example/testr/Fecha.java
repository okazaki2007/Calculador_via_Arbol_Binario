package com.example.testr;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {


    public String getFormatoFecha(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return dtf.format(LocalDateTime.now());

    }

    public String getFormatoHora(){
        DateTimeFormatter dth = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dth.format(LocalDateTime.now());

    }



}
