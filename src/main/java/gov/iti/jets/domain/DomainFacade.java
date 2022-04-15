package gov.iti.jets.domain;

import gov.iti.jets.domain.dtos.CardDto;
import gov.iti.jets.domain.models.*;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.services.*;

import gov.iti.jets.domain.services.ProductAddNewService;
import gov.iti.jets.domain.util.EmailGateway;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.domain.util.PaymentGateway;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.ProductRepository;
import org.apache.commons.mail.EmailException;

import java.util.List;
import java.util.Optional;

public class DomainFacade {
    public static void deleteProduct( int productId ) {
        ProductAdminService.deleteProduct( productId );
    }

    public static Product updateProduct( Product product ) {
        return ProductAdminService.updateProduct( product );
    }

    public static Optional<Product> getProductById( int id ) {
        return ProductAdminService.getProductById( id );
    }

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

    public static List<Product> getPageOfProduct( int pageNumber ) {
        return ProductAdminService.getPageOfProduct( pageNumber );
    }

    public static long getNumberOfPagesOfProduct() {
        return ProductAdminService.getNumberOfPagesOfProduct();
    }

    public static List<User> getPageOfCustomers( int pageNumber ) {
        return AdminListOfCustomersService.getPage( pageNumber );
    }

    public static long getPageNumberOfCustomers() {
        return AdminListOfCustomersService.getNumberOfPages();
    }

    public static List<Order> getAllOrdersForUser( int userId ) {
        return UserListOfOrdersService.getAllOrdersForUser( userId );
    }

    public static Optional<User> getCustomerByID( int id ) {
        return UserListOfOrdersService.getCustomerById( id );
    }

    public static List<OrderLineItem> getItemsByOrderId( int id ) {
        return OrderListOfItemsService.getItemsByOrderId( id );
    }

    public static Optional<Order> getOrderByID( int id ) {
        return OrderListOfItemsService.getOrderById( id );
    }

    public static void payForAndFulfilOrder( ShoppingCart shoppingCart, CardDto card ) throws Exception {
        OrderService.payForAndFulfilOrder( shoppingCart, card );
    }

    public static boolean confirmUserRegistration( String confirmationId ) {
        return UserRegistrationService.confirmUserRegistration( confirmationId );
    }

    public static boolean resendConfirmationEmail( String email ) {
        return UserRegistrationService.resendConfirmationEmail( email );
    }

    public static String sendResetPasswordEmail( String email ) throws Exception {
        return UserLoginService.sendResetPasswordEmail( email );
    }

    public static void resetPassword( String email, String newPassword ) {
        UserLoginService.resetPassword( email, newPassword );
    }

    public static void addFeedbackMessage( FeedbackMessage message) {
        UserFeedbackMessageService.addFeedbackMessage( message );
    }


}
