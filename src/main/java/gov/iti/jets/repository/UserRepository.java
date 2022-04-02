package gov.iti.jets.repository;

import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {
    private final static int pageSize = 5;

    public UserRepository( EntityManager entityManager ) {
        super( entityManager );
        this.setClazz( User.class );
    }

    public Optional<User> findUserByEmail( String email ) {
        User user = null;
        email = email.toLowerCase();
        try {
            TypedQuery<User> query = entityManager.createQuery( "SELECT u FROM User u WHERE u.email = :email", User.class );
            query.setParameter( "email", email );
            user = query.getSingleResult();
        } catch ( NoResultException nre ) {
            nre.printStackTrace();
        }
        return Optional.ofNullable( user );
    }

    public List<User> getPage( int pageNumber ) {
        TypedQuery<User> query = entityManager.createQuery( "FROM User u where u.role = 'CUSTOMER' ", User.class );
        return query.setFirstResult( ( pageNumber - 1 ) * pageSize )
                .setMaxResults( pageSize )
                .getResultList();
    }


    public long getNumberOfPages() {
        Query queryTotal = entityManager.createQuery( "SELECT COUNT(u.id) FROM User u where u.role = 'CUSTOMER' " );
        long countResult = (long) queryTotal.getSingleResult();

        long finalPage = ( countResult % pageSize > 0 ? 1 : 0 );

        return ( countResult / pageSize ) + finalPage;
    }
}
