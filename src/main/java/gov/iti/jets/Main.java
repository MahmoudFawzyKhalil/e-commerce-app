package gov.iti.jets;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Address;
import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;

public class Main {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("ecommerce");
        var em = emf.createEntityManager();


        User user = new User();
        Address address = new Address();
//        user.setAddress(new Address());
//        address.assignOwner(user);
        user.assignAddress(address);

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

    }
}
