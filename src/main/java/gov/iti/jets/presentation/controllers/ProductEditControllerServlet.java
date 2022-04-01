package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.presentation.viewhelpers.ProductAddNewViewHelper;
import gov.iti.jets.presentation.viewhelpers.ProductAdminViewHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.UUID;

@MultipartConfig( maxFileSize = 1024 * 1024 * 2 )
@WebServlet( "/admin/products/edit" )
public class ProductEditControllerServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        ProductAdminViewHelper productAdminViewHelper = new ProductAdminViewHelper();
        productAdminViewHelper.setFailedToAddProduct( false );
        productAdminViewHelper.setSuccessfullyAddedProduct( false );
        String productId = request.getParameter( "productId" );
        int id = 0;
        if (  request.getAttribute( "id" ) != null){
            id = (int) request.getAttribute( "id" );
        }
        if ( productId != null ) {
            Product product = DomainFacade.getProductById( Integer.parseInt( productId ) );
            System.out.println("******************"+product);
            product.setPrice( (int)(product.getPrice()/100) );
            productAdminViewHelper.setProduct( product );
            request.setAttribute( "id", productId );
        }
        if ( id != 0 ) {
            Product product = DomainFacade.getProductById(  id );
            productAdminViewHelper.setFailedToAddProduct( true );
            product.setPrice( (int)(product.getPrice()/100) );
            productAdminViewHelper.setProduct( product );
            request.setAttribute( "id", id );
        }

        var requestDispatcher = request.getRequestDispatcher( "/WEB-INF/views/admin/product/editProduct.jsp" );
        request.setAttribute( "productHelper", productAdminViewHelper );


        requestDispatcher.forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        ProductAdminViewHelper productAdminViewHelper = new ProductAdminViewHelper();
        productAdminViewHelper.setFailedToAddProduct( false );
        productAdminViewHelper.setSuccessfullyAddedProduct( false );

        request.setAttribute( "productHelper", productAdminViewHelper );
        Part photo = null;
        try {
            photo = request.getPart( "productPhotoEdit" );
        } catch ( IllegalStateException ex ) {
//             Thrown when file size is too large
            ex.printStackTrace();
        }
        int id = 0;
        if(!request.getParameter( "idEdit" ).isEmpty()){
            id = Integer.parseInt( request.getParameter( "idEdit" ) );
        }
        String name = request.getParameter( "nameEdit" );
        String description = request.getParameter( "descriptionEdit" );
        int quantity = Integer.parseInt( request.getParameter( "quantityEdit" ) );
        long price = Long.parseLong( request.getParameter( "priceEdit" ) ) * 100;
        Category category = Category.valueOf( request.getParameter( "categoryEdit" ) );
        Product productGetDatebase = DomainFacade.getProductById( id );
        Product product;
        String photoName = getFileName( photo );
        if ( photoName != null && !photoName.isEmpty() ) {
            String[] split = photoName.split( "\\." );
            photoName = UUID.randomUUID().toString().replace( "-", "" ) + "." + split[1];
            product = new Product(id  , name, description, photoName, price, quantity, category );
        }
        else {
            product = new Product(id  , name, description, productGetDatebase.getImageName(), price, quantity, category );
        }

        try {
            DomainFacade.updateProduct( product );
            if ( photoName != null && !photoName.isEmpty() ) {
                photo.write( "C:/ecommerce/" + photoName );
            }
            productAdminViewHelper.setSuccessfullyAddedProduct( true );
            response.sendRedirect( "/app/admin/products" );
        } catch ( RuntimeException e ) {
            System.out.println("eh");
            System.out.println(id);
            productAdminViewHelper.setFailedToAddProduct( true );
            request.setAttribute( "id", id );
            doGet( request,response );
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
