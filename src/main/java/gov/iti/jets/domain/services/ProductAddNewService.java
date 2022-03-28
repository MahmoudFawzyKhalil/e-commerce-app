package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductAddNewService {

    public ProductAddNewService() {
    }

    public void addProduct( Product product ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ecommerce" );
        EntityManager entityManager = emf.createEntityManager();
        ProductRepository productRepository = new ProductRepository( entityManager );
        entityManager.getTransaction().begin();
        productRepository.create( product );
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
