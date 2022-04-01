package gov.iti.jets.domain;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.services.*;

import gov.iti.jets.domain.models.Product;

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

    public static void persistShoppingCart( ShoppingCart shoppingCart ) {
        ShoppingCartService.persistShoppingCart( shoppingCart );
    }


    public static List<Product> getAPageOfProducts( int pageNumber ) {
        return ProductService.getAPageOfProducts( pageNumber );
    }

    public static List<Product> getProductsByNameAndCategory( String productNameQuery, Category productCategory ) {
        return ProductService.getProductsByNameAndCategory( productNameQuery, productCategory );
    }

    public static void updateUser( User user ) {
        UserUpdateProfileService.updateUser( user );
    }

    public static Optional<Product> findProductById( int productId ) {
        return ProductService.findProductById( productId );
    }
}
