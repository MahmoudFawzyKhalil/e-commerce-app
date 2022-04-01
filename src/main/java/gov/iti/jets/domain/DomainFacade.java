package gov.iti.jets.domain;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.services.ProductService;
import gov.iti.jets.domain.services.UserLoginService;
import gov.iti.jets.domain.services.UserRegistrationService;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.services.ProductAddNewService;

import java.util.List;
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

    public static List<Product> getAPageOfProducts( int pageNumber ) {
        return ProductService.getAPageOfProducts( pageNumber );
    }

    public static List<Product> getProductsByNameAndCategory( String productNameQuery, Category productCategory ) {
        return ProductService.getProductsByNameAndCategory( productNameQuery, productCategory );
    }
}
