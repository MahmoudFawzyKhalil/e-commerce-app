package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/admin/products/delete")
public class ProductDeleteControllerServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String productId = request.getParameter( "productId" );
        System.out.println("***********"+productId);
        DomainFacade.deleteProduct( Integer.parseInt( productId ) );
    }
}
