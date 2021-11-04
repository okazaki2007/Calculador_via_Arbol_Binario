package com.Calculadora.Calculadora;



import arbolgrafico.eval;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("a"));
        double out=eval.calculation(request.getParameter("a")+"+0.0");

        request.setAttribute("var",out);

        RequestDispatcher rd;
        rd=request.getRequestDispatcher("/result.jsp");
        rd.forward(request,response);


    }


}