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

public class DatabasePopulator {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory( "ecommerce" );
        var em = emf.createEntityManager();


        // CREATE PRODUCTS ************************
        List<Product> products = new ArrayList<>();
        Product product1 = new Product( "Ferrero Rocher", "Fine Hazelnut Chocolates - 5.3oz/12ct", "Ferrero.jpg", 6*100, 50, Category.CHOCOLATE );
        products.add( product1 );

        Product product2 = new Product( "Hershey", "Miniature Chocolate Candy Variety Pack - 10.4oz", "Hershey.jpg", 5*100, 100, Category.CHOCOLATE );
        products.add( product2 );

        Product product3 = new Product( "Kinder Bueno", "Minis Share Pack - 5.7oz", "kinderBueno.jpg", 14*100, 100, Category.CHOCOLATE );
        products.add( product3 );

        Product product4 = new Product( "Reese's Peanut Butter Cups", "Thins Milk Chocolate Pouch - 7.37oz", "reesesPeanutButterCups.jpg", 12*100, 100, Category.CHOCOLATE );
        products.add( product4 );


        Product product5 = new Product( "Lindt Lindor", "Milk Chocolate Truffles - 6oz", "lindtLindor.jpg", 13*100, 100, Category.CHOCOLATE );
        products.add( product5 );

        Product product6 = new Product( "Cadbury Dairy Milk", "CADBURY DAIRY MILK Milk Chocolate Candy Bar 3.5oz", "cadburyDairyMilkChocolate.jpg", 12*100, 100, Category.CHOCOLATE );
        products.add( product6 );

        Product product7 = new Product( "M&Ms", "Classic Mix Sharing Sup - 8.3oz", "M&Ms.jpg", 7*100, 100, Category.CHOCOLATE );
        products.add( product7 );

        Product product8 = new Product( "Crunch Buncha", "Crunch Milk Chocolate Candy - 3.2oz", "crunchBuncha.jpg", 4*100, 100, Category.CHOCOLATE );
        products.add( product8 );

        Product product9 = new Product( "Dove Promises", "Variety Pack Chocolate Candies - 15.8oz", "dovePromises.jpg", 22*100, 100, Category.CHOCOLATE );
        products.add( product9 );

        Product product10 = new Product( "Brookside", "Acai with Blueberry Flavors Dark Chocolate - 7oz", "Brookside.jpg", 32*100, 100, Category.CHOCOLATE );
        products.add( product10 );


        // PERSIST PRODUCTS ************************
        ProductRepository pr = new ProductRepository( em );
        em.getTransaction().begin();
        products.forEach( pr::create );
        em.getTransaction().commit();

        // CREATE USERS ************************
        List<User> users = new ArrayList<>();
        User user1 = new User( "John", "Doe", "john@gmail.com", "123456789", "01117950455", LocalDate.ofYearDay( 1996, 50 ), 6000, "salesman", Role.CUSTOMER, new Address( "abofarg", "Cairo" ) );
        users.add( user1 );

        User user2 = new User( "Marwa", "Youssef", "Marwa@gmail.com", "123456789", "01117950451", LocalDate.ofYearDay( 1997, 70 ), 10000, "Java Developer", Role.CUSTOMER, new Address( "elharm", "Giza" ) );
        users.add( user2 );

        User user3 = new User( "Abdelrahman", "Samy", "Semsem@gmail.com", "123456789", "01117950452", LocalDate.ofYearDay( 1997, 90 ), 20000, "Web Developer", Role.CUSTOMER, new Address( "iti", "Cairo" ) );
        users.add( user3 );

        User user4 = new User( "Mahmoud", "Fawzy", "fawzy@gmail.com", "123456789", "01117950453", LocalDate.ofYearDay( 1997, 14 ), 40000, "Java Developer", Role.CUSTOMER, new Address( "nozha", "Cairo" ) );
        users.add( user4 );

        User user5 = new User( "Mariam", "Mohammed", "Mariam@gmail.com", "123456789", "01117950454", LocalDate.ofYearDay( 1997, 80 ), 30000, "Web Developer", Role.CUSTOMER, new Address( "london street", "Cairo" ) );
        users.add( user5 );

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


        // PERSIST SHOPPING CARTS ************************
        ShoppingCartRepository scr = new ShoppingCartRepository( em );
        em.getTransaction().begin();
        shoppingCarts.forEach( scr::create );
        em.getTransaction().commit();

        // CREATE ORDERS ************************
        List<Order> orders = new ArrayList<>();


        Order order1 = new Order( user1 );

        Order order2 = new Order( user2 );

        Order order3 = new Order( user3 );

        orders.add( order1 );
        orders.add( order2 );
        orders.add( order3 );

        // PERSIST ORDERS ************************
        OrderRepository or = new OrderRepository( em );
        em.getTransaction().begin();
        orders.forEach( or::create );
        em.getTransaction().commit();

//        System.out.println( emf.createEntityManager().find( Address.class, 5 ) );
//        System.out.println( new UserRepository( em ).findOne( 4 ).get() );
        System.out.println( new OrderRepository( em ).findAll() );

    }
}
