package gov.iti.jets.presentation.controllers;

import gov.iti.jets.presentation.util.CookieUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet( "/logout" )
public class UserLogoutControllerServlet extends HttpServlet {

    //TODO remove
    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        doPost( request, response );

    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        Optional<Cookie> optionalRememberMeCookie = CookieUtil.getCookie( request.getCookies(), "rememberMeCookie" );
        HttpSession session = request.getSession();

        if ( optionalRememberMeCookie.isPresent() ) {
            Cookie cookie = optionalRememberMeCookie.get();
            cookie.setMaxAge( 0 );
            response.addCookie( cookie );
        }

        session.invalidate();

        response.sendRedirect( "home" );
    }
}
