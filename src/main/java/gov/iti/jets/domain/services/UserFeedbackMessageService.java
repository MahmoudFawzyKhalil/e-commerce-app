package gov.iti.jets.domain.services;

import gov.iti.jets.domain.models.FeedbackMessage;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.EmailGateway;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.FeedbackRepository;
import gov.iti.jets.repository.UserRepository;
import org.apache.commons.mail.EmailException;

import java.util.List;

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
    public static List<FeedbackMessage> getAllFeedbackMessage() {
        var em = JpaUtil.createEntityManager();
        var fm = new FeedbackRepository( em );
        List<FeedbackMessage> feedbackMessages = fm.findAllFeedbackMessages();
        em.close();
        return feedbackMessages;
    }

    public static void sendFeedbackReply(FeedbackMessage message) {
        try {
            EmailGateway.sendFeedbackReplyEmail( message );
        } catch ( EmailException e ) {
            System.out.println(e.getCause());
        }
    }

}
