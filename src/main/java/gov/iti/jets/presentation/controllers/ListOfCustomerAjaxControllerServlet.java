package gov.iti.jets.presentation.controllers;


import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.Address;
import gov.iti.jets.domain.models.User;
import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet( "/ListAjex" )
public class ListOfCustomerAjaxControllerServlet extends HttpServlet {

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int pageNumber = Integer.parseInt( request.getParameter( "pg" ) );

        List<User> userList = new ArrayList<>();
        userList = DomainFacade.getPage( pageNumber );
        System.out.println( "**********************after DomainFacade" );
        List<String> jsonList = new ArrayList<>();

        for ( User user : userList ) {
            jsonList.add( jsonMessage( user ) );
        }

        out.print( jsonList );
    }

    private String jsonMessage( User user ) {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add( "id",user.getId() )
                .add( "name", user.getFullName() )
                .add( "email" ,user.getEmail())
                .add( "phoneNumber", user.getPhoneNumber() )
                .add( "address", jsonAddress( user.getAddress() ) )
                .add( "birthday", user.getBirthday().toString())
                .add( "job",user.getJob() )
                .add( "creditLimit",user.getCreditLimit() );
        return jsonObjectBuilder.build().toString();
    }
    private String jsonAddress( Address address ) {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add( "city",address.getCity() )
                .add( "street", address.getStreet() );
        return jsonObjectBuilder.build().toString();
    }

}
