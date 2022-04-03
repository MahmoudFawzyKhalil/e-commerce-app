package gov.iti.jets.domain.models;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.util.JpaUtil;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product {

    private static final String DEFAULT_IMAGE = "default.jpeg";

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size( min = 3, max = 200 )
    @Column( name = "product_name" )
    private String name;

    @Size( min = 3, max = 1000 )
    private String description;

    private String imageName;

    @Min( 0 )
    private long price;

    @Min( 0 )
    private int quantity;

    @NotNull
    private Category category;

    private boolean deleted = false;

    protected Product() {

    }

    public Product( int id, String name, String description, String imageName, long price, int quantity, Category category ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.setImageName( imageName );
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product( String name, String description, String imageName, long price, int quantity, Category category ) {
        this.name = name;
        this.description = description;
        this.setImageName( imageName );
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName( String imageName ) {
        if ( imageName == null || imageName.isEmpty() || imageName.isBlank() ) {
            this.imageName = DEFAULT_IMAGE;
            return;
        }
        this.imageName = imageName;
    }

    @JsonbTransient
    public long getPrice() {
        return price;
    }

    public void setPrice( long price ) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory( Category category ) {
        this.category = category;
    }

    public String getPriceFormatted() {
        return "" + this.price / 100 + "." + this.price % 100;
    }

    // TODO remove getPriceFormatting + add EGP to JSP
    public String getPriceFormatting() {
        return "EGP " + ( (int) price / 100 ) + ".00";
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted( boolean deleted ) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", imageName='" + imageName + '\'' + ", price=" + price + ", quantity=" + quantity + ", category=" + category + '}';
    }

    public boolean refreshDataToValidateCartLineItems( int cartLineItemQuantity ) {

        var em = JpaUtil.createEntityManager();
        Product updatedProduct = em.find( Product.class, this.getId() );
        em.close();

        boolean wasOutdated = false;

        copyState( updatedProduct );

        int quantityAfterRefresh = this.quantity;

        if ( quantityAfterRefresh < cartLineItemQuantity || this.deleted ) {
            wasOutdated = true;
        }

        return wasOutdated;
    }

    private void copyState( Product updatedProduct ) {
        this.setImageName( updatedProduct.imageName );
        this.setCategory( updatedProduct.category );
        this.setName( updatedProduct.name );
        this.setPrice( updatedProduct.price );
        this.setDeleted( updatedProduct.deleted );
        this.setQuantity( updatedProduct.quantity );
        this.setDescription( updatedProduct.description );
    }
}
