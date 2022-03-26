package gov.iti.jets.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class CartLineItem {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Product product;

    @Min( 0 )
    private int quantity;

    @ManyToOne
    private ShoppingCart shoppingCart;

    protected CartLineItem() {

    }

    public CartLineItem( Product product, int quantity ) {
        this.product = product;
        this.quantity = quantity;
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

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    void _setShoppingCart( ShoppingCart shoppingCart ) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "id=" + id +
                ", product=" + product.getName() +
                ", quantity=" + quantity +
                ", totalCost=" + getTotalCost() +
                '}';
    }

    public long getTotalCost() {
        return this.quantity * this.getProduct().getPrice();
    }
}
