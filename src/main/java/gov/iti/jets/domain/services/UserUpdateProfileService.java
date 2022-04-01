package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.UserRepository;

public class UserUpdateProfileService {

    public static void updateUser( User user ) {
        var em = JpaUtil.createEntityManager();
        var ur = new UserRepository( em );
        var tx = em.getTransaction();
        
        tx.begin();
        ur.update( user );
        tx.commit();

        em.close();
    }
}
