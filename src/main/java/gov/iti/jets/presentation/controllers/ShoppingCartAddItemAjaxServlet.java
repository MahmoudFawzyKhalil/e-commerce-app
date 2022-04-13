package gov.iti.jets.presentation.controllers;


import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.CartLineItem;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.ShoppingCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet( "/cart/add" )
public class ShoppingCartAddItemAjaxServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute( "shoppingCart" );
        if ( shoppingCart == null ) {
            shoppingCart = new ShoppingCart();
            session.setAttribute( "shoppingCart", shoppingCart );
        }

        String addedProductId = request.getParameter( "id" );

        try {

            int parsedAddedProductId = Integer.parseInt( addedProductId );
            Optional<Product> addedProduct = DomainFacade.findProductById( parsedAddedProductId );

            if ( addedProduct.isPresent() ) {
                CartLineItem addedCartLineItem = new CartLineItem( addedProduct.get(), 1 );
                shoppingCart.addCartLineItem( addedCartLineItem );
                System.out.println( shoppingCart.getCartLineItemsUnmodifiable() );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            response.sendError( 400 );
        }
    }

}
