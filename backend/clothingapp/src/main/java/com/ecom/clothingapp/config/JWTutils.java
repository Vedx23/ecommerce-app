package com.ecom.clothingapp.config;

import java.util.Optional;

import javax.crypto.SecretKey;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTutils {

    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384.key() or HS512.key()

    private JWTutils(){
        //private constructor 
        //this is a helper class/utility class
    }

    public static Optional<String> getUsernameFromToken(String jwtToken) {
        var claimsOptional = parseToken(jwtToken);
        return claimsOptional.map(Claims::getSubject);
    }

    public static boolean validateToken(String jwtToken) {
        return parseToken(jwtToken).isPresent();
    }

    private static Optional<Claims> parseToken(String jwtToken){

        var jwtParser = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build();
        

        try {
            return Optional.of(jwtParser.parseClaimsJwt(jwtToken).getBody());
        } catch (JwtException | IllegalArgumentException e) {
            log.error("JWTUtils exception occured");
        }

        return Optional.empty();

    }

}
