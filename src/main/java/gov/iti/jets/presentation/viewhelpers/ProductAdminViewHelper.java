package gov.iti.jets.presentation.viewhelpers;

import gov.iti.jets.domain.models.Product;

import java.io.Serializable;

public class ProductAdminViewHelper {
    Product product ;

    public  ProductAdminViewHelper(Product product){
        this.product = product;
    }
    public void setProduct( Product product ) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
