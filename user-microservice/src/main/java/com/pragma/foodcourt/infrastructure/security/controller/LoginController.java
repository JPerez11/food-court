package com.pragma.foodcourt.infrastructure.security.controller;

import com.pragma.foodcourt.infrastructure.security.dto.AuthCredentials;
import com.pragma.foodcourt.infrastructure.security.dto.LoginResponseDto;
import com.pragma.foodcourt.infrastructure.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody AuthCredentials authCredentials) {
        return LoginResponseDto.builder()
                .token(loginService.login(authCredentials))
                .build();
    }

    @GetMapping("/test")
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        String userRole = authentication.getAuthorities().toString();

        return "Este endpoint solo se puede acceder si está autenticado. El usuario autenticado es " + userEmail + " con el rol " + userRole;
    }


}
