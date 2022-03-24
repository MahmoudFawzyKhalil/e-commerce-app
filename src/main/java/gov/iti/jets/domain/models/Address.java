package gov.iti.jets.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 250)
    private String street;

    @NotNull
    @Size(min = 3, max = 250)
    private String city;

    protected Address() {

    }

    public Address( String street, String city ) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet( String street ) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
