package gov.iti.jets;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;

public class Main {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("ecommerce");
        var em = emf.createEntityManager();
    }
}
