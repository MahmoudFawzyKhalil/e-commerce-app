package gov.iti.jets.repository.util;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.*;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.ProductRepository;
import gov.iti.jets.repository.ShoppingCartRepository;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDb {
    public static void main( String[] args ) {
        var emf = Persistence.createEntityManagerFactory( "ecommerce" );
        var em = emf.createEntityManager();


        // CREATE PRODUCTS ************************
        List<Product> products = new ArrayList<>();
        Product product1 = new Product( "product1", "first product", "", 200, 50, Category.CHOCOLATE );
        products.add( product1 );

        Product product2 = new Product( "product2", "second product", "", 5000, 10, Category.CHOCOLATE );
        products.add( product2 );

        Product product3 = new Product( "product3", "third product", "", 3000, 100, Category.CHOCOLATE );
        products.add( product3 );


        // PERSIST PRODUCTS ************************
        ProductRepository pr = new ProductRepository( em );
        em.getTransaction().begin();
        products.forEach( pr::create );
        em.getTransaction().commit();

        // CREATE USERS ************************
        List<User> users = new ArrayList<>();
        User user1 = new User( "John", "Doe", "john@mail.com", "password", "01117950455", LocalDate.ofYearDay( 2020, 50 ), 6000, "salesman", Role.CUSTOMER, new Address( "iti", "Cairo" ) );
        users.add( user1 );

        // PERSIST USERS ************************
        UserRepository ur = new UserRepository( em );
        em.getTransaction().begin();
        users.forEach( ur::create );
        em.getTransaction().commit();

        // CREATE SHOPPING CARTS ************************
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        ShoppingCart shoppingCart1 = new ShoppingCart();
        user1.setShoppingCart( shoppingCart1 );

        shoppingCarts.add( shoppingCart1 );

        shoppingCart1.addCartLineItem( new CartLineItem( product1, 5 ) );
        shoppingCart1.addCartLineItem( new CartLineItem( product2, 3 ) );

        // TEST UPDATE QUANTITY ************************
        shoppingCart1.updateCartLineItemProductQuantity( product1.getId(), 100 );

        // PERSIST SHOPPING CARTS ************************
        ShoppingCartRepository scr = new ShoppingCartRepository( em );
        em.getTransaction().begin();
        shoppingCarts.forEach( scr::create );
        em.getTransaction().commit();

        // CREATE ORDERS ************************
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order( user1 );
//        order1.populateLineItemsFromCart( shoppingCart1 );
        orders.add( order1 );

        // PERSIST ORDERS ************************
        OrderRepository or = new OrderRepository( em );
        em.getTransaction().begin();
        orders.forEach( or::create );
        em.getTransaction().commit();

        System.out.println( emf.createEntityManager().find( Address.class, 5 ) );
        System.out.println( new UserRepository( em ).findOne( 4 ).get() );
        System.out.println( new OrderRepository( em ).findAll() );
    }
}
