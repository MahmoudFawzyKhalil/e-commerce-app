package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;
import java.util.List;

public class AdminListOfCustomersService {

    public static List<User> getPage(int pageNumber) {
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository userRepository = new UserRepository( em );
        List<User> userList= userRepository.getPage( pageNumber );
        em.close();
        return userList;
    }
    public static long getNumberOfPages(){
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository userRepository = new UserRepository( em );
        long numberOfPages = userRepository.getNumberOfPages();
        em.close();
        return numberOfPages;
    }


}

