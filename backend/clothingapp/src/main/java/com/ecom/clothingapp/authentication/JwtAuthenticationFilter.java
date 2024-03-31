package com.ecom.clothingapp.authentication;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecom.clothingapp.utils.JWTutils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Optional<String> jwtTokenOptional = getTokenFromRequest(request);
        if (jwtTokenOptional.isPresent()) {
            String jwtToken = jwtTokenOptional.get();
            if (JWTutils.validateToken(jwtToken)) {
                Optional<String> usernameOptional = JWTutils.getUsernameFromToken(jwtToken);
                // find a better way to handle this
                var userDetails = userDetailsService.loadUserByUsername(usernameOptional.orElseThrow());
                // creating auth token here
                var authToken = new UsernamePasswordAuthenticationToken(userDetails, null,
                        userDetails.getAuthorities());
                //adding additional information about the request into the authentication token
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //adding token to the securityContextHolder for referencing from anywhere in the app
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    //private method and is called above
    private Optional<String> getTokenFromRequest(HttpServletRequest request) {
        String jwtToken = request.getHeader(org.springframework.http.HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(jwtToken) && jwtToken.startsWith("Bearer ")) {
            return Optional.of(jwtToken.substring(7));
        }
        return Optional.empty();
    }

}
