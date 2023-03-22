package com.pragma.foodcourt.infrastructure.security.service;

import com.pragma.foodcourt.infrastructure.security.dto.AuthCredentials;
import com.pragma.foodcourt.infrastructure.security.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Service class to create the token of the logged-in user.
 */
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserDetailsService userDetailsService;

    /**
     * Method to create login token.
     * @param authCredentials User credentials (email and password)
     * @return Token in String format.
     */
    public String login(AuthCredentials authCredentials) {
        //load user from database.
        UserDetails userDetails = userDetailsService.loadUserByUsername(authCredentials.getEmail());
        return TokenUtils.createToken(userDetails);

    }

}
