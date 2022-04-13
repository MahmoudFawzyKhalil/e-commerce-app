package gov.iti.jets.domain.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cfg.AvailableSettings;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class JpaUtil {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory( "ecommerce", Map.of( AvailableSettings.DATASOURCE, createHikariCpDataSource() ) );
    }

    private static HikariDataSource createHikariCpDataSource() {
        HikariConfig config = new HikariConfig();
        HikariDataSource ds;

        config.setJdbcUrl( "jdbc:mysql://localhost:3306/ecommerce?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false" );
        config.setUsername( "manager" );
        config.setPassword( "manager" );
        config.setMaximumPoolSize( 30 );
        config.addDataSourceProperty( "cachePrepStmts", true );
        config.addDataSourceProperty( "prepStmtCacheSize", 250 );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit", 2048 );
        config.setDriverClassName( "com.mysql.cj.jdbc.Driver" );
        ds = new HikariDataSource( config );

        return ds;
    }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }
}
