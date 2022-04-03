package gov.iti.jets.domain.services;

import gov.iti.jets.domain.dtos.CardDto;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.util.EmailGateway;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.domain.util.PaymentGateway;
import gov.iti.jets.repository.OrderRepository;
import gov.iti.jets.repository.ProductRepository;

public class OrderService {

    public static void payForAndFulfilOrder( ShoppingCart shoppingCart, CardDto card ) throws Exception {
        boolean shoppingCartWasInvalid = shoppingCart.refreshAndValidateData();

        if ( shoppingCartWasInvalid ) {
            throw new IllegalArgumentException( "Can't make an order with an outdated shopping cart." );
        }

        Order order = new Order( shoppingCart.getOwner() );

        PaymentGateway.payForOrder( order, card );

        var em = JpaUtil.createEntityManager();
        var tx = em.getTransaction();
        var pr = new ProductRepository( em );
        var or = new OrderRepository( em );

        tx.begin();

        for ( var item : order.getOrderLineItemsUnmodifiable() ) {
            var product = item.getProduct();
            var productOldQuantity = product.getQuantity();
            var quantityBought = item.getQuantity();
            product.setQuantity( productOldQuantity - quantityBought );
            pr.update( product );
        }

        or.create( order );

        tx.commit();

        EmailGateway.sendOrderConfirmationEmail( order.getOwner().getEmail(), order.getTotalFormatted() );
    }
}
