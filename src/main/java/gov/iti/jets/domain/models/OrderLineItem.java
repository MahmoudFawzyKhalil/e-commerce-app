package gov.iti.jets.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @Min( 0 )
    private int quantity;

    @Min( 0 )
    private long unitCost;

    @ManyToOne
    @JoinColumn( name = "parent_order" )
    private Order order;

    protected OrderLineItem() {

    }

    public OrderLineItem( CartLineItem cartLineItem ) {
        this.product = cartLineItem.getProduct();
        this.quantity = cartLineItem.getQuantity();
        this.unitCost = cartLineItem.getProduct().getPrice();
    }

    public long getTotalCost() {
        return this.quantity * this.unitCost;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct( Product product ) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    public long getUnitCost() {
        return unitCost;
    }

    public long getUnitCostFormatted() {
        return unitCost/100;
    }

    public void setUnitCost( long unitCost ) {
        this.unitCost = unitCost;
    }

    public Order getOrder() {
        return order;
    }

    void _setOrder( Order order ) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLineItem{" +
                "id=" + id +
                ", product=" + product.getName() +
                ", quantity=" + quantity +
                ", unitCost=" + unitCost +
                ", order=" + order.getId() +
                '}';
    }
}
