package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class GetListOfCustomersService {
    public static List<User> getPage(int pageNumber) {
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository userRepository = new UserRepository( em );
        List<User> userList= new ArrayList<>();
        userList= userRepository.getPage( pageNumber );
        em.close();
        return userList;
    }
    public static long getPageNumber(){
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository userRepository = new UserRepository( em );
        long pageNumber = userRepository.getNumberOfPages();
        em.close();
        return pageNumber;
    }

    public static void setPage( int pageSize ) {
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository userRepository = new UserRepository( em );
        userRepository.setPageSize( pageSize );

        em.close();
    }
}

