package gov.iti.jets.domain.models;


import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;



    public String getFullName(){
        return "";
    }
    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignAddress(Address address){
        address.setOwner(this);
        this.address = address;
    }


}
