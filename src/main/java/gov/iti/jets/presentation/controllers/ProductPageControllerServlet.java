package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet( "/product" )
public class ProductPageControllerServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String idParam = request.getParameter( "id" );

        try {
            int productId = Integer.parseInt( idParam );

            Optional<Product> optionalProduct = DomainFacade.findProductById( productId );

            optionalProduct.ifPresent( product -> request.setAttribute( "product", product ) );

            request.getRequestDispatcher( "/WEB-INF/views/productPreview/productPreview.jsp" ).forward( request, response );
        } catch ( Exception e ) {
            e.printStackTrace();

            response.sendRedirect( "home" );
        }
    }
}
