package com.ecom.clothingapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterChain {
    @Autowired
    private final AuthenticationEntryPoint authenticationEntryPoint;
    
    @Autowired
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.cors(corsConfig -> corsConfig.disable());
        httpSecurity.csrf(csrfConfig -> csrfConfig.disable());
        httpSecurity.authorizeHttpRequests(
            requestMatcher -> requestMatcher.requestMatchers("/api/v1/login/**").permitAll()
            .requestMatchers("/api/v1/signup/**").permitAll()
            .anyRequest().authenticated());
        
        httpSecurity.exceptionHandling( exceptionConfig -> exceptionConfig.authenticationEntryPoint(authenticationEntryPoint));
        httpSecurity.sessionManagement( sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
    

}
