package gov.iti.jets.domain.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory( "ecommerce" );

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}
