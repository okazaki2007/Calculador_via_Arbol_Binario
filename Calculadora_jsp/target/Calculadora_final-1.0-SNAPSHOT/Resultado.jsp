
<%@ page import="com.example.calculadora_final.*" %>
<%@ page import="java.io.IOException" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Resultado</title>
</head>
<body>
<body style="background: url(images/matw.jpg)"></body>
<div align="center"  />
<h2>Resultado de la expresion ingresada</h2>
</div>

<br>
<br>

<br>



<%





    try {
        SimuladorArbolBinario simulador = new SimuladorArbolBinario();
        result r=new result();
        Fecha w=new Fecha();
        String num = request.getParameter("expresion");

        if (num != null) {

            simulador.insertar(num);

            out.println("El inorden es: " + simulador.inOrden());
            out.println("<br> <br>" + "El preorden es: " + simulador.preOrden());
            out.println("<br><br>" + "El postorden es: " + simulador.posOrden());
            out.println("<br><br>" + "Los niveles son: " + simulador.Nivel());


            String t = simulador.inOrden();
            double ou = simulador.calculation(t + ".0");
            double ot = simulador.calculation(num + ".0");
            String m = ot + "";

            r.setExpresion(num);
            r.setResultado(m);


           Writer writer=new Writer();
           writer.Write(num,m,w.getFormatoFecha(),w.getFormatoHora());



        if(ou==ot) {
                out.println("<br>"+ "El resultado de la expresion recorriendo el arbol de forma recursiva es correcto y el resultado es: "+ou);

            }else{
                out.println("<br>"+"El resultado de la expresion recorriendo el arbol de forma recursiva no se concreta por lo que se evalua con el metodo de evaluacion de expresiones y el resultado es: "+ ot);

            }

        }else{
            out.print("<br> <br> <br> <br>"+"El valor ingresado no pertenece a una expresion aritmetrica");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");


        }

    }catch (Exception e){
        System.err.println(e.getMessage());
        out.print("<br> <br> <br> <br> <br> <br> <br>"+"El valor ingresado no pertenece a una expresion aritmetrica de numeros");
    }

%>






<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<div align="right" />


<form method="post" action="Final.jsp">
        <p><input type="submit" value="Consultar datos de visita a la pagina" > </p>

</form>
<form method="" action="index.jsp">
    <p><input type="submit" value="Volver menu principal" > </p>

</form>

</div>


</body>
</html>
