package com.pragma.foodcourt.infrastructure.security.config;

import com.pragma.foodcourt.infrastructure.configuration.BCryptConfiguration;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IUserRepository;
import com.pragma.foodcourt.infrastructure.security.filter.JwtAuthenticationFilter;
import com.pragma.foodcourt.infrastructure.security.filter.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurity {

    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final UserDetailsService userDetailsService;
    private final BCryptConfiguration bCryptConfiguration;
    private final IUserRepository userRepository;

//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptConfiguration.encoder());
//    }

//    @Bean
//    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user")
//                .password(bCryptPasswordEncoder.encode("userPass"))
//                .roles("USER")
//                .build());
//        manager.createUser(User.withUsername("root")
//                .password(bCryptPasswordEncoder.encode("adminPass"))
//                .roles("ADMIN", "ROOT")
//                .build());
//        return manager;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(userRepository);
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        System.out.println(jwtAuthenticationFilter.getFilterConfig());

        return http.csrf().disable()
                .httpBasic().disable()
                .cors().disable()
                .authorizeRequests(auth ->
                        auth
                                .antMatchers("/auth/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session ->
                        session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build()
        ;

    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptConfiguration.encoder())
                .and()
                .build();
    }

//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.DELETE)
//                .hasRole("ROOT")
//                .antMatchers("/admin/**")
//                .hasAnyRole("ROOT")
//                .antMatchers("/user/**")
//                .hasAnyRole("USER", "ROOT")
//                .antMatchers("/login/**")
//                .anonymous()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http
//                .sessionManagement()
//                    .invalidSessionUrl("/login?expired")
//                    .sessionFixation().migrateSession()
//                    .maximumSessions(1)
//                    .maxSessionsPreventsLogin(false)
//                    .expiredUrl("/login?expired")
//                    .and()
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .logoutSuccessUrl("/login?logout")
//                    .permitAll();
//
//        return http.build();
//    }

}
