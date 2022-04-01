package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.Product;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet( "/products" )
public class ProductHomeAjaxServlet extends HttpServlet {
    private final Jsonb jsonb = JsonbBuilder.create();

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        var out = response.getWriter();
        int pageNumber = Integer.parseInt( request.getParameter( "page" ) );

        List<Product> productPage = DomainFacade.getAPageOfProducts( pageNumber );

        String productPageJson = jsonb.toJson( productPage );

        out.write( productPageJson );
    }
}
