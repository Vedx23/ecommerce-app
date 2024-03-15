package com.ecom.clothingapp.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
// what is @component in spring?
/*
 * In Spring Java, @Component is a class-level annotation that denotes a class
 * as a Spring Framework component. It is used to indicate that a class is a
 * Spring-managed bean, which can be automatically detected through classpath
 * scanning and dependency injection. The @Component annotation can be used
 * alongside other specialized annotations such as @Service, @Repository,
 * and @Controller to indicate the specific role of the component in the
 * application. When a class is annotated with @Component, Spring's IoC
 * (Inversion of Control) container can manage the lifecycle of the object,
 * including creating instances, configuring dependencies, and managing scope.
 */
public class JwtAutenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(
            // @NonNull because those parameters cannot be null
            // and without them the filter will not work
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
                final String authHeader = request.getHeader("Authorization");
                final String jwt;
                final String userEmail;

                //// CHECK JWT TOKEN

                //token does not exist
                if(authHeader == null || !authHeader.startsWith("Bearer ")){
                    filterChain.doFilter(request, response);
                    return;
                }

                jwt = authHeader.substring(7);
                userEmail = jwtService.extractUsername(jwt);
    }

}
