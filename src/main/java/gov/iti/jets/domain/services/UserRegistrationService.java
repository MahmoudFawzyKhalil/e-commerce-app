package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserRegistrationService {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void registerNewUser( User user ) {
        var em = JpaUtil.createEntityManager();
        var tx = em.getTransaction();
        var userRepository = new UserRepository( em );

        String hashedPassword = passwordEncoder.encode( user.getPassword() );
        user.setPassword( hashedPassword );

        tx.begin();
        userRepository.create( user );
        tx.commit();
        em.close();
    }
}
