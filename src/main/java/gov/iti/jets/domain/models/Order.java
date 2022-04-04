package gov.iti.jets.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "orders" )
public class Order {

    @OneToMany( mappedBy = "order", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL )
    private final Set<OrderLineItem> orderLineItems = new HashSet<>();

    @NotNull
    private final LocalDateTime timestamp = LocalDateTime.now();

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn( name = "order_user" )
    private User owner;

    @Min( 0 )
    private long total = 0;

    protected Order() {

    }

    public Order( User owner ) {
        this.owner = owner;
        ShoppingCart shoppingCart = owner.getShoppingCart()
                .orElseThrow( () -> new IllegalArgumentException( "User shopping cart is null." ) );
        this.populateLineItemsFromCart( shoppingCart );
    }

    public void populateLineItemsFromCart( ShoppingCart shoppingCart ) {
        shoppingCart.getCartLineItemsUnmodifiable().forEach( cartLineItem -> this.addOrderLineItem( new OrderLineItem( cartLineItem ) ) );
    }

    public void addOrderLineItem( OrderLineItem orderLineItem ) {
        orderLineItem._setOrder( this );
        this.orderLineItems.add( orderLineItem );
        updateTotal( orderLineItem.getTotalCost() );
    }

    private void updateTotal( long orderLineItemTotalCost ) {
        total += orderLineItemTotalCost;
    }

    public int getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public Set<OrderLineItem> getOrderLineItemsUnmodifiable() {
        return Set.copyOf( orderLineItems );
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public long getTotal() {
        return total;
    }

    public long getTotalFormatted() {
        return total/100;
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

    public String getTotalFormatted() {
        return "" + this.total / 100 + "." + this.total % 100;
    }
}
