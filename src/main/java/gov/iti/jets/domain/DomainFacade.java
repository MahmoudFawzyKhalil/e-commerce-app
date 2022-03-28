package gov.iti.jets.domain;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.services.ProductAddNewService;

public class DomainFacade {
    private static final DomainFacade INSTANCE = new DomainFacade();

    public static DomainFacade getInstance() {
        return INSTANCE;
    }

    public static void addProduct( Product product ){
        ProductAddNewService productAddNewService =new ProductAddNewService();
        productAddNewService.addProduct(product);
    }
}
