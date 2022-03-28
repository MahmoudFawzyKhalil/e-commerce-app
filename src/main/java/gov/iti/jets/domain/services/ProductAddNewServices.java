package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductAddNewServices {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ecommerce" );
    private static final EntityManager entityManager = emf.createEntityManager();

    public static void addProduct(Product product){
        ProductRepository productRepository = new ProductRepository( entityManager );
        entityManager.getTransaction().begin();
        productRepository.create( product );
        entityManager.getTransaction().commit();
    }

}
