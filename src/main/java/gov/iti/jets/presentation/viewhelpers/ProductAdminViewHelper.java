package gov.iti.jets.presentation.viewhelpers;

import gov.iti.jets.domain.models.Product;

import java.io.Serializable;

public class ProductAdminViewHelper {
    boolean successfullyAddedProduct = false;
    boolean failedToAddProduct = false;
    Product product = null;

    public void setProduct( Product product ) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
    public boolean isSuccessfullyAddedProduct() {
        return successfullyAddedProduct;
    }


    public void setSuccessfullyAddedProduct( boolean successfullyAddedProduct ) {
        this.successfullyAddedProduct = successfullyAddedProduct;
    }

    public void setFailedToAddProduct( boolean failedToAddProduct ) {
        this.failedToAddProduct = failedToAddProduct;
    }

    public boolean isFailedToAddProduct() {
        return failedToAddProduct;
    }
}
