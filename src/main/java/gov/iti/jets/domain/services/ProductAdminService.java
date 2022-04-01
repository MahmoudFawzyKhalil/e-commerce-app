package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.ProductRepository;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductAdminService {

    public static Product updateProduct(Product product){
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        em.getTransaction().begin();
        Product updatedProduct = productRepository.update( product );
        em.getTransaction().commit();
        em.close();
        return updatedProduct;
    }

    public static void deleteProduct(int productId){
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        Optional<Product> one = productRepository.findOne( productId );
        em.getTransaction().begin();
        if( one.isPresent() ){
            productRepository.delete( one.get() );
        }
        em.getTransaction().commit();

        em.close();
    }

    public static void main( String[] args ) {
        ProductAdminService.deleteProduct( 1 );
    }

    public static Product getProductById(int id){
        EntityManager em = JpaUtil.createEntityManager();
        ProductRepository productRepository = new ProductRepository( em );
        Product product = productRepository.findOne( id ).get();
        return product;
    }

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
