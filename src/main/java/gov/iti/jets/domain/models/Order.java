package gov.iti.jets.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private final Set<OrderLineItem> orderLineItems = new HashSet<>();

    @NotNull
    private final LocalDateTime timestamp = LocalDateTime.now();

    @Min(0)
    private long total = 0;

    public void addOrderLineItem(OrderLineItem orderLineItem){
        orderLineItem.setOrder(this);
        this.orderLineItems.add(orderLineItem);
        updateTotal(orderLineItem.getTotalCost());
    }

    private void updateTotal(long orderLineItemTotalCost){
        total += orderLineItemTotalCost;
    }

    public int getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", owner=" + owner.getFullName() +
                ", orderLineItems=" + orderLineItems +
                ", timestamp=" + timestamp +
                ", total=" + total +
                '}';
    }
}
