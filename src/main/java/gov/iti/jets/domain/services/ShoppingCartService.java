package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.ShoppingCartRepository;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ShoppingCartService {

    public static void persistShoppingCart( ShoppingCart shoppingCart ) {
        var em = JpaUtil.createEntityManager();
        var tx = em.getTransaction();

        ShoppingCartRepository scr = new ShoppingCartRepository( em );
//        UserRepository ur = new UserRepository( em );
        tx.begin();
        scr.update( shoppingCart );
//        ur.update( shoppingCart.getOwner() );
        tx.commit();

    }

}
