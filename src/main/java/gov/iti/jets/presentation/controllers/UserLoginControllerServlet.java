package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@WebServlet( "/login" )
public class UserLoginControllerServlet extends HttpServlet {


    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String forwardLocation = "home";

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute( "user" );
        boolean isAlreadyLoggedIn = user != null;

        if ( isAlreadyLoggedIn ) {
            forwardLocation = determineUserForwardLocation( user );
            updateSessionShoppingCart( request, user );
            response.sendRedirect( forwardLocation );
            return;
        }

        boolean userLoggedInWithCookie = loginWithCookie( request );
        if ( userLoggedInWithCookie ) {
            user = (User) session.getAttribute( "user" );
            forwardLocation = determineUserForwardLocation( user );
            updateSessionShoppingCart( request, user );
            response.sendRedirect( forwardLocation );
            return;
        }

        request.getRequestDispatcher( "/WEB-INF/views/login/login.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String forwardLocation = "home";

        String email = request.getParameter( "emailAddress" );
        String password = request.getParameter( "password" );
        String rememberMe = request.getParameter( "rememberMe" );

        Optional<User> optionalUser = DomainFacade.loginUser( email, password );

        if ( optionalUser.isPresent() ) {
            User user = optionalUser.get();
            request.getSession().setAttribute( "user", user );
            if ( rememberMe != null ) {
                String emailPasswordCookieString = user.getEmail() + "+" + user.getPassword();
                Cookie rememberMeCookie = new Cookie( "rememberMeCookie", emailPasswordCookieString );
                response.addCookie( rememberMeCookie );
            }

            forwardLocation = determineUserForwardLocation( user );
            updateSessionShoppingCart( request, user );
            response.sendRedirect( forwardLocation );

        } else {
            response.sendRedirect( "login?failed=true" );
        }
    }

    private boolean loginWithCookie( HttpServletRequest request ) {
        Optional<Cookie> optionalCookie = Optional.empty();
        boolean result = false;

        if ( request.getCookies() != null ) {
            optionalCookie = Stream.of( request.getCookies() )
                    .filter( ( c ) -> c.getName().equals( "rememberMeCookie" ) )
                    .findFirst();
        }
        if ( optionalCookie.isPresent() ) {
            String cookieValue = optionalCookie.get().getValue();
            String userEmailFromCookie = cookieValue.substring( 0, cookieValue.indexOf( "+" ) );
            String userPasswordFromCookie = cookieValue.substring( cookieValue.indexOf( "+" ) + 1 );

            Optional<User> optionalUser = DomainFacade.loginUserRememberMe( userEmailFromCookie, userPasswordFromCookie );
            if ( optionalUser.isPresent() ) {
                request.getSession().setAttribute( "user", optionalUser.get() );
                result = true;
            }
        }
        return result;
    }


    private String determineUserForwardLocation( User user ) {
        Role userRole = user.getRole();
        switch ( userRole ) {
            case ADMIN:
                return "admin";
            case CUSTOMER:
                return "home";
            default:
                return null;
        }
    }


    //TODO test method
    ///////Merging shoppingCarts
    private void updateSessionShoppingCart( HttpServletRequest request, User user ) {

        Optional<ShoppingCart> optionalStoredShoppingCart = user.getShoppingCart();
        HttpSession session = request.getSession();

        if ( optionalStoredShoppingCart.isPresent() ) {

            Set<CartLineItem> userCartLineItems = optionalStoredShoppingCart.get().getCartLineItemsUnmodifiable();
            ShoppingCart currentSessionShoppingCart = (ShoppingCart) session.getAttribute( "shoppingCart" );

            if ( currentSessionShoppingCart != null ) {
                userCartLineItems.forEach( currentSessionShoppingCart::addCartLineItem );
                user.setShoppingCart( currentSessionShoppingCart );
            } else {
                session.setAttribute( "shoppingCart", optionalStoredShoppingCart.get() );
            }
        }
    }


}
