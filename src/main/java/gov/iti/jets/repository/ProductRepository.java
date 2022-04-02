package gov.iti.jets.repository;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductRepository extends AbstractRepository<Product> {
    private final static int PAGE_SIZE = 5;
    private int pageSize = 2;

    public ProductRepository( EntityManager entityManager ) {
        super( entityManager );
        this.setClazz( Product.class );
    }


    public List<Product> getPageOfProduct( int pageNumber ) {
        TypedQuery<Product> query = entityManager.createQuery( "SELECT p FROM Product  p WHERE p.deleted = FALSE ", Product.class );

        return query.setFirstResult( ( pageNumber - 1 ) * PAGE_SIZE )
                .setMaxResults( PAGE_SIZE )
                .getResultList();
    }

    public long getNumberOfPages() {
        Query queryTotal = entityManager.createQuery( "SELECT COUNT(p.id) FROM Product p WHERE p.deleted = FALSE" );
        long countResult = (long) queryTotal.getSingleResult();

        long finalPage = ( countResult % PAGE_SIZE > 0 ? 1 : 0 );

        return ( countResult / PAGE_SIZE ) + finalPage;
    }

    public void setPageSize( int pageSize ) {
        this.pageSize = pageSize;
    }


    // TODO change to not get deleted products
    public List<Product> findProductsByNameOrCategory( String productNameQuery, Category productCategory ) {
        TypedQuery<Product> queryByName =
                entityManager.createQuery( "SELECT p FROM Product p WHERE p.name LIKE :name", Product.class );
        TypedQuery<Product> queryByNameAndCategory =
                entityManager.createQuery( "SELECT p FROM Product  p WHERE (p.name LIKE :name AND p.category = :category)", Product.class );
        TypedQuery<Product> queryByCategory =
                entityManager.createQuery( "SELECT p FROM Product  p WHERE p.category = :category", Product.class );
        String nameQuery = "%" + productNameQuery + "%";

        List<Product> products;

        if ( productNameQuery.trim().isEmpty() && productCategory == null ) {
            // If no search criteria are provided, do not search
            products = new ArrayList<>();
        } else if ( productNameQuery.trim().isEmpty() ) {
            products = queryByCategory
                    .setParameter( "category", productCategory )
                    .getResultList();
        } else if ( productCategory == null ) {
            products = queryByName
                    .setParameter( "name", nameQuery )
                    .getResultList();
        } else {
            products = queryByNameAndCategory
                    .setParameter( "name", nameQuery )
                    .setParameter( "category", productCategory )
                    .getResultList();
        }

        return products;
    }

    // TODO change to not get deleted products
    public List<Product> getPage( int pageNumber ) {
        TypedQuery<Product> query = entityManager.createQuery( "SELECT p FROM Product p ORDER BY p.id ASC", Product.class );

        return query.setFirstResult( ( pageNumber - 1 ) * pageSize )
                .setMaxResults( pageSize )
                .getResultList();
    }
}
