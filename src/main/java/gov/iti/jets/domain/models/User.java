package gov.iti.jets.domain.models;


import gov.iti.jets.domain.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=100)
    private String firstName;

    @NotNull
    @Size(min=1, max=100)
    private String lastName;

    @Email
    private String email;

    @NotNull
    @Size(min=8, max=50)
    private String password;

    @NotNull
    @Past
    private LocalDate birthday;

    @Min(0)
    private long creditLimit;

    @Size(max=100)
    private String job;

    @NotNull
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Address address;

    @OneToOne
    private ShoppingCart shoppingCart;

    public void assignAddress(Address address){
        address.setOwner(this);
        this.address = address;
    }

    public void assignAShoppingCart(ShoppingCart shoppingCart){
        shoppingCart.setOwner(this);
        this.shoppingCart = shoppingCart;
    }

    public String getFullName(){
        return firstName + " " + lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(long creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Optional<ShoppingCart> getShoppingCart() {
        return Optional.ofNullable(this.shoppingCart);
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", creditLimit=" + creditLimit +
                ", job='" + job + '\'' +
                ", role=" + role +
                ", address=" + address +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
