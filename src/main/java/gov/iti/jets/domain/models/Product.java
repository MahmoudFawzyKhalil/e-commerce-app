package gov.iti.jets.domain.models;

import gov.iti.jets.domain.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity()
public class Product {

    private static final String DEFAULT_IMAGE = "default.jpeg";

    @Id
    @GeneratedValue
    int id;

    @NotNull @Size(min = 3, max = 200)
    @Column(name = "product_name")
    String name;

    @Size(min = 3 ,max = 1000) String description;

    String imageName;

    @Min(0) long price;

    @Min(0) int quantity;

    @NotNull Category category;

    protected Product() {

    }

    public Product(int id ,String name, String description, String imageName, long price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.setImageName(imageName);
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
    public Product(int id ,String name, String description, long price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
    public Product(String name, String description, String imageName, long price, int quantity, Category category) {
        this.name = name;
        this.description = description;
        this.setImageName(imageName);
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getPriceFormatting() {
        return "EGP "+((int) price/100)+".00";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        if (imageName == null || imageName.isEmpty() || imageName.isBlank()) {
            this.imageName = DEFAULT_IMAGE;
            return;
        }
        this.imageName = imageName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", imageName='" + imageName + '\'' + ", price=" + price + ", quantity=" + quantity + ", category=" + category + '}';
    }
}
