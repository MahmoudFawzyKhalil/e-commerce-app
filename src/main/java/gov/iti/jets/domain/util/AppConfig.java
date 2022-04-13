package gov.iti.jets.domain.util;

public class AppConfig {
    public static String DB_HOST;
    public static String DB_USER;
    public static String DB_PASSWORD;
    public static String IMG_PATH;

    public static void load() {
        DB_HOST = System.getenv( "DB_HOST" );
        DB_USER = System.getenv( "DB_USER" );
        DB_PASSWORD = System.getenv( "DB_PASSWORD" );

        String environment = System.getenv( "ECOMMERCE_ENVIRONMENT" );

        switch ( environment ) {
            case "deployment":
                IMG_PATH = System.getProperty( "user.dir" ) + "/ecommerce/";
                break;
            default:
                IMG_PATH = System.getProperty( "user.dir" ) + "/../ecommerce/";
        }

        System.out.println( "***************************" );
        System.out.println( DB_HOST );
        System.out.println( DB_USER );
        System.out.println( DB_PASSWORD );
        System.out.println( IMG_PATH );
        System.out.println( "****************************" );
    }
}
