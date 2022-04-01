package gov.iti.jets.repository;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ProductRepository extends AbstractRepository<Product> {
    private static int pageSize =0;

    public ProductRepository(EntityManager entityManager) {
        super(entityManager);
        this.setClazz(Product.class);
    }

    public List<Product> getPageOfProduct( int pageNumber ) {
        Query query = entityManager.createQuery( "FROM Product " );

        return query.setFirstResult( ( pageNumber - 1 ) * pageSize )
                .setMaxResults( pageSize )
                .getResultList();
    }


    public long getNumberOfPages() {
        Query queryTotal = entityManager.createQuery( "SELECT COUNT(p.id) FROM Product p" );
        long countResult = (long) queryTotal.getSingleResult();

        long finalPage = ( countResult % pageSize > 0 ? 1 : 0 );

        return ( countResult / pageSize ) + finalPage;
    }
    public void setPageSize( int size ) {
        pageSize = size;
    }


}
