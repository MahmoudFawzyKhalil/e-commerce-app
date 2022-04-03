package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet( "/cart" )
public class ShoppingCartControllerServlet extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        var session = request.getSession();
        var shoppingCart = (ShoppingCart) session.getAttribute( "shoppingCart" );

        if ( shoppingCart != null ) {
            boolean shoppingCartOutdated = shoppingCart.refreshAndValidateData();
            
            if ( shoppingCartOutdated ) {
                request.setAttribute( "shoppingCartOutdated", true );
            }
        }


        request.getRequestDispatcher( "/WEB-INF/views/cart/cart.jsp" ).forward( request, response );
    }

}
