package com.cliente.springboot.config;

import java.util.Date;
import com.dto.UserForLoginDto;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Component
public class JwtTokenConfig {

    static final long EXPIRATION_TIME = 860_000_000;
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    // @Value("${spring.mail.host}")
    private final static String secret = "RuEMQJTrZwQkoEJMFICf";

    // generate token for user
    public String generateToken(UserForLoginDto user) {
        return doGenerateToken(user.getUsername());
    }

    static String doGenerateToken(String username) {
        return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    static void addAuthentication(HttpServletResponse response, String username) {
        String JWT = doGenerateToken(username);
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // faz parse do token
            String user = Jwts.parser().setSigningKey(secret).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }
        return null;
    }

}
