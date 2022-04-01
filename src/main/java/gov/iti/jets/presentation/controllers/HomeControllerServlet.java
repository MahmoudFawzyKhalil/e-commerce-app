package gov.iti.jets.presentation.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/home" )
public class HomeControllerServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher( "/WEB-INF/views/home/home.jsp" ).forward( request, response );
    }
}
