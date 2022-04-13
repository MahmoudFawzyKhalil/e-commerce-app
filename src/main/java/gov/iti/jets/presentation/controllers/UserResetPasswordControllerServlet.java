package gov.iti.jets.presentation.controllers;


import gov.iti.jets.domain.DomainFacade;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet( "/reset/password" )
public class UserResetPasswordControllerServlet extends HttpServlet {
    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String requestEmail = request.getParameter( "email" );
        String requestConfirmationId = request.getParameter( "confirmationId" );
        String requestNewPassword = request.getParameter( "newPassword" );
        try {

            ServletContext application = getServletConfig().getServletContext();

            Map<String, String> emailPasswordResetIdMap = (Map<String, String>) application.getAttribute( "emailPasswordResetIdMap" );
            String confirmationId = emailPasswordResetIdMap.get( requestEmail );

            if ( confirmationId.equals( requestConfirmationId ) ) {

                DomainFacade.resetPassword( requestEmail, requestNewPassword );

                emailPasswordResetIdMap.remove( requestEmail );

                response.sendRedirect( request.getContextPath() + "/login" );

            } else {
                throw new IllegalArgumentException();
            }


        } catch ( Exception e ) {
            e.printStackTrace();
            request.setAttribute( "email", requestEmail );
            request.setAttribute( "failed", "true" );
            request.getRequestDispatcher( "/WEB-INF/views/login/resetPassword/resetPassword.jsp" ).forward( request, response );
        }

    }
}
