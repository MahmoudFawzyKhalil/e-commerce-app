package gov.iti.jets.presentation.viewhelpers;

import gov.iti.jets.domain.models.Product;

public class ProductEditViewHelper {
    boolean failedToEditProduct = false;
    Product product = null;

    public void setProduct( Product product ) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }


    public void setFailedToEditProduct( boolean failedToAddProduct ) {
        this.failedToEditProduct = failedToAddProduct;
    }

    public boolean isFailedToEditProduct() {
        return failedToEditProduct;
    }
}
