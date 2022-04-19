package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.FeedbackMessage;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/feedback/reply" )
public class AdminFeedbackReplyControllerServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher( "/WEB-INF/views/contactUs/feedbackReply.jsp" );
        try {
            String email = request.getParameter( "email" );
            String message = request.getParameter( "message" );
            request.setAttribute( "email", email );
            request.setAttribute( "message", message );
            requestDispatcher.forward( request, response );

        } catch ( RuntimeException e ) {
            e.printStackTrace();
            response.sendRedirect( request.getContextPath() + "/admin" );
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            String emailAddress = request.getParameter( "email" );
            String message = request.getParameter( "reply" );

            System.out.println( "***************" + emailAddress );

            FeedbackMessage feedbackMessage = new FeedbackMessage( message, emailAddress );
            System.out.println( feedbackMessage );
            DomainFacade.sendFeedbackReplyEmail( feedbackMessage );
            response.sendRedirect( request.getContextPath() + "/admin" );
        } catch ( RuntimeException e ) {
            e.printStackTrace();
            response.sendRedirect( request.getContextPath() + "/admin" );
        }
    }
}
