package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.util.AppConfig;
import gov.iti.jets.presentation.viewhelpers.ProductEditViewHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@MultipartConfig( maxFileSize = 1024 * 1024 * 2 )
@WebServlet( "/admin/products/edit" )
public class ProductEditControllerServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        ProductEditViewHelper productEditViewHelper = new ProductEditViewHelper();
        productEditViewHelper.setFailedToEditProduct( false );

        int id = 0;
        try {
            if ( request.getParameter( "productId" ) == null ) {
                id = (int) request.getAttribute( "id" );
                productEditViewHelper.setFailedToEditProduct( true );
            } else {
                id = Integer.parseInt( request.getParameter( "productId" ) );
            }

            if ( id != 0 ) {
                Optional<Product> optionalProduct = DomainFacade.getProductById( id );
                Product product = optionalProduct.get();
                product.setPrice( (int) ( product.getPrice() / 100 ) );
                productEditViewHelper.setProduct( product );
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher( "/WEB-INF/views/admin/product/editProduct.jsp" );
            request.setAttribute( "productHelper", productEditViewHelper );

            requestDispatcher.forward( request, response );

        } catch ( Exception e ) {
            response.sendRedirect( request.getContextPath() + "/admin" );
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Product product;
        int id = 0;
        try {
            ProductEditViewHelper productEditViewHelper = new ProductEditViewHelper();
            String name = request.getParameter( "nameEdit" );
            String description = request.getParameter( "descriptionEdit" );
            int quantity = Integer.parseInt( request.getParameter( "quantityEdit" ) );
            long price = Long.parseLong( request.getParameter( "priceEdit" ) ) * 100;
            Category category = Category.valueOf( request.getParameter( "categoryEdit" ) );
            Part photo = null;

            if ( !request.getParameter( "idEdit" ).isEmpty() ) {
                id = Integer.parseInt( request.getParameter( "idEdit" ) );
            }

            Optional<Product> optionalProductFromDatabase = DomainFacade.getProductById( id );
            Product productFromDatabase = optionalProductFromDatabase.get();

            productEditViewHelper.setFailedToEditProduct( false );
            request.setAttribute( "productHelper", productEditViewHelper );

            try {
                photo = request.getPart( "productPhotoEdit" );
            } catch ( IllegalStateException ex ) {
                ex.printStackTrace();
            }


            String photoName = getFileName( photo );

            if ( photoName != null && !photoName.isEmpty() ) {
                String[] split = photoName.split( "\\." );
                photoName = UUID.randomUUID().toString().replace( "-", "" ) + "." + split[1];
                product = new Product( id, name, description, photoName, price, quantity, category );

            } else {
                product = new Product( id, name, description, productFromDatabase.getImageName(), price, quantity, category );

            }

            try {
                DomainFacade.updateProduct( product );
                if ( photoName != null && !photoName.isEmpty() ) {
                    photo.write( AppConfig.IMG_PATH + photoName );
                }
                response.sendRedirect( request.getContextPath() + "/admin/products" );
            } catch ( RuntimeException e ) {
                productEditViewHelper.setFailedToEditProduct( true );
                request.setAttribute( "id", id );
                doGet( request, response );
            }

        } catch ( Exception e ) {
            response.sendRedirect( request.getContextPath() + "/admin" );
        }

    }

    public String getFileName( Part photo ) {
        if ( photo == null ) {
            return null;
        }

        for ( String content : photo.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) ) {
                return content.substring( content.indexOf( "=" ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }
}
