package gov.iti.jets.presentation.listeners;

import gov.iti.jets.domain.DomainFacade;
import gov.iti.jets.domain.models.ShoppingCart;
import gov.iti.jets.domain.models.User;
import gov.iti.jets.domain.util.JpaUtil;
import gov.iti.jets.repository.ShoppingCartRepository;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import javax.swing.text.html.parser.Entity;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated( HttpSessionEvent sessionEvent ) {
        System.out.println( "Session created with id " + sessionEvent.getSession().getId() );
    }

    @Override
    public void sessionDestroyed( HttpSessionEvent sessionEvent ) {
        HttpSession session = sessionEvent.getSession();
        User sessionUser = (User) session.getAttribute( "user" );
        ShoppingCart sessionShoppingCart = (ShoppingCart) session.getAttribute( "shoppingCart" );

        if ( sessionUser != null && sessionShoppingCart != null ) {
            DomainFacade.persistShoppingCart( sessionShoppingCart );
        }
    }
}
