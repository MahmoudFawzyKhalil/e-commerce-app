package gov.iti.jets.domain;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.services.ProductAddNewServices;

public class DomainFacade {
    private static final DomainFacade INSTANCE = new DomainFacade();

    public static DomainFacade getInstance() {
        return INSTANCE;
    }

    public static void addProduct( Product product ){
        ProductAddNewServices productAddNewServices = new ProductAddNewServices( product );
        productAddNewServices.addProduct();
    }
}
