package gov.iti.jets.repository;

import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.OrderLineItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrderRepository extends AbstractRepository<Order> {

    public OrderRepository(EntityManager entityManager) {
        super(entityManager);
        this.setClazz(Order.class);
    }

    public List<Order> findAllByUserId(int id) {
        TypedQuery<Order> query= entityManager.createQuery( "select o from Order o where o.owner.id = :customerId", Order.class );
        query.setParameter( "customerId",id );
        return query.getResultList();
    }
    public List<OrderLineItem> findAllItemsByOrderId( int id) {
        TypedQuery<OrderLineItem> query= entityManager.createQuery( "select o from OrderLineItem o where o.order.id = :orderId", OrderLineItem.class );
        query.setParameter( "orderId",id );
        return query.getResultList();
    }


}
