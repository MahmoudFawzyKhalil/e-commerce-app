package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.User;
import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/productAjax")
public class ProductAdminAjaxServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        PrintWriter out = response.getWriter();
        int pageNumber = Integer.parseInt( request.getParameter( "pg" ) );
        List<Product> productList = DomainFacade.getPageOfProduct( pageNumber );
        List<String> productListJson = new ArrayList<>();
        for ( Product product : productList ) {
            productListJson.add( productToJson( product ) );
        }
        out.print( productListJson );
    }

    private String productToJson( Product product ) {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add( "id",product.getId() )
                .add( "name", product.getName() )
                .add( "description" ,product.getDescription())
                .add( "quantity", product.getQuantity() )
                .add( "price", product.getPrice())
                .add( "priceFormatting", product.getPriceFormatting())
                .add( "category",product.getCategory().name() );
        return jsonObjectBuilder.build().toString();
    }
}
