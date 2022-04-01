package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet( "/products/search" )
public class ProductSearchAjaxServlet extends HttpServlet {
    private final Jsonb jsonb = JsonbBuilder.create();

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        var out = response.getWriter();
        String query = request.getParameter( "query" );

        Category category = null;
        try {
            category = Category.valueOf( request.getParameter( "category" ).toUpperCase() );
        } catch ( IllegalArgumentException iae ) {
            iae.printStackTrace();
        }

        System.out.println( query );
        System.out.println( category );

        List<Product> products = DomainFacade.getProductsByNameAndCategory( query, category );

        String productsJson = jsonb.toJson( products );

        out.write( productsJson );
    }
}
