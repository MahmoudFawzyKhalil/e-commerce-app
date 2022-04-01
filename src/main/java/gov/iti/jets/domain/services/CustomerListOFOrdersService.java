package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerListOFOrdersService {
    public static  List<Order> getAllOrdersForUser(int id){
        EntityManager em = JpaUtil.createEntityManager();
        OrderRepository orderRepository = new OrderRepository( em );
        return orderRepository.findAllByUserId(id);
    }

    public static Optional<User> getCustomerbyId( int id ) {
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository userRepository = new UserRepository( em );
        return userRepository.findOne( id );
    }
}

