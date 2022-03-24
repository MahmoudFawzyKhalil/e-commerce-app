package gov.iti.jets.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "address")
    @NotNull
    private User owner;

    @NotNull
    @Size(min = 3, max = 250)
    private String street;

    @NotNull
    @Size(min = 3, max = 250)
    private String city;

    public void assignOwner(User owner) {
        owner.setAddress(this);
        this.owner = owner;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", owner=" + owner.getFullName() +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
