package gov.iti.jets.domain;

public class DomainFacade {
    private static DomainFacade INSTANCE = new DomainFacade();

    public static DomainFacade getInstance() {
        return INSTANCE;
    }
}
