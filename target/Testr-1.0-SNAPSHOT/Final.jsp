<%@ page import="com.example.testr.result" %>
<%@ page import="com.example.testr.Fecha" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tabla de datos</title>

</head>

<body>
<body style="background: url(images/2.jpg)"></body>
<div align="center">

<table border="1" cellpadding="5">
    <caption><h2>Datos de la visita a la pagina</h2></caption>
    <tr>
        <th>Expresion evaluada</th>
        <th>Resultado</th>
        <th>Fecha</th>
        <th>Hora</th>


    </tr>
    <c:forEach var="user" items="${listUsers.rows}">
        <tr>
            <%
                result r=new result();
                Fecha f=new Fecha();

            %>
            <td><%=r.getExpresion()%></td>
            <td><%=r.getResultado()%></td>
            <td><%=f.getFormatoFecha()%></td>
            <td><%=f.getFormatoHora()%></td>

            <%
                r.setResultado("");
                r.setExpresion("");
            %>

        </tr>
    </c:forEach>
</table>

</div>


</body>

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
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div align="right" >
<a href="index.jsp"><h4>Volver pagina principal</h4></a>


</div>


</html>
