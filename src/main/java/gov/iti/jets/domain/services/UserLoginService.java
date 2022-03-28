package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UserLoginService {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static Optional<User> loginUser( String email, String password ) {
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository userRepository = new UserRepository( em );

        boolean isValidLogin = false;

        var userOpt = userRepository.findUserByEmail( email );

        if ( userOpt.isPresent() ) {
            String userActualPassword = userOpt.get().getPassword();
            isValidLogin = passwordEncoder.matches( password, userActualPassword );
        }

        em.close();
        return isValidLogin ? userOpt : Optional.empty();
    }
}
