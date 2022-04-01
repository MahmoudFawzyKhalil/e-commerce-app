package gov.iti.jets.domain.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
public class ShoppingCart {

    @OneToMany( mappedBy = "shoppingCart", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL )
    private final Set<CartLineItem> cartLineItems = new HashSet<>();

    @Id
    @GeneratedValue
    private int id;

    @OneToOne( cascade = CascadeType.MERGE )
    @JoinColumn( name = "cart_owner" )
    private User owner;

    private boolean isProductAlreadyInCart( int productId ) {
        return this.cartLineItems.stream()
                .anyMatch( cartLineItem -> cartLineItem.getProduct().getId() == productId );
    }

    public void addCartLineItem( CartLineItem cartLineItem ) {
        if ( isProductAlreadyInCart( cartLineItem.getProduct().getId() ) ) {
            return;
        }
        cartLineItem._setShoppingCart( this );
        this.cartLineItems.add( cartLineItem );
    }

    public void updateCartLineItemProductQuantity( int productId, int newQuantity ) {
        if ( newQuantity <= 0 ) {
            this.removeCartLineItem( productId );
        }

        this.cartLineItems.stream()
                .filter( cartLineItem -> cartLineItem.getProduct().getId() == productId )
                .findAny()
                .ifPresentOrElse( lineItem -> lineItem.setQuantity( newQuantity ), () -> {
                    throw new IllegalArgumentException( "Product " + productId + " not in shopping cart" );
                } );
    }


    public void removeCartLineItem( int productId ) {
        this.cartLineItems.removeIf( cartLineItem -> cartLineItem.getId() == productId );
    }

    public long getTotal() {
        return calculateTotal();
    }

    private long calculateTotal() {
        return this.cartLineItems.stream()
                .mapToLong( CartLineItem::getTotalCost )
                .sum();
    }

    public String getTotalFormatted() {
        long total = calculateTotal();
        return "" + total / 100 + "." + total % 100;
    }

    public int getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    void _setOwner( User owner ) {
        this.owner = owner;
    }

    public Set<CartLineItem> getCartLineItemsUnmodifiable() {
        return Set.copyOf( cartLineItems );
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
