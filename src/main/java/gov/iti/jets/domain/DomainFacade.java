package gov.iti.jets.domain;

import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.services.ShoppingCartService;
import gov.iti.jets.domain.services.UserLoginService;
import gov.iti.jets.domain.services.UserRegistrationService;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.services.ProductAddNewService;

import java.util.Optional;

public class DomainFacade {
    public static void addProduct( Product product ) {
        ProductAddNewService.addProduct( product );
    }

    public static void registerNewUser( User user ) {
        UserRegistrationService.registerNewUser( user );
    }

    public static Optional<User> loginUser( String email, String password ) {
        return UserLoginService.loginUser( email, password );
    }


    public static Optional<User> loginUserRememberMe( String email, String password ) {
        return UserLoginService.loginUserRememberMe( email, password );
    }

    public static void persistShoppingCart( ShoppingCart shoppingCart ) {
        ShoppingCartService.persistShoppingCart( shoppingCart );
    }

}
