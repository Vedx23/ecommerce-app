package com.ecom.clothingapp.utils;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.crypto.SecretKey;

import io.jsonwebtoken.*;
import org.apache.commons.lang3.time.DateUtils;

import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTutils {

    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384.key() or HS512.key()
    private static final String ISSUER = "ecom-website";
    private static final int EXPIRATION_HOURS = 24; //expiration time set for 24 hours

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
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(jwtToken);
            Claims body = claimsJws.getBody();
            return Optional.of(body);
        } catch (JwtException | IllegalArgumentException e) {
            log.error("JWT parsing exception occurred", e);
        }

        return Optional.empty();

    }

    public static String generateToken(String email) {

        Date currentDate = new Date();
        Date expiration = DateUtils.addHours(currentDate, EXPIRATION_HOURS);

        return Jwts.builder()
        .setId(UUID.randomUUID().toString())
        .setIssuer(ISSUER)
        .setSubject(email)
        .signWith(SECRET_KEY)
        .setIssuedAt(currentDate)
        .setExpiration(expiration)
        .compact();
    }

}
