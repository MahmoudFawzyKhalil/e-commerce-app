package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.ProductRepository;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class ProductAdminService {
    public static List<Product> getProduct(int pageNumber){
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        List<Product> productList;
        productList= productRepository.getPageOfProduct( pageNumber );
        em.close();
        return productList;
    }
    public static long getPageNumber(){
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        long pageNumber = productRepository.getNumberOfPages();
        em.close();
        return pageNumber;

    }
    public static void setPageSize( int pageSize ) {
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        productRepository.setPageSize( pageSize );
        em.close();
    }
}
