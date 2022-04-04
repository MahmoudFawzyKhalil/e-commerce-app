package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.UUID;

@WebServlet( "/reset/password" )
public class UserPasswordResetControllerServlet extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher( "/WEB-INF/views/login/resetPassword/getEmail.jsp" ).forward( request, response );
    }


    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        System.out.println( "hello inside password reset" );
        String email = request.getParameter( "email" );
        String passwordResetId = UUID.randomUUID().toString();

        boolean savePasswordResetId = DomainFacade.resetPassword( email, passwordResetId );

        if ( savePasswordResetId ) {
            ServletContext application = getServletConfig().getServletContext();
            application.setAttribute( "testApplication", passwordResetId );
            System.out.println( "Application: " + application.getAttribute( "testApplication" ) );
        }


        request.getRequestDispatcher( "/WEB-INF/views/login/resetPassword/resetPassword.jsp" ).forward( request, response );
    }

}
