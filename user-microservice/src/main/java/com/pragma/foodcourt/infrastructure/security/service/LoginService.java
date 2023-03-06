package com.pragma.foodcourt.infrastructure.security.service;

import com.pragma.foodcourt.infrastructure.security.dto.AuthCredentials;
import static com.pragma.foodcourt.infrastructure.security.util.TokenUtils.createToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserDetailsService userDetailsService;

    public String login(AuthCredentials authCredentials) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authCredentials.getEmail());
        return createToken(userDetails);

    }
}
