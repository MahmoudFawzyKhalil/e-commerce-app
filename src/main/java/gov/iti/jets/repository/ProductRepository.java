package gov.iti.jets.repository;

import gov.iti.jets.domain.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductRepository extends AbstractRepository<Product> {
    private final static int PAGE_SIZE =5;

    public ProductRepository(EntityManager entityManager) {
        super(entityManager);
        this.setClazz(Product.class);
    }

    public List<Product> getPageOfProduct( int pageNumber ) {
        TypedQuery<Product> query = entityManager.createQuery( "FROM Product " ,Product.class);

        return query.setFirstResult( ( pageNumber - 1 ) * PAGE_SIZE )
                .setMaxResults( PAGE_SIZE )
                .getResultList();
    }


    public long getNumberOfPages() {
        Query queryTotal = entityManager.createQuery( "SELECT COUNT(p.id) FROM Product p" );
        long countResult = (long) queryTotal.getSingleResult();

        long finalPage = ( countResult % PAGE_SIZE > 0 ? 1 : 0 );

        return ( countResult / PAGE_SIZE ) + finalPage;
    }



}
