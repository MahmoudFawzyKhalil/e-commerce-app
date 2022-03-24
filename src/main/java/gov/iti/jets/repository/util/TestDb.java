package gov.iti.jets.repository.util;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.*;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class TestDb {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("ecommerce");
        var em = emf.createEntityManager();

        //some products to test
        Product chocolate1 = new Product();
        chocolate1.setName("Chocolate1");
        chocolate1.setCategory(Category.CHOCOLATE);
        chocolate1.setDescription("processed cocoa");
        chocolate1.setQuantity(10);
        chocolate1.setPrice(200);

        Product chocolate2 = new Product();
        chocolate2.setName("Chocolate2");
        chocolate2.setCategory(Category.CHOCOLATE);
        chocolate2.setDescription("processed cocoa");
        chocolate2.setQuantity(5);
        chocolate2.setPrice(500);

        //populate data base with products
        em.getTransaction().begin();
        em.persist(chocolate1);
        em.persist(chocolate2);
        em.getTransaction().commit();


        //user registers
        User user = new User();
        Address address = new Address("Bla street", "Cairo");
        user.assignAddress(address);
        user.setBirthday(LocalDate.ofYearDay(2020, 10));
        user.setFirstName("user1");
        user.setLastName("lastNme");
        user.setCreditLimit(5000);
        user.setEmail("user1@mail.com");
        user.setPassword("password");
        user.setJob("Betenganer");
        user.setRole(Role.CUSTOMER);


        //persist user
//        em.getTransaction().begin();
//        em.persist(user);
//        em.getTransaction().commit();

        UserRepository ecommerce = new UserRepository(em);
        em.getTransaction().begin();
        ecommerce.create(user);
        em.getTransaction().commit();

        //user owns a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.assignToAUser(user);

        em.getTransaction().begin();
        em.persist(shoppingCart);
        em.getTransaction().commit();


        //create a cart line item
        CartLineItem cartLineItem = new CartLineItem();
        cartLineItem.setProduct(chocolate1);
        cartLineItem.setQuantity(3);
        cartLineItem.setUnitCost(chocolate1.getPrice());

        //add the cart line item to shopping cart
        cartLineItem.assignToAShoppingCart(shoppingCart);

        //create order
        Order order = new Order();
        order.setOwner(user);
        shoppingCart.getCartLineItemsUnmodifiable().forEach(myCartLineItem -> {
            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setProduct(myCartLineItem.getProduct());
            orderLineItem.setQuantity(myCartLineItem.getQuantity());
            orderLineItem.setUnitCost(myCartLineItem.getUnitCost());
            orderLineItem.assignToAnOrder(order);
            order.addOrderLineItem(orderLineItem);
        });

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();

        System.out.println(emf.createEntityManager().find(Address.class, 4));

        System.out.println(new OrderRepository(em).findAll());
    }
}
