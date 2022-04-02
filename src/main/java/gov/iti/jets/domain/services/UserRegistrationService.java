package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.EmailGateway;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.apache.commons.mail.EmailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

public class UserRegistrationService {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void registerNewUser( User user ) {
        var em = JpaUtil.createEntityManager();
        var tx = em.getTransaction();
        var userRepository = new UserRepository( em );

        String hashedPassword = passwordEncoder.encode( user.getPassword() );
        UUID confirmationUuid = UUID.randomUUID();
        user.setConfirmationId( confirmationUuid.toString() );
        user.setPassword( hashedPassword );
        user.setEmail( user.getEmail().toLowerCase() );

        sendConfirmationEmail( user );

        tx.begin();
        userRepository.create( user );
        tx.commit();
        em.close();
    }


    private static void sendConfirmationEmail( User user ) {
        try {
            EmailGateway.sendUserRegistrationConfirmationEmail( user.getEmail(), user.getConfirmationId() );
        } catch ( EmailException e ) {
            e.printStackTrace();
        }
    }

    public static boolean confirmUserRegistration( String confirmationId ) {
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository ur = new UserRepository( em );
        EntityTransaction tx = em.getTransaction();
        boolean confirmed = false;

        Optional<User> optionalUser = ur.findUserByConfirmationId( confirmationId );
        if ( optionalUser.isPresent() ) {
            User user = optionalUser.get();
            user.setConfirmedAccount( true );

            if ( !user.isConfirmedAccount() ) {
                tx.begin();
                ur.update( user );
                tx.commit();
            }

            em.close();
            confirmed = true;
        }

        return confirmed;
    }
}
