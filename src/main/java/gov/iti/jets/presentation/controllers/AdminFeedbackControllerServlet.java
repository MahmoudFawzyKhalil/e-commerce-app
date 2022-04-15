package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/feedback" )
public class AdminFeedbackControllerServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher( "/WEB-INF/views/contactUs/feedback.jsp" );
        try {

            request.setAttribute( "messageList", DomainFacade.getAllFeedbackMessage() );
            requestDispatcher.forward( request, response );

        } catch ( Exception e ) {
            e.printStackTrace();
            response.sendRedirect( request.getContextPath() + "/admin" );
        }
    }

}
