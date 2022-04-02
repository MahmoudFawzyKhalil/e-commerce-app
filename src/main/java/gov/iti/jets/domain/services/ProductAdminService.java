package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.ProductRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ProductAdminService {

    public static Product updateProduct( Product product ) {
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        em.getTransaction().begin();
        Product updatedProduct = productRepository.update( product );
        em.getTransaction().commit();
        em.close();
        return updatedProduct;
    }

    public static void deleteProduct( int productId ) {
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        Optional<Product> one = productRepository.findOne( productId );
        em.getTransaction().begin();
        one.ifPresent( product -> product.setDeleted( true ) );
        em.getTransaction().commit();
        em.close();
    }

    public static Optional<Product> getProductById( int id ) {
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        Optional<Product> product = productRepository.findOne( id );
        em.close();
        return product;
    }

    public static List<Product> getPageOfProduct( int pageNumber ) {
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        List<Product> productList;
        productList = productRepository.getPageOfProduct( pageNumber );
        em.close();
        return productList;
    }

    public static long getNumberOfPagesOfProduct() {
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        long pageNumber = productRepository.getNumberOfPages();
        em.close();
        return pageNumber;

    }
}
