package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.Address;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

@WebServlet( "/profile" )
public class UserProfileControllerServlet extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        if ( Objects.isNull( request.getSession().getAttribute( "user" ) ) ) {
            response.sendRedirect( "home" );
            return;
        }
        request.getRequestDispatcher( "/WEB-INF/views/profile/profile.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            User user = (User) request.getSession().getAttribute( "user" );
            String phoneNumber = request.getParameter( "phoneNumber" );
            String job = request.getParameter( "job" );
            String creditLimitParam = request.getParameter( "creditLimit" );
            String street = request.getParameter( "streetAddress" );
            String city = request.getParameter( "city" );

            System.out.println();

            long creditLimit = Long.parseLong( creditLimitParam ) * 100;
            Address address = new Address( street, city );

            user.setPhoneNumber( phoneNumber );
            user.setJob( job );
            user.setCreditLimit( creditLimit );
            user.setAddress( address );

            DomainFacade.updateUser( user );

            response.sendRedirect( "home" );
        } catch ( Exception e ) {
            e.printStackTrace();
            response.sendRedirect( "home" );
        }
    }
}
