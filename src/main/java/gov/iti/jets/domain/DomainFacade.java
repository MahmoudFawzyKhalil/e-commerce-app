package gov.iti.jets.domain;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.services.UserRegistrationService;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.services.ProductAddNewService;

public class DomainFacade {

    public static void addProduct( Product product ) {
        ProductAddNewService.addProduct( product );
    }

    public static void registerNewUser( User user ) {
        UserRegistrationService.registerNewUser( user );
    }
}
