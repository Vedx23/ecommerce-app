package com.ecom.clothingapp.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ecom.clothingapp.authentication.JwtAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class SecurityFilterChain {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public DefaultSecurityFilterChain securityFilterChainConfigBean(HttpSecurity httpSecurity) throws Exception{
        System.out.println("SECURITY FILTER CHAIN CONFIG BEAN CREATED");
        httpSecurity.cors(AbstractHttpConfigurer::disable);

        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.authorizeHttpRequests(
            requestMatcher -> requestMatcher.requestMatchers("/api/auth/signin/**").permitAll()
            .requestMatchers("/api/auth/signup/**").permitAll()
            .requestMatchers("api/v1/user/**").hasRole("USER")
            .requestMatchers("api/v1/seller/**").hasRole("SELLER")
            .requestMatchers("api/v1/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/v1/**").permitAll()
            .anyRequest().authenticated());
        
        httpSecurity.exceptionHandling( exceptionConfig -> exceptionConfig.authenticationEntryPoint(authenticationEntryPoint));

        httpSecurity.sessionManagement( sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
    

}
