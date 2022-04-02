package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.OrderLineItem;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OrderListOfItemsService {

    public static  List<OrderLineItem> getItemsByOrderId( int id){
        EntityManager em = JpaUtil.createEntityManager();
        OrderRepository orderRepository = new OrderRepository( em );
        var itemList =orderRepository.findAllItemsByOrderId( id );
        em.close();
        return itemList;
    }

    public static Optional<Order> getOrderById( int id ) {
        EntityManager em = JpaUtil.createEntityManager();
        OrderRepository orderRepository = new OrderRepository( em );
        var optionalOrder =orderRepository.findOne( id );
        em.close();
        return optionalOrder;
    }


}

