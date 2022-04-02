package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/admin/products/delete" )
public class ProductDeleteControllerServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        try {

            String productId = request.getParameter( "productId" );

            DomainFacade.deleteProduct( Integer.parseInt( productId ) );

            response.sendRedirect( request.getContextPath() + "/admin/products" );
        } catch ( Exception e ) {
            e.printStackTrace();
            response.sendRedirect( request.getContextPath() + "/admin" );
        }
    }
}
