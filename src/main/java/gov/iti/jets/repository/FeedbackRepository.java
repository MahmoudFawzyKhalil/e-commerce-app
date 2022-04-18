package gov.iti.jets.repository;

import gov.iti.jets.domain.models.FeedbackMessage;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class FeedbackRepository extends AbstractRepository<FeedbackMessage> {
    public FeedbackRepository( EntityManager entityManager ) {
        super( entityManager );
        this.setClazz( FeedbackMessage.class );
    }
    public List<FeedbackMessage> findAllFeedbackMessages() {
        TypedQuery<FeedbackMessage> query= entityManager.createQuery( "select f from FeedbackMessage f ", FeedbackMessage.class );
        return query.getResultList();
    }
}
