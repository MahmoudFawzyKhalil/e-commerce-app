package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class UserListOfOrdersService {
    public static List<Order> getAllOrdersForUser( int userId ) {
        EntityManager em = JpaUtil.createEntityManager();
        OrderRepository orderRepository = new OrderRepository( em );
        var orders = orderRepository.findAllByUserId( userId );
        em.close();
        return orders;
    }

    public static Optional<User> getCustomerById( int id ) {
        EntityManager em = JpaUtil.createEntityManager();
        UserRepository userRepository = new UserRepository( em );
        var optionalUser = userRepository.findOne( id );
        em.close();
        return optionalUser;
    }
}

