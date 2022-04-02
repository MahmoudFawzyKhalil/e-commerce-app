package gov.iti.jets.domain.util;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentMethodCreateParams;
import com.stripe.param.PaymentMethodCreateParams.CardDetails;
import gov.iti.jets.domain.dtos.CardDto;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.User;

import static com.stripe.param.PaymentMethodCreateParams.Type.CARD;

public class PaymentGateway {


    /*
     * Number guaranteed to succeed: 4242424242424242
     * Number guaranteed to fail: 4000000000009995
     * */
    static {
        Stripe.apiKey = "sk_test_51Kk78hAgrOPQLNmpvgf3FTYVfP7JDD0uLxXkZcFqW0cFHhVv6NxiUZbKcyW8W1S3uEl5L7HAUh2eCO5rb0252MYX00NqNrhmHM";
    }

    public static void payForOrder( Order order, CardDto card ) throws Exception {
        User owner = order.getOwner();
        Customer customer = createStripeCustomer( owner.getEmail(), owner.getFullName() );
        PaymentMethod paymentMethod = createStripePaymentMethod( card );
        PaymentIntent paymentIntent = createStripePaymentIntent( customer.getId(), paymentMethod.getId(), order.getTotal() );
        paymentIntent.confirm();
    }

    private static Customer createStripeCustomer( String email, String name ) throws StripeException {
        CustomerCreateParams customerCreateParams =
                CustomerCreateParams
                        .builder()
                        .setEmail( email )
                        .setName( name )
                        .build();

        return Customer.create( customerCreateParams );
    }

    private static PaymentMethod createStripePaymentMethod( CardDto card ) throws StripeException {

        CardDetails cardDetails = CardDetails.builder()
                .setCvc( card.getCvc() )
                .setNumber( card.getNumber() )
                .setExpMonth( card.getExpMonth() )
                .setExpYear( card.getExpYear() )
                .build();

        PaymentMethodCreateParams paymentMethodCreateParams =
                PaymentMethodCreateParams
                        .builder()
                        .setCard( cardDetails )
                        .setType( CARD )
                        .build();

        return PaymentMethod.create( paymentMethodCreateParams );
    }

    private static PaymentIntent createStripePaymentIntent( String customerId, String paymentMethodId, long amount ) throws StripeException {
        PaymentIntentCreateParams paymentIntentCreateParams =
                PaymentIntentCreateParams
                        .builder()
                        .setCustomer( customerId )
                        .setPaymentMethod( paymentMethodId )
                        .setCurrency( "usd" )
                        .setAmount( amount )
                        .addPaymentMethodType( "card" )
                        .setSetupFutureUsage( PaymentIntentCreateParams.SetupFutureUsage.ON_SESSION )
                        .build();

        return PaymentIntent.create( paymentIntentCreateParams );
    }

/*    public static void main( String[] args ) throws StripeException {
        Customer customer = createStripeCustomer( "harryyyy@gmail.com", "Mary" );
        CardDto card = new CardDto( "4242424242424242", "123", 1, 2050 );
        PaymentMethod paymentMethod = createStripePaymentMethod( card );
        PaymentIntent paymentIntent = createStripePaymentIntent( customer.getId(), paymentMethod.getId(), 1000 );
        paymentIntent.confirm();
    }*/
}
