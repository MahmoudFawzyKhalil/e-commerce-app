package gov.iti.jets.repository;

import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import javax.swing.text.html.Option;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {

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

}
