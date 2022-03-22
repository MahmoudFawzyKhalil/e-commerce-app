package gov.iti.jets;

import jakarta.persistence.Persistence;
import jakarta.validation.Validation;

public class Main {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("ecommerce");
        var em = emf.createEntityManager();

        var user = new User();
        System.out.println(Validation.buildDefaultValidatorFactory().getValidator().validate(user));;

//        user.setUserName("Mary");

//        em.getTransaction().begin();
//        em.persist(user);
//        em.getTransaction().commit();
    }
}
