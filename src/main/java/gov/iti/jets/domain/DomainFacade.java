package gov.iti.jets.domain;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.services.GetAllCustomersService;
import gov.iti.jets.domain.services.UserRegistrationService;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.services.ProductAddNewService;

import java.util.List;

public class DomainFacade {

    public static void addProduct( Product product ) {
        ProductAddNewService.addProduct( product );
    }

    public static void registerNewUser( User user ) {
        UserRegistrationService.registerNewUser( user );
    }

    public static List<User> getAllUser(){ return GetAllCustomersService.getAllCustomersService();}
}
