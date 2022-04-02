package gov.iti.jets.repository.util;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.*;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.ProductRepository;
import gov.iti.jets.repository.ShoppingCartRepository;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.Persistence;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulator {
    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static void main( String[] args ) {
        var emf = Persistence.createEntityManagerFactory( "ecommerce" );
        var em = emf.createEntityManager();


        // CREATE PRODUCTS ************************
        List<Product> products = new ArrayList<>();
        Product product1 = new Product( "Ferrero Rocher", "Fine Hazelnut Chocolates - 5.3oz/12ct", "Ferrero.jpg", 6 * 100, 50, Category.CHOCOLATE );
        products.add( product1 );

        Product product2 = new Product( "Hershey", "Miniature Chocolate Candy Variety Pack - 10.4oz", "Hershey.jpg", 5 * 100, 100, Category.CHOCOLATE );
        products.add( product2 );

        Product product3 = new Product( "Kinder Bueno", "Minis Share Pack - 5.7oz", "kinderBueno.jpg", 14 * 100, 100, Category.CHOCOLATE );
        products.add( product3 );

        Product product4 = new Product( "Reese's Peanut Butter Cups", "Thins Milk Chocolate Pouch - 7.37oz", "reesesPeanutButterCups.jpg", 12 * 100, 100, Category.CHOCOLATE );
        products.add( product4 );


        Product product5 = new Product( "Lindt Lindor", "Milk Chocolate Truffles - 6oz", "lindtLindor.jpg", 13 * 100, 100, Category.CHOCOLATE );
        products.add( product5 );

        Product product6 = new Product( "Cadbury Dairy Milk", "CADBURY DAIRY MILK Milk Chocolate Candy Bar 3.5oz", "cadburyDairyMilkChocolate.jpg", 12 * 100, 100, Category.CHOCOLATE );
        products.add( product6 );

        Product product7 = new Product( "M&Ms", "Classic Mix Sharing Sup - 8.3oz", "M&Ms.jpg", 7 * 100, 100, Category.CHOCOLATE );
        products.add( product7 );

        Product product8 = new Product( "Crunch Buncha", "Crunch Milk Chocolate Candy - 3.2oz", "crunchBuncha.jpg", 4 * 100, 100, Category.CHOCOLATE );
        products.add( product8 );

        Product product9 = new Product( "Dove Promises", "Variety Pack Chocolate Candies - 15.8oz", "dovePromises.jpg", 22 * 100, 100, Category.CHOCOLATE );
        products.add( product9 );

        Product product10 = new Product( "Brookside", "Acai with Blueberry Flavors Dark Chocolate - 7oz", "Brookside.jpg", 32 * 100, 100, Category.CHOCOLATE );
        products.add( product10 );


        // PERSIST PRODUCTS ************************
        ProductRepository pr = new ProductRepository( em );
        em.getTransaction().begin();
        products.forEach( pr::create );
        em.getTransaction().commit();

        // CREATE USERS ************************
        String hashedPassword = encoder.encode( "123456789" );

        List<User> users = new ArrayList<>();
        User user1 = new User( "John", "Doe", "john@gmail.com", hashedPassword, "01117950455", LocalDate.ofYearDay( 1996, 50 ), 6000, "salesman", Role.ADMIN, new Address( "abofarg", "Cairo" ) );
        users.add( user1 );

        User user2 = new User( "Marwa", "Youssef", "Marwa@gmail.com", hashedPassword, "01117950451", LocalDate.ofYearDay( 1997, 70 ), 10000, "Java Developer", Role.CUSTOMER, new Address( "elharm", "Giza" ) );
        users.add( user2 );

        User user3 = new User( "Abdelrahman", "Samy", "Semsem@gmail.com", hashedPassword, "01117950452", LocalDate.ofYearDay( 1997, 90 ), 20000, "Web Developer", Role.CUSTOMER, new Address( "iti", "Cairo" ) );
        users.add( user3 );

        User user4 = new User( "Mahmoud", "Fawzy", "fawzy@gmail.com", hashedPassword, "01117950453", LocalDate.ofYearDay( 1997, 14 ), 40000, "Java Developer", Role.CUSTOMER, new Address( "nozha", "Cairo" ) );
        users.add( user4 );

        User user5 = new User( "Mariam", "Mohammed", "Mariam@gmail.com", hashedPassword, "01117950454", LocalDate.ofYearDay( 1997, 80 ), 30000, "Web Developer", Role.CUSTOMER, new Address( "london street", "Cairo" ) );
        users.add( user5 );

        User user6 = new User( "Salma", "Fayez", "salma@gmail.com", hashedPassword, "01117950456", LocalDate.ofYearDay( 1997, 120 ), 4000, "Engineer", Role.CUSTOMER, new Address( "Iti", "Cairo" ) );
        users.add( user6 );

        User user7 = new User( "Ahmed", "Osama", "Osos@gmail.com", hashedPassword, "01117950457", LocalDate.ofYearDay( 1997, 88 ), 1000, "Java Developer", Role.CUSTOMER, new Address( "iti", "Giza" ) );
        users.add( user7 );

        User user8 = new User( "Ahmed", "Ashrf", "Ashrf@gmail.com", hashedPassword, "01117950458", LocalDate.ofYearDay( 1997, 90 ), 20000, "Web Developer", Role.CUSTOMER, new Address( "iti", "Cairo" ) );
        users.add( user8 );

        User user9 = new User( "Hend", "Mohamed", "hend@gmail.com", hashedPassword, "01117950459", LocalDate.ofYearDay( 1997, 14 ), 40000, "Java Developer", Role.CUSTOMER, new Address( "iti", "Cairo" ) );
        users.add( user9 );

        User user10 = new User( "Hafsa", "Mohammed", "hafsa@gmail.com", hashedPassword, "01117950450", LocalDate.ofYearDay( 1997, 80 ), 30000, "Web Developer", Role.CUSTOMER, new Address( "london street", "Cairo" ) );
        users.add( user10 );

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

        ShoppingCart shoppingCart2 = new ShoppingCart();
        user2.setShoppingCart( shoppingCart2 );
        shoppingCarts.add( shoppingCart2 );

        ShoppingCart shoppingCart3 = new ShoppingCart();
        user3.setShoppingCart( shoppingCart3 );
        shoppingCarts.add( shoppingCart3 );

        ShoppingCart shoppingCart4 = new ShoppingCart();
        user4.setShoppingCart( shoppingCart4 );
        shoppingCarts.add( shoppingCart4 );

        ShoppingCart shoppingCart5 = new ShoppingCart();
        user5.setShoppingCart( shoppingCart5 );
        shoppingCarts.add( shoppingCart5 );

        ShoppingCart shoppingCart6 = new ShoppingCart();
        user6.setShoppingCart( shoppingCart6 );
        shoppingCarts.add( shoppingCart6 );

        ShoppingCart shoppingCart7 = new ShoppingCart();
        user7.setShoppingCart( shoppingCart7 );
        shoppingCarts.add( shoppingCart7 );

        ShoppingCart shoppingCart8 = new ShoppingCart();
        user8.setShoppingCart( shoppingCart8 );
        shoppingCarts.add( shoppingCart8 );

        ShoppingCart shoppingCart9 = new ShoppingCart();
        user9.setShoppingCart( shoppingCart9 );
        shoppingCarts.add( shoppingCart9 );


        shoppingCart1.addCartLineItem( new CartLineItem( product1, 5 ) );
        shoppingCart1.addCartLineItem( new CartLineItem( product2, 3 ) );
        shoppingCart1.addCartLineItem( new CartLineItem( product8, 31 ) );

        shoppingCart2.addCartLineItem( new CartLineItem( product3, 10 ) );
        shoppingCart2.addCartLineItem( new CartLineItem( product4, 2 ) );
        shoppingCart2.addCartLineItem( new CartLineItem( product7, 20 ) );
        shoppingCart2.addCartLineItem( new CartLineItem( product10, 11 ) );

        shoppingCart3.addCartLineItem( new CartLineItem( product5, 15 ) );
        shoppingCart3.addCartLineItem( new CartLineItem( product6, 30 ) );
        shoppingCart3.addCartLineItem( new CartLineItem( product9, 25 ) );

        shoppingCart4.addCartLineItem( new CartLineItem( product3, 10 ) );
        shoppingCart4.addCartLineItem( new CartLineItem( product4, 2 ) );
        shoppingCart4.addCartLineItem( new CartLineItem( product7, 20 ) );
        shoppingCart4.addCartLineItem( new CartLineItem( product10, 11 ) );

        shoppingCart5.addCartLineItem( new CartLineItem( product5, 15 ) );
        shoppingCart5.addCartLineItem( new CartLineItem( product6, 30 ) );
        shoppingCart5.addCartLineItem( new CartLineItem( product9, 25 ) );

        shoppingCart6.addCartLineItem( new CartLineItem( product3, 10 ) );
        shoppingCart6.addCartLineItem( new CartLineItem( product4, 2 ) );
        shoppingCart6.addCartLineItem( new CartLineItem( product7, 20 ) );
        shoppingCart6.addCartLineItem( new CartLineItem( product10, 11 ) );

        shoppingCart7.addCartLineItem( new CartLineItem( product5, 15 ) );
        shoppingCart7.addCartLineItem( new CartLineItem( product6, 30 ) );
        shoppingCart7.addCartLineItem( new CartLineItem( product9, 25 ) );

        shoppingCart8.addCartLineItem( new CartLineItem( product3, 10 ) );
        shoppingCart8.addCartLineItem( new CartLineItem( product4, 2 ) );
        shoppingCart8.addCartLineItem( new CartLineItem( product7, 20 ) );
        shoppingCart8.addCartLineItem( new CartLineItem( product10, 11 ) );

        shoppingCart9.addCartLineItem( new CartLineItem( product5, 15 ) );
        shoppingCart9.addCartLineItem( new CartLineItem( product6, 30 ) );
        shoppingCart9.addCartLineItem( new CartLineItem( product9, 25 ) );


        // PERSIST SHOPPING CARTS ************************
        ShoppingCartRepository scr = new ShoppingCartRepository( em );
        em.getTransaction().begin();
        shoppingCarts.forEach( scr::create );
        em.getTransaction().commit();

        // CREATE ORDERS ************************
        List<Order> orders = new ArrayList<>();
        User user = new UserRepository( em ).findOne( 74 ).get();

        ShoppingCart shoppingCartt = new ShoppingCart();
        user.setShoppingCart( shoppingCartt );
        shoppingCarts.add( shoppingCartt );

        shoppingCartt.addCartLineItem( new CartLineItem( product3, 10 ) );
        shoppingCartt.addCartLineItem( new CartLineItem( product4, 2 ) );
        shoppingCartt.addCartLineItem( new CartLineItem( product7, 20 ) );
        shoppingCartt.addCartLineItem( new CartLineItem( product10, 11 ) );


        // PERSIST SHOPPING CARTS ************************
        ShoppingCartRepository scr = new ShoppingCartRepository( em );
        em.getTransaction().begin();
        shoppingCarts.forEach( scr::create );
        em.getTransaction().commit();


        Order order1 = new Order( user );

        Order order2 = new Order( user );

        Order order3 = new Order( user );

        Order order4 = new Order( user4 );

        Order order5 = new Order( user5 );

        Order order6 = new Order( user6 );

        Order order7 = new Order( user7 );

        Order order8 = new Order( user8 );

        Order order9 = new Order( user9 );

        orders.add( order1 );
        orders.add( order2 );
        orders.add( order3 );
        orders.add( order4 );
        orders.add( order5 );
        orders.add( order6 );
        orders.add( order7 );
        orders.add( order8 );
        orders.add( order9 );

//         PERSIST ORDERS ************************
        OrderRepository or = new OrderRepository( em );
        em.getTransaction().begin();
        orders.forEach( or::create );
        em.getTransaction().commit();

//        System.out.println( emf.createEntityManager().find( Address.class, 5 ) );
//        System.out.println( new UserRepository( em ).findOne( 4 ).get() );
    //    System.out.println( new OrderRepository( em ).findAll() );

    }
}
