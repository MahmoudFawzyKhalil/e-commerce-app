package gov.iti.jets.presentation.controllers;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.Address;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet( "/register" )
public class UserRegistrationControllerServlet extends HttpServlet {
    DomainFacade domainFacade = DomainFacade.getInstance();

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher( "/WEB-INF/views/register/register.jsp" ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String firstName = request.getParameter( "firstName" );
        String lastName = request.getParameter( "lastName" );
        String email = request.getParameter( "email" );
        String phoneNumber = request.getParameter( "phoneNumber" );
        String password = request.getParameter( "password" );
        String birthdayParam = request.getParameter( "birthdate" );
        String job = request.getParameter( "job" );
        String creditLimitParam = request.getParameter( "creditLimit" );
        String street = request.getParameter( "streetAddress" );
        String city = request.getParameter( "city" );

        try {
            LocalDate birthday = LocalDate.parse( birthdayParam );
            long creditLimit = Long.parseLong( creditLimitParam );
            Address address = new Address( street, city );
            User user = new User( firstName, lastName, email, password,
                    phoneNumber, birthday, creditLimit, job, Role.CUSTOMER, address );

            domainFacade.registerNewUser( user );

            response.sendRedirect( "login" );

        } catch ( Exception e ) {
            e.printStackTrace();
            response.sendRedirect( "register" );
        }
    }
}
