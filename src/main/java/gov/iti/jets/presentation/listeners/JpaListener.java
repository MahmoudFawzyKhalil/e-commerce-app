package gov.iti.jets.presentation.listeners;

import gov.iti.jets.domain.util.JpaUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebListener
public class JpaListener implements ServletContextListener {

    public JpaListener() {
    }

    @Override
    public void contextInitialized( ServletContextEvent sce ) {
        try {
            Class.forName( "gov.iti.jets.domain.util.JpaUtil" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed( ServletContextEvent sce ) {
        JpaUtil.closeEntityManagerFactory();
        System.out.println( "CLOSED " );
    }
}
