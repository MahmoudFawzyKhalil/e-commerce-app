package gov.iti.jets.domain;

import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.services.GetListOfCustomersService;
import gov.iti.jets.domain.services.UserRegistrationService;

import gov.iti.jets.domain.models.Product;
import gov.iti.jets.domain.services.ProductAddNewService;

import java.util.List;

public class DomainFacade {

    public static void addProduct( Product product ) {
        ProductAddNewService.addProduct( product );
    }

    public static void registerNewUser( User user ) {
        UserRegistrationService.registerNewUser( user );
    }

    public static List<User> getPage(int pageNumber){ return GetListOfCustomersService.getPage(pageNumber);}

    public static void setPage(int pageSize){ GetListOfCustomersService.setPage(pageSize);}

    public static long getPageNumber(){return GetListOfCustomersService.getPageNumber();}
}
