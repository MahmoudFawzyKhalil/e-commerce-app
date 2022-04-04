package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.EmailGateway;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.apache.commons.mail.EmailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

public class UserLoginService {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static Optional<User> loginUser( String email, String password ) {
        var em = JpaUtil.createEntityManager();
        var userRepository = new UserRepository( em );

        boolean isValidLogin = false;

        var optionalUser = userRepository.findUserByEmail( email );

        if ( optionalUser.isPresent() ) {
            String userActualPassword = optionalUser.get().getPassword();
            isValidLogin = passwordEncoder.matches( password, userActualPassword );
        }

        em.close();

        return isValidLogin ? optionalUser : Optional.empty();
    }

    public static Optional<User> loginUserRememberMe( String email, String password ) {
        var em = JpaUtil.createEntityManager();
        var userRepository = new UserRepository( em );

        var optionalUser = userRepository.findUserByEmail( email );

        em.close();

        return optionalUser;
    }


    public static String sendResetPasswordEmail( String email ) throws Exception {
        var em = JpaUtil.createEntityManager();
        var ur = new UserRepository( em );

        String passwordResetId = null;
        var optionalUser = ur.findUserByEmail( email );
        em.close();

        if ( optionalUser.isPresent() ) {
            passwordResetId = UUID.randomUUID().toString();
            EmailGateway.sendResetPasswordEmail( email, passwordResetId );
        } else {
            throw new IllegalArgumentException( "user doesn't exist!!" );
        }

        return passwordResetId;
    }

    public static void resetPassword( String email, String newPassword ) {
        var em = JpaUtil.createEntityManager();
        var ur = new UserRepository( em );

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        var optionalUser = ur.findUserByEmail( email );

        if ( optionalUser.isPresent() ) {
            User user = optionalUser.get();
            user.setPassword( encoder.encode( newPassword ) );
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            ur.update( user );
            tx.commit();
            em.close();
        } else {
            throw new IllegalArgumentException( "user doesn't exist!!" );
        }

    }
}
