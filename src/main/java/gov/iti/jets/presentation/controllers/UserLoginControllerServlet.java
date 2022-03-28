package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@WebServlet( "/login" )
public class UserLoginControllerServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        if ( loginWithCookie( request ) ) {
            response.sendRedirect( "home" );
            return;
        }
        if ( request.getSession().getAttribute( "user" ) != null ) {
            response.sendRedirect( "home" );
            return;
        }

        request.getRequestDispatcher( "/WEB-INF/views/login/login.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String email = request.getParameter( "emailAddress" );
        String password = request.getParameter( "password" );
        String rememberMe = request.getParameter( "rememberMe" );

        Optional<User> optionalUser = DomainFacade.loginUserRememberMe( email, password );
        if ( optionalUser.isPresent() ) {
            request.getSession().setAttribute( "user", optionalUser );
            User user = optionalUser.get();
            if ( rememberMe != null ) {
                String emailPasswordCookieString = user.getEmail() + "+" + user.getPassword();
                Cookie rememberMeCookie = new Cookie( "rememberMeCookie", emailPasswordCookieString );
                response.addCookie( rememberMeCookie );
            }
            response.sendRedirect( "home" );

        } else {

            response.sendRedirect( "login?failed=true" );

        }
    }

    private boolean loginWithCookie( HttpServletRequest request ) {
        Optional<Cookie> optionalCookie = Optional.empty();
        if ( request.getCookies() != null ) {
            optionalCookie = Stream.of( request.getCookies() )
                    .filter( ( c ) -> c.getName().equals( "rememberMeCookie" ) )
                    .findFirst();
        }
        if ( optionalCookie.isPresent() ) {
            String cookieValue = optionalCookie.get().getValue();
            String userEmailFromCookie = cookieValue.substring( 0, cookieValue.indexOf( "+" ) );
            String userPasswordFromCookie = cookieValue.substring( cookieValue.indexOf( "+" ) + 1 );
//            System.out.println( userPasswordFromCookie );

            Optional<User> optionalUser = DomainFacade.loginUserRememberMe( userEmailFromCookie, userPasswordFromCookie );
            if ( optionalUser.isPresent() ) {
                request.getSession().setAttribute( "user", optionalUser );
                return true;
            }
        }
        return false;
    }


}
