package com.ecom.clothingapp.authentication;

import java.io.IOException;

import com.ecom.clothingapp.dto.AuthStatus;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//this filter is called when none of the previous filter throw exceptions and yet fail to do authentication,
//i.e there is an inherent flaw in the security filter chain itself, the chain itself has thrown an error
//probably the filerChainProxy
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        System.out.println("Filter chain threw an exception");
                response.sendError(HttpStatus.I_AM_A_TEAPOT.value(), AuthStatus.UNAUTHORIZED.name());
    }

}
