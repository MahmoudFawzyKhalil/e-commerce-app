package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/admin/customers/customer/order" )
public class AdminCustomerOrderItemControllerServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher( "/WEB-INF/views/admin/customer/orderItems.jsp" );

        int orderId =Integer.parseInt( request.getParameter( "orderId" ) ) ;
        request.setAttribute( "itemList",DomainFacade.getItems( orderId ) );

        request.setAttribute( "order",DomainFacade.getOrderByID( orderId ).get());

        int userId =Integer.parseInt( request.getParameter( "userId" ) ) ;
        request.setAttribute( "user",DomainFacade.getCustomerByID( userId ).get() );

        requestDispatcher.forward( request, response );
    }

}
