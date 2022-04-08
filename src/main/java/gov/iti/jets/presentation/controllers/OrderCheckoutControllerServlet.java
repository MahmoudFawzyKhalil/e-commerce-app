package gov.iti.jets.presentation.controllers;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.dtos.CardDto;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.PaymentGateway;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet( "/checkout" )
public class OrderCheckoutControllerServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        var session = request.getSession();
        var user = (User) session.getAttribute( "user" );
        var shoppingCart = (ShoppingCart) session.getAttribute( "shoppingCart" );

        if ( user == null ) {
            response.sendRedirect( "login" );
            return;
        }

        if ( shoppingCart == null || shoppingCart.isEmpty() ) {
            response.sendRedirect( "home" );
            return;
        }

        boolean shoppingCartOutdated = shoppingCart.refreshAndValidateData();

        if ( shoppingCartOutdated ) {
            request.setAttribute( "shoppingCartOutdated", true );
        }

        request.getRequestDispatcher( "/WEB-INF/views/checkout/checkout.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        try {
            var session = request.getSession();

            String ccNumber = request.getParameter( "ccNumber" );
            String cvc = request.getParameter( "cvc" );
            String expDate = request.getParameter( "expDate" );

            long expMonth = parseExpMonth( expDate );
            long expYear = parseExpYear( expDate );

            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute( "shoppingCart" );

            CardDto card = new CardDto( ccNumber, cvc, expMonth, expYear );

            DomainFacade.payForAndFulfilOrder( shoppingCart, card );

            // Reset shopping cart if successful purchase
            var newShoppingCart = new ShoppingCart();
            session.setAttribute( "shoppingCart", newShoppingCart );
            User user = (User) session.getAttribute( "user" );
            user.setShoppingCart( newShoppingCart );

            request.getRequestDispatcher( "/WEB-INF/views/success/success.jsp" ).forward( request, response );

        } catch ( Exception e ) {
            e.printStackTrace();
            request.getRequestDispatcher( "/WEB-INF/views/failure/failure.jsp" ).forward( request, response );

        }

    }

    private long parseExpMonth( String expDate ) {
        return Long.parseLong( expDate.split( "/" )[0] );
    }

    private long parseExpYear( String expDate ) {
        return Long.parseLong( "20" + expDate.split( "/" )[1] );
    }
}
