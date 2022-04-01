package gov.iti.jets.presentation.util;

import jakarta.servlet.http.Cookie;

import java.util.Optional;
import java.util.stream.Stream;

public class CookieUtil {
    public static Optional<Cookie> getCookie( Cookie[] cookies, String cookieName ) {
        Optional<Cookie> optionalCookie = Optional.empty();
        boolean result = false;

        if ( cookies != null ) {
            optionalCookie = Stream.of( cookies )
                    .filter( ( c ) -> c.getName().equals( cookieName ) )
                    .findFirst();
        }

        return optionalCookie;
    }
}
