package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.ProductRepository;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class GetAllCustomersService {
    public static List<User> getAllCustomersService() {
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository userRepository = new UserRepository( em );
        List<User> userList= new ArrayList<>();
        userList= userRepository.findAll();
        em.close();
        return userList;
    }
}

