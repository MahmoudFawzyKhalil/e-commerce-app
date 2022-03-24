package gov.iti.jets.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Product product;

    @Min(0)
    private int quantity;

    @Min(0)
    private long unitCost;

    @ManyToOne
    @JoinColumn(name = "owner_order")
    private Order order;

    public void assignToAnOrder(Order order) {
        order.addOrderLineItem(this);
        this.order = order;
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

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(long unitCost) {
        this.unitCost = unitCost;
    }

    public Order getOrder() {
        return order;
    }

    public void _setOrder(Order order) {
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
