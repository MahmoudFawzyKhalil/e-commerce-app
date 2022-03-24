package gov.iti.jets.domain.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "shoppingCart")
    private User owner;

    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private final Set<CartLineItem> cartLineItems = new HashSet<>();

    public void addCartLineItem(CartLineItem cartLineItem) {
        cartLineItem.setShoppingCart(this);
        this.cartLineItems.add(cartLineItem);
    }

    public void removeCartLineItem(CartLineItem cartLineItem) {
        this.cartLineItems.remove(cartLineItem);
    }

    private long calculateTotal() {
        return this.cartLineItems.stream()
                .mapToLong(CartLineItem::getTotalCost)
                .sum();
    }

    public void assignToAUser(User owner){
        owner.setShoppingCart(this);
        this.owner = owner;
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

    public Set<CartLineItem> getCartLineItems() {
        return cartLineItems;
    }


    public long getTotal() {
        return calculateTotal();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", owner=" + owner.getFullName() +
                ", cartLineItems=" + cartLineItems +
                '}';
    }
}
