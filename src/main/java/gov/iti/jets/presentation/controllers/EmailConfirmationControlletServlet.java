package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet( "/confirm" )
public class EmailConfirmationControlletServlet extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        request.getRequestDispatcher( "/WEB-INF/views/emailConfirmation/emailConfirmation.jsp" ).forward( request, response );

    }


    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String confirmationId = request.getParameter( "confirmationId" );
//        Optional<User>

    }


}
