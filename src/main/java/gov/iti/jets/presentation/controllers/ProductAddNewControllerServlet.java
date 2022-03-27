package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.presentation.viewhelpers.ProductAddNewViewHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
        String description = req.getParameter( "description" );
        int quantity = Integer.parseInt( req.getParameter( "quantity" ) );
        int price = Integer.parseInt( req.getParameter( "price" ) );
        String category = req.getParameter( "Category" );

        Product product= new Product( name,description, "",quantity ,price ,Category.CHOCOLATE );
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
}
