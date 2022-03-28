package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserRegistrationService {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ecommerce" );
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void registerNewUser( User user ) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        UserRepository userRepository = new UserRepository( em );

        String hashedPassword = passwordEncoder.encode( user.getPassword() );
        user.setPassword( hashedPassword );
        tx.begin();
        userRepository.create( user );
        tx.commit();

        em.close();
    }

/*    public static void main( String[] args ) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode( "password" );
        System.out.println( hashedPassword.length() );
        System.out.println( hashedPassword );
        System.out.println( encoder.matches( "passwor", hashedPassword ) );
    }*/

}
