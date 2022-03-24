package gov.iti.jets.repository;

import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;

public class ShoppingCartRepository extends AbstractRepository<ShoppingCart> {

    public ShoppingCartRepository(EntityManager entityManager) {
        super(entityManager);
        this.setClazz(ShoppingCart.class);
    }

}
