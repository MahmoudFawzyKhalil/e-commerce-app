package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.OrderLineItem;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OrderListOfItemsService {
    public static  List<OrderLineItem> getAllItemsForOrder( int id){
        EntityManager em = JpaUtil.createEntityManager();
        OrderRepository orderRepository = new OrderRepository( em );
        return orderRepository.findAllItmesByOrderId( id );
    }

    public static Optional<Order> getOrderbyId( int id ) {
        EntityManager em = JpaUtil.createEntityManager();
        OrderRepository orderRepository = new OrderRepository( em );
        return orderRepository.findOne( id );
    }

}

