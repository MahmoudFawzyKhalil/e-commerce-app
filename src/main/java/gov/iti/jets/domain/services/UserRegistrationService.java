package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserRegistrationService {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ecommerce" );

    public static void registerNewUser( User user ) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        UserRepository userRepository = new UserRepository( em );

        tx.begin();
        userRepository.create( user );
        tx.commit();
    }
}
