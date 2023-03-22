package com.pragma.foodcourt.infrastructure.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * Class to create the token and extract its data.
 */
public class TokenUtils {

    private static final String ACCESS_TOKEN_SECRET = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXvCJ9";
    private static final Long ACCESS_TOKEN_VALIDITY_SECONDS = 3600L;

    private TokenUtils() {
    }

    /**
     * Method to create Token.
     * @param userDetails Logged-in user information.
     * @return Token in string format
     */
    public static String createToken(UserDetails userDetails) {
        //Token expiration time
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        //Token expiration date
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        //User email
        String email = userDetails.getUsername();
        //User role
        String role = userDetails
                .getAuthorities()
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found role for this user."))
                .getAuthority();

        //Set subject email in JWT
        Claims claims = Jwts.claims().setSubject(email);
        //Set the role in JWT
        claims.put("role", role);

        //Token generation and return
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();

    }

    /**
     * Method to obtain token credentials.
     * @param token JWT
     * @return User authentication
     */
    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        try {
            Claims claims = Jwts
                    .parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            //Extract the email from the token
            String email = claims.getSubject();
            //Extract the role from the token
            String role = (String) claims.get("role");
            //Create an Authorities with the role
            Collection<? extends GrantedAuthority> authorities =
                    Collections.singletonList(new SimpleGrantedAuthority(role));
            //Return a new User authentication with user credentials
            return new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    authorities
            );
        }
        catch (JwtException e) {
            return null;
        }
    }

}
