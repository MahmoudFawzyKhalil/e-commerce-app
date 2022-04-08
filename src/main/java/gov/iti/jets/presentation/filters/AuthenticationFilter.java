package gov.iti.jets.presentation.filters;

import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter( filterName = "AuthenticationFilter", urlPatterns = "/admin/*" )
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpServletRequest.getSession( false );

        if ( httpSession == null ) {
            redirectHome( httpServletRequest, httpServletResponse );
            return;
        }
        User user = (User) httpSession.getAttribute( "user" );

        if ( user != null && user.getRole() == Role.ADMIN ) {
            chain.doFilter( request, response );
        } else {
            redirectHome( httpServletRequest, httpServletResponse );
        }
    }

    private void redirectHome( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse ) throws IOException {
        httpServletResponse.sendRedirect( httpServletRequest.getContextPath() + "/home" );
    }
}
