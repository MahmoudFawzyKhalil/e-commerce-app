package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/confirm" )
public class EmailConfirmationControlletServlet extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        request.getRequestDispatcher( "/WEB-INF/views/emailConfirmation/emailConfirmation.jsp" ).forward( request, response );

    }


    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String confirmationId = request.getParameter( "confirmationId" );

        boolean isConfirmed = DomainFacade.confirmUserRegistration( confirmationId );

        if ( isConfirmed ) {
            request.getRequestDispatcher( "/WEB-INF/views/status/success.jsp" ).forward( request, response );
        } else {
            request.getRequestDispatcher( "/WEB-INF/views/status/failure.jsp" ).forward( request, response );
        }

    }


}
