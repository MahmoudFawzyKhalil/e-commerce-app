package gov.iti.jets.domain;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.services.UserRegistrationService;

public class DomainFacade {
    private static DomainFacade INSTANCE = new DomainFacade();

    public static DomainFacade getInstance() {
        return INSTANCE;
    }

    public void registerNewUser( User user ) {
        UserRegistrationService.registerNewUser( user );
    }
}
