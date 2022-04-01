package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminService {
    public static List<Product> getProduct(){
        List<Product> lisOfProduct = new ArrayList<>();
        var em = JpaUtil.createEntityManager();
        var tx = em.getTransaction();
        var productRepository = new ProductRepository( em );

        tx.begin();
        lisOfProduct = productRepository.findAll();
        tx.commit();
        em.close();
        return lisOfProduct;
    }
}
