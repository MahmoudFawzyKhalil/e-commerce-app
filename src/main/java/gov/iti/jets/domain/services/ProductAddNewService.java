package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ProductAddNewService {


    public static void addProduct( Product product ) {
        var em = JpaUtil.createEntityManager();
        var tx = em.getTransaction();
        var productRepository = new ProductRepository( em );

        tx.begin();
        productRepository.create( product );
        tx.commit();
        em.close();
    }
}
