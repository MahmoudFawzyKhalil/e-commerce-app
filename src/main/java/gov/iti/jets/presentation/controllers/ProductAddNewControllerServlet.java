package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.presentation.viewhelpers.ProductAddNewViewHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.UUID;

@MultipartConfig
@WebServlet( "/admin/products/add" )
public class ProductAddNewControllerServlet extends HttpServlet {
ProductAddNewViewHelper productAddNewViewHelper=new ProductAddNewViewHelper();

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher( "/WEB-INF/views/admin/product/addProduct.jsp" );
        request.setAttribute( "success",productAddNewViewHelper.isSuccessfullyAddedProduct() );
        request.setAttribute( "failure",productAddNewViewHelper.isFailedToAddProduct() );

        System.out.println("doGet success ="+productAddNewViewHelper.isSuccessfullyAddedProduct() +"fail = "+productAddNewViewHelper.isFailedToAddProduct());
        requestDispatcher.forward( request, response );
    }



    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher( "/WEB-INF/views/admin/product/addProduct.jsp" );
        String name= req.getParameter("name");
        System.out.println(name);

        String description = req.getParameter( "description" );
        System.out.println(description);

        int quantity = Integer.parseInt( req.getParameter( "quantity" ) );
        System.out.println(quantity);

        long price = Integer.parseInt( req.getParameter( "price" ) );
        System.out.println(price);

        String category = req.getParameter( "Category" );
        System.out.println(category);

        Part photo = req.getPart("productPhoto");
        String photoName = getFileName(photo);
        System.out.println(photoName);
        if (photoName != null && !photoName.isEmpty()) {
            String[] split = photoName.split( "\\." );
            for ( String spl: split) {
                System.out.println(spl);
            }
            photoName =  UUID.randomUUID().toString().replace( "-", "" )+"."+split[1];
            photo.write("C:/ecommerce/"+ photoName);
        }
        Product product= new Product( name,description, photoName,price,quantity ,Category.CHOCOLATE );
        try{
            DomainFacade.addProduct( product);
            productAddNewViewHelper.setSuccessfullyAddedProduct( true );
            req.setAttribute( "success",productAddNewViewHelper.isSuccessfullyAddedProduct() );

        }catch(Exception e){
            productAddNewViewHelper.setFailedToAddProduct( true );
            req.setAttribute( "failure",productAddNewViewHelper.isFailedToAddProduct() );
        }finally {
            System.out.println("doPost success ="+productAddNewViewHelper.isSuccessfullyAddedProduct() +"fail = "+productAddNewViewHelper.isFailedToAddProduct());
            requestDispatcher.forward( req, resp );
        }

    }
    public String getFileName(Part filePart) {
        for (String content : filePart.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");

            }
        }
        return null;
    }
}
