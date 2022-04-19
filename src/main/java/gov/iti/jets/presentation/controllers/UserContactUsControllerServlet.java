package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.Address;
import gov.iti.jets.domain.models.FeedbackMessage;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet( "/contactUs" )
public class UserContactUsControllerServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher( "/WEB-INF/views/contactUs/contactUs.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {

            String emailAddress = request.getParameter( "email-address" );
            String message = request.getParameter( "message" );

            System.out.println( "do posttt" );
            FeedbackMessage feedbackMessage = new FeedbackMessage( message, emailAddress );

            DomainFacade.addFeedbackMessage( feedbackMessage );
            response.sendRedirect( "home" );
        } catch ( RuntimeException e ) {
            e.printStackTrace();
            response.sendRedirect( "home" );
        }
    }
}
