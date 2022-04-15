package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.FeedbackMessage;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.FeedbackRepository;
import gov.iti.jets.repository.UserRepository;

public class UserFeedbackMessageService {

    public static void addFeedbackMessage( FeedbackMessage message ) {
        var em = JpaUtil.createEntityManager();
        var fm = new FeedbackRepository( em );
        var tx = em.getTransaction();
        
        tx.begin();
        fm.create( message );
        tx.commit();

        em.close();
    }
}
