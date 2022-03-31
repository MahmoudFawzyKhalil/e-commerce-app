package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( "/admin/customers" )
public class AdminListOfCustomerControllerServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher( "/WEB-INF/views/admin/customer/listOfCustomer.jsp" );
        int pageNumber =Integer.parseInt( request.getParameter( "pg" ) ) ;

        DomainFacade.setPage( 2 );
        System.out.println("servlet "+pageNumber);
        List<User> userList= new ArrayList<>();
        userList= DomainFacade.getPage(pageNumber);

        request.setAttribute( "userList", userList );
        request.setAttribute( "pageNumber",DomainFacade.getPageNumber() );
        request.setAttribute( "currentPageNumber",pageNumber );
        System.out.println("before forward");

        requestDispatcher.forward( request, response );

      //  response.sendRedirect( "listOfCustomer.jsp" );
    }

}
