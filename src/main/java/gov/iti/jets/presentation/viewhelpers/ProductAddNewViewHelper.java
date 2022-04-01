package gov.iti.jets.presentation.viewhelpers;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.presentation.controllers.ProductAddNewControllerServlet;

public class ProductAddNewViewHelper {
    boolean successfullyAddedProduct = false;
    boolean failedToAddProduct = false;

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
