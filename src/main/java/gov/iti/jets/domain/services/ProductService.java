package gov.iti.jets.domain.services;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.ProductRepository;

import java.util.List;

public class ProductService {
    public static List<Product> getAPageOfProducts( int pageNumber ) {
        var em = JpaUtil.createEntityManager();
        ProductRepository pr = new ProductRepository( em );
        List<Product> products = pr.getPage( pageNumber );
        em.close();
        return products;
    }

    public static List<Product> getProductsByNameAndCategory( String productNameQuery, Category productCategory ) {
        var em = JpaUtil.createEntityManager();
        ProductRepository pr = new ProductRepository( em );
        List<Product> products = pr.findProductsByNameOrCategory( productNameQuery, productCategory );
        em.close();
        return products;
    }
}
