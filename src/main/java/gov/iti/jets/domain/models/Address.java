package gov.iti.jets.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "address")
    @NotNull
    @JoinColumn(name = "address_owner")
    private User owner;

    @NotNull
    @Size(min = 3, max = 250)
    private String street;

    @NotNull
    @Size(min = 3, max = 250)
    private String city;

    protected Address(){

    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public void assignOwner(User owner) {
        owner._setAddress(this);
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

    public void _setOwner(User owner) {
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
