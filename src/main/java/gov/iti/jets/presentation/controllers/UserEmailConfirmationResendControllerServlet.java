package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/confirm/resend" )
public class UserEmailConfirmationResendControllerServlet extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher( "/WEB-INF/views/emailConfirmation/emailResend.jsp" ).forward( request, response );
    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        try {
            String email = request.getParameter( "email" );

            boolean isConfirmationEmailSent = DomainFacade.resendConfirmationEmail( email );
            if ( isConfirmationEmailSent ) {
                request.getRequestDispatcher( "/WEB-INF/views/emailConfirmationStatus/emailResendSuccess.jsp" ).forward( request, response );
            } else {
                request.getRequestDispatcher( "/WEB-INF/views/emailConfirmationStatus/emailResendFailure.jsp" ).forward( request, response );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            response.sendRedirect( request.getContextPath() + "/home" );
        }
    }
}
