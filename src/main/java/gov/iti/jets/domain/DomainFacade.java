package gov.iti.jets.domain;

import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.OrderLineItem;
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

    public static List<Product> getPageOfProduct( int pageNumber ) {
        return ProductAdminService.getProduct( pageNumber );
    }

    public static void setPageSizeOfProduct( int pageSize ) {
        ProductAdminService.setPageSize( pageSize );
    }

    public static long getPageNumberOfProduct() {
        return ProductAdminService.getPageNumber();
    }

    public static List<User> getPageOfCustomers( int pageNumber ) {
        return GetListOfCustomersService.getPage( pageNumber );
    }

    public static void setPageSizeOfCustomers( int pageSize ) {
        GetListOfCustomersService.setPage( pageSize );
    }

    public static long getPageNumberOfCustomers() {
        return GetListOfCustomersService.getPageNumber();
    }

    public static List<Order> getOrders( int id ) {
        return CustomerListOFOrdersService.getAllOrdersForUser( id );
    }

    public static Optional<User> getCustomerByID( int id ) {
        return CustomerListOFOrdersService.getCustomerbyId( id );
    }

    public static List<OrderLineItem> getItems( int id ) {
        return OrderListOfItemsService.getAllItemsForOrder( id );
    }

    public static Optional<Order> getOrderByID( int id ) {
        return OrderListOfItemsService.getOrderbyId( id );
    }

}
