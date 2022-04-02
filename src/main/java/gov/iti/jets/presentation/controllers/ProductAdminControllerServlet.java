package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( "/admin/products" )
public class ProductAdminControllerServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher( "/WEB-INF/views/admin/product/listOfProduct.jsp" );
        request.setAttribute( "pageNumber", DomainFacade.getNumberOfPagesOfProduct() );
        requestDispatcher.forward( request, response );
    }
}
