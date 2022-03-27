package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductAddNewServices {
    Product product;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ecommerce" );
    EntityManager entityManager =emf.createEntityManager();

    public ProductAddNewServices( Product product ) {
        this.product = product;
    }

    public void addProduct(){
        ProductRepository productRepository = new ProductRepository( entityManager );
        entityManager.getTransaction().begin();
        productRepository.create( product );
        entityManager.getTransaction().commit();
    }

}
