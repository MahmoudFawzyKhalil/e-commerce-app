package gov.iti.jets.domain.util;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cfg.AvailableSettings;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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

        Properties properties = loadProperties();

        System.out.println( "*************************************" );
        System.out.println( "*************************************" );
        System.out.println( "*************************************" );
        System.out.println( "*************************************" );
        System.out.println( System.getenv( "DB_HOST" ) );
        System.getenv().forEach( ( k, v ) -> System.out.println( k + ": " + v + "\n\n" ) );
        System.out.println( "*************************************" );
        System.out.println( "*************************************" );
        System.out.println( "*************************************" );
        System.out.println( "*************************************" );

        config.setJdbcUrl( "jdbc:mysql://localhost:3306/ecommerce?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false" );
        config.setUsername( "manager" );
        config.setPassword( "manager" );
        config.setMaximumPoolSize( 15 );
//        config.addDataSourceProperty( "cachePrepStmts", properties.getProperty( "cachePrepStmts" ) );
//        config.addDataSourceProperty( "prepStmtCacheSize", properties.getProperty( "prepStmtCacheSize" ) );
//        config.addDataSourceProperty( "prepStmtCacheSqlLimit", properties.getProperty( "prepStmtCacheSqlLimit" ) );
        config.setDriverClassName( "com.mysql.cj.jdbc.Driver" );
        ds = new HikariDataSource( config );

        return ds;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try {
            properties.load( JpaUtil.class.getResourceAsStream( "/datasource.properties" ) );
        } catch ( IOException ioException ) {
            ioException.printStackTrace();
        }
        return properties;
    }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }
}
