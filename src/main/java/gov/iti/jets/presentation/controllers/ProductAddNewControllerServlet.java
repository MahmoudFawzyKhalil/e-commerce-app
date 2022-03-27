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
        request.setAttribute( "helper",productAddNewViewHelper );
        requestDispatcher.forward( request, response );
    }



    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher( "/WEB-INF/views/admin/product/addProduct.jsp" );
        req.setAttribute( "helper",productAddNewViewHelper );

        String name= req.getParameter("name");
        String description = req.getParameter( "description" );
        int quantity = Integer.parseInt( req.getParameter( "quantity" ) );
        int price = Integer.parseInt( req.getParameter( "price" ) )*100 ;

        String cat =  req.getParameter( "category" );
        Category category;
        if(cat.equals( "CHOCOLATE" )) category = Category.CHOCOLATE;
        else category = Category.DRINKS;

        if(name != null && description != null && quantity != 0 && price != 0 && !cat.equals( "category" )){
            Product product= new Product( name,description, "",quantity ,price ,category );
            try{
                DomainFacade.addProduct(product);
                productAddNewViewHelper.setSuccessfullyAddedProduct( true );
            }catch(Exception e){
                productAddNewViewHelper.setFailedToAddProduct( true );
            }finally {
                 requestDispatcher.forward( req, resp );
            }
        }

    }
}
