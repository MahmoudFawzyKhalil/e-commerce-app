package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.models.ShoppingCart;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/cart/update" )
public class ShoppingCartUpdateQuantityAjaxServlet extends HttpServlet {
    private final Jsonb jsonb = JsonbBuilder.create();

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


        try {
            PrintWriter out = response.getWriter();
            int productToUpdateId = Integer.parseInt( request.getParameter( "id" ) );
            int productNewQuantity = Integer.parseInt( request.getParameter( "quantity" ) );

            HttpSession session = request.getSession();
            ShoppingCart sessionShoppingCart = (ShoppingCart) session.getAttribute( "shoppingCart" );
            sessionShoppingCart.updateCartLineItemProductQuantity( productToUpdateId, productNewQuantity );

            out.write( jsonb.toJson( sessionShoppingCart.getTotalFormatted() ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            response.sendError( 400 );
        }

    }
}
