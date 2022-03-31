package gov.iti.jets.presentation.viewhelpers;

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
