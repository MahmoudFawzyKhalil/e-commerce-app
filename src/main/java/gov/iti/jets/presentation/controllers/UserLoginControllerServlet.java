package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet( "/login" )
public class UserLoginControllerServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Optional<Cookie> optionalCookie = Arrays.stream( request.getCookies() )
                .filter( ( c ) -> c.getName().equals( "rememberMeCookie" ) )
                .findFirst();

        if ( optionalCookie.isPresent() ) {
            System.out.println( optionalCookie.get().getName() );
            //TODO Fix remember me
        }
        request.getRequestDispatcher( "/WEB-INF/views/login/login.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String email = request.getParameter( "emailAddress" );
        String password = request.getParameter( "password" );
        String rememberMe = request.getParameter( "rememberMe" );

        Optional<User> optionalUser = DomainFacade.loginUser( email, password );
        if ( optionalUser.isPresent() ) {
            request.getSession().setAttribute( "user", optionalUser );
            User user = optionalUser.get();
            response.sendRedirect( "home" );
            if ( rememberMe != null ) {
                String emailPasswordCookieString = user.getEmail() + ";" + user.getPassword();
                Cookie rememberMeCookie = new Cookie( "rememberMeCookie", emailPasswordCookieString );
                response.addCookie( rememberMeCookie );
            }
        } else {

            response.sendRedirect( "login?failed=true" );

        }
    }
}
