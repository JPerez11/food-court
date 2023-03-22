package com.pragma.foodcourt.infrastructure.security.filter;

import com.pragma.foodcourt.infrastructure.security.util.TokenUtils;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class to authorize jwt credentials.
 */
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        //Get bearer token from Authorization header
        String bearerToken = request.getHeader("Authorization");

        //Validate that bearerToken is not null and starts with "Bearer"
        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            //Remove the word "Bearer" from the bearerToken variable
            String token = bearerToken.replace("Bearer ", "");
            //Get authentication with the credentials in the token
            UsernamePasswordAuthenticationToken authenticationToken =
                    TokenUtils.getAuthenticationToken(token);
            //Set authentication in Spring SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);

    }
}
