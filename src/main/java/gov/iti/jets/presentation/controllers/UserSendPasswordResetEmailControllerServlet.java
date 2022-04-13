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

@WebServlet( "/reset/password/email" )
public class UserSendPasswordResetEmailControllerServlet extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher( "/WEB-INF/views/login/resetPassword/getEmail.jsp" ).forward( request, response );
    }


    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String email = request.getParameter( "email" );

        String passwordResetId = null;

        try {

            passwordResetId = DomainFacade.sendResetPasswordEmail( email );

            addResetPasswordIdToApplicationContext( email, passwordResetId );

            request.setAttribute( "email", email );
            request.getRequestDispatcher( "/WEB-INF/views/login/resetPassword/resetPassword.jsp" ).forward( request, response );

        } catch ( Exception e ) {
            e.printStackTrace();
            request.setAttribute( "failed", "true" );
            request.getRequestDispatcher( "/WEB-INF/views/login/resetPassword/getEmail.jsp" ).forward( request, response );
        }


    }


    private void addResetPasswordIdToApplicationContext( String email, String resetPasswordId ) {
        ServletContext application = getServletConfig().getServletContext();
        Map<String, String> emailPasswordResetIdMap = (Map<String, String>) application.getAttribute( "emailPasswordResetIdMap" );

        if ( emailPasswordResetIdMap == null ) {
            emailPasswordResetIdMap = new HashMap<>();
        }

        emailPasswordResetIdMap.put( email, resetPasswordId );
        application.setAttribute( "emailPasswordResetIdMap", emailPasswordResetIdMap );
    }


}
