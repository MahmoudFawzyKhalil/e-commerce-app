package gov.iti.jets.presentation.listeners;

import gov.iti.jets.domain.util.AppConfig;
import gov.iti.jets.domain.util.JpaUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebListener
public class BootstrapListener implements ServletContextListener {

    public BootstrapListener() {
    }

    @Override
    public void contextInitialized( ServletContextEvent sce ) {
        try {
            AppConfig.load();
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
