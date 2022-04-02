package gov.iti.jets.presentation.controllers;


import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.Address;
import gov.iti.jets.domain.models.User;

import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet( "/ListAjax" )
public class ListOfCustomerAjaxControllerServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        PrintWriter out = response.getWriter();
        int pageNumber = Integer.parseInt( request.getParameter( "pg" ) );

        List<User> userList= DomainFacade.getPageOfCustomers( pageNumber );
        List<String> jsonList = new ArrayList<>();

        for ( User user : userList ) {
            jsonList.add( userToJson( user ) );
        }
        out.print( jsonList );
    }

    private String userToJson( User user ) {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add( "id", user.getId() )
                .add( "name", user.getFullName() )
                .add( "email", user.getEmail() )
                .add( "phoneNumber", user.getPhoneNumber() )
                .add( "address", addressToJson( user.getAddress() ) )
                .add( "birthday", user.getBirthday().toString() )
                .add( "job", user.getJob() )
                .add( "creditLimit", user.getCreditLimit() )
                .add( "creditLimitFormatting", user.getCreditLimitFormatted() )
        ;
        return jsonObjectBuilder.build().toString();
    }

    private String addressToJson( Address address ) {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add( "city", address.getCity() )
                .add( "street", address.getStreet() );
        return jsonObjectBuilder.build().toString();
    }

}
