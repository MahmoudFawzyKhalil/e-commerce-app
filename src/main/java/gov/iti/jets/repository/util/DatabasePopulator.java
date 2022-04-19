package gov.iti.jets.repository.util;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.*;
import gov.iti.jets.domain.util.AppConfig;
import gov.iti.jets.domain.util.Image;
import gov.iti.jets.domain.util.JpaUtil;
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
        AppConfig.load();
        var em = JpaUtil.createEntityManager();

        // CREATE PRODUCTS ************************
        List<Product> products = new ArrayList<>();
        Product product1 = new Product( "Ferrero Rocher", "Fine Hazelnut Chocolates - 5.3oz/12ct", Image.getImageUrl( "Ferrero.jpg" ), 6 * 100, 50, Category.CHOCOLATE );
        products.add( product1 );

        Product product2 = new Product( "Hershey", "Miniature Chocolate Candy Variety Pack - 10.4oz", Image.getImageUrl( "Hershey.jpg" ), 5 * 100, 100, Category.CHOCOLATE );
        products.add( product2 );

        Product product3 = new Product( "Kinder Bueno", "Minis Share Pack - 5.7oz", Image.getImageUrl( "kinderBueno.jpg" ), 14 * 100, 100, Category.CHOCOLATE );
        products.add( product3 );

        Product product4 = new Product( "Reese's Peanut Butter Cups", "Thins Milk Chocolate Pouch - 7.37oz",Image.getImageUrl("reesesPeanutButterCups.jpg" ) , 12 * 100, 100, Category.CHOCOLATE );
        products.add( product4 );


        Product product5 = new Product( "Lindt Lindor", "Milk Chocolate Truffles - 6oz",Image.getImageUrl( "lindtLindor.jpg" ) , 13 * 100, 100, Category.CHOCOLATE );
        products.add( product5 );

        Product product6 = new Product( "Cadbury Dairy Milk", "CADBURY DAIRY MILK Milk Chocolate Candy Bar 3.5oz",Image.getImageUrl( "cadburyDairyMilkChocolate.jpg" ) , 12 * 100, 100, Category.CHOCOLATE );
        products.add( product6 );

        Product product7 = new Product( "M&Ms", "Classic Mix Sharing Sup - 8.3oz", Image.getImageUrl(  "M&Ms.jpg"), 7 * 100, 100, Category.CHOCOLATE );
        products.add( product7 );

        Product product8 = new Product( "Crunch Buncha", "Crunch Milk Chocolate Candy - 3.2oz",Image.getImageUrl( "crunchBuncha.jpg" ) , 4 * 100, 100, Category.CHOCOLATE );
        products.add( product8 );

        Product product9 = new Product( "Dove Promises", "Variety Pack Chocolate Candies - 15.8oz", Image.getImageUrl( "dovePromises.jpg" ), 22 * 100, 100, Category.CHOCOLATE );
        products.add( product9 );

        Product product10 = new Product( "Brookside", "Acai with Blueberry Flavors Dark Chocolate - 7oz", Image.getImageUrl( "Brookside.jpg" ), 32 * 100, 100, Category.CHOCOLATE );
        products.add( product10 );


        Product product11 = new Product( "KitKat", "Nestle’s renowned chocolate-covered wafer bar", Image.getImageUrl( "kitkat.jpg" ), 7 * 100, 150, Category.CHOCOLATE );
        products.add( product11 );

        Product product12 = new Product( "Mars", "Commonly called the Mars bar, from the world’s largest confectioner, Mars", Image.getImageUrl( "mars.jpg" ), 10 * 100, 110, Category.CHOCOLATE );
        products.add( product12 );

        Product product13 = new Product( "Milky", "Inspired by the chocolate bar from Mars confectioners", Image.getImageUrl( "milky.jpg" ), 12 * 100, 100, Category.CHOCOLATE );
        products.add( product13 );

        Product product14 = new Product( "Patchi", "A Swiss and Belgian combination chocolate bar",Image.getImageUrl("patchi.jpg" ) , 12 * 100, 105, Category.CHOCOLATE );
        products.add( product14 );


        Product product15 = new Product( "Snickers", "One of the most beloved chocolate bars, this snack was initially called Marathon",Image.getImageUrl( "snickers.jpg" ) , 14 * 100, 160, Category.CHOCOLATE );
        products.add( product15 );

        Product product16 = new Product( "Sprungli", "One of the largest chocolate manufacturers in the world",Image.getImageUrl( "sprungli.jpg" ) , 20 * 100, 30, Category.CHOCOLATE );
        products.add( product16 );

        Product product17 = new Product( "Toblerone", "The popular triangular almond nougat and honey-covered Swiss chocolate", Image.getImageUrl(  "toblerone.jpg"), 15 * 100, 90, Category.CHOCOLATE );
        products.add( product17 );

        Product product18 = new Product( "Twix", "The biscuit-based bar from Mars confectioneries",Image.getImageUrl( "twix.jpg" ) , 4 * 100, 200, Category.CHOCOLATE );
        products.add( product18 );

        Product product19 = new Product( "Clark", "A well-known chocolate-coated honey and peanut butter bar in the US", Image.getImageUrl( "clark.jpg" ), 25 * 100, 132, Category.CHOCOLATE );
        products.add( product19 );

        Product product20 = new Product( "Duncan", "A popular chocolate brand in the UK and Ireland", Image.getImageUrl( "duncan.jpg" ), 40 * 100, 50, Category.CHOCOLATE );
        products.add( product20 );

        //DRINKS
        Product product21 = new Product( "Coca-Cola", "It is a carbonated soft drink manufactured by the Coca-Cola Company", Image.getImageUrl( "cocacola.jpg" ), 5 * 100, 500, Category.DRINKS  );
        products.add( product21 );

        Product product22 = new Product( "Pepsi", "Pepsi is a carbonated soft drink manufactured by PepsiCo. Originally created and developed in 1893 by Caleb Bradham and introduced as Brad's Drink", Image.getImageUrl( "pepsi.jpg" ), 6 * 100, 600, Category.DRINKS );
        products.add( product22 );

        Product product23 = new Product( "Diet Coke", "Diet Pepsi is a sugar-free and no-calorie soft drink produced and distributed by the Coca-Cola Company", Image.getImageUrl( "dietcoka.jpg" ), 10 * 100, 450, Category.DRINKS );
        products.add( product23 );

        Product product24 = new Product( "Dr Pepper", "Dr Pepper is a carbonated soft drink. It was created in the 1880s by pharmacist Charles Alderton in Waco, Texas",Image.getImageUrl("drpapper.jpg" ) , 20 * 100, 500, Category.DRINKS );
        products.add( product24 );


        Product product25 = new Product( "Mountain Dew", "Mountain Dew, stylized as Mtn Dew, is a carbonated soft drink brand produced and owned by PepsiCo.",Image.getImageUrl( "mountaindew.png" ) , 15 * 100, 460, Category.DRINKS );
        products.add( product25 );

        Product product26 = new Product( "Sprite", "Sprite is a colorless, lemon and lime-flavored soft drink created by The Coca-Cola Company", Image.getImageUrl( "sprite.jpg" ), 7 * 100, 800, Category.DRINKS );
        products.add( product26 );

        Product product27 = new Product( "Diet Pepsi", "Diet Pepsi is a no-calorie carbonated cola soft drink produced by PepsiCo", Image.getImageUrl( "dietcoka.jpg" ), 18 * 100, 300, Category.DRINKS );
        products.add( product27 );

        Product product28 = new Product( "Coke Zero", "Coca-Cola Zero Sugar (Coke Zero) uses several common artificial sweeteners, including aspartame and acesulfame potassium (Ace-K)", Image.getImageUrl( "zerocoke.jpg" ), 15 * 100, 400, Category.DRINKS );
        products.add( product28 );

        Product product29 = new Product( "Fanta", "Bright, bubbly and popular, Fanta is the soft drink that intensifies fun",Image.getImageUrl("fanta.jpg" ) , 8 * 100, 700, Category.DRINKS );
        products.add( product29 );


        Product product30 = new Product( "Diet Mountain Dew", "Diet Mountain Dew is a modified version of the original formula, containing low sugar count but retaining the same citrus taste and yellow-green color as the original Mountain Dew drink",Image.getImageUrl( "dietmountaindew.jpg" ) , 24 * 100, 300 , Category.DRINKS );
        products.add( product30 );


        // PERSIST PRODUCTS ************************
        ProductRepository pr = new ProductRepository( em );
        em.getTransaction().begin();
        products.forEach( pr::create );
        em.getTransaction().commit();

        // CREATE USERS ************************
        String hashedPassword = encoder.encode( "123456789" );

        List<User> users = new ArrayList<>();

        User user1 = new User( "John", "Doe", "john@gmail.com", hashedPassword, "01117950455", LocalDate.ofYearDay( 1996, 50 ), 6000, "salesman", Role.ADMIN, new Address( "abofarg", "Cairo" ) , true );
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

        User user11 = new User( "Hesham", "Mohammed", "Hesham@gmail.com", hashedPassword, "01127950450", LocalDate.ofYearDay( 1997, 80 ), 30000, "Web Developer", Role.CUSTOMER, new Address( "london street", "Cairo" ) );
        users.add( user11 );

        User user12 = new User( "Hasham", "Mohammed", "Hasham@gmail.com", hashedPassword, "01121950450", LocalDate.ofYearDay( 1997, 80 ), 30000, "Web Developer", Role.CUSTOMER, new Address( "london street", "Cairo" ) );
        users.add( user12 );

        User user13 = new User( "Abdelaziz", "Mohammed", "Abdelaziz@gmail.com", hashedPassword, "01122950450", LocalDate.ofYearDay( 1997, 80 ), 30000, "Web Developer", Role.CUSTOMER, new Address( "london street", "Cairo" ) );
        users.add( user13 );

        User user14 = new User( "Amira", "Mohammed", "Amira@gmail.com", hashedPassword, "01123950450", LocalDate.ofYearDay( 1997, 80 ), 30000, "Web Developer", Role.CUSTOMER, new Address( "london street", "Cairo" ) );
        users.add( user14 );

        User user15 = new User( "Mina", "Mohammed", "Mina@gmail.com", hashedPassword, "01124950450", LocalDate.ofYearDay( 1997, 80 ), 30000, "Web Developer", Role.CUSTOMER, new Address( "london street", "Cairo" ) );
        users.add( user15 );

        User user16 = new User( "Hossam", "Mohammed", "Hossam@gmail.com", hashedPassword, "01125950450", LocalDate.ofYearDay( 1997, 80 ), 30000, "Web Developer", Role.CUSTOMER, new Address( "london street", "Cairo" ) );
        users.add( user16 );

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
        Order order1 = new Order( user2 );

        Order order2 = new Order( user2 );

        Order order3 = new Order( user3 );

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

        // PERSIST ORDERS ************************
        OrderRepository or = new OrderRepository( em );
        em.getTransaction().begin();
        orders.forEach( or::create );
        em.getTransaction().commit();

    }
}
