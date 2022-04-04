package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.EmailGateway;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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


    public static boolean resetPassword( String email, String passwordResetId ) {
        var em = JpaUtil.createEntityManager();
        var ur = new UserRepository( em );

        boolean emailSent = false;
        var optionalUser = ur.findUserByEmail( email );

        if ( optionalUser.isPresent() ) {
            try {
                EmailGateway.sendResetPasswordEmail( email, passwordResetId );
                emailSent = true;
            } catch ( EmailException e ) {
                e.printStackTrace();
            }

        }

        return emailSent;
    }
}
