package gov.iti.jets.repository;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;

public class ProductRepository extends AbstractRepository<Product> {

    public ProductRepository(EntityManager entityManager) {
        super(entityManager);
        this.setClazz(Product.class);
    }


}
