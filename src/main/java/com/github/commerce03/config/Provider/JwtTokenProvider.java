package com.github.commerce03.config.Provider;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String secretKey = "Commerce03"; //
    private final long validityInMilliseconds = 3600000; // 토큰의 유효시간 (1시간)

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("TOKEN");
    }


    // 토큰 생성
    public String createToken(String userEmail) {
        Claims claims = Jwts.claims().setSubject(userEmail);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 토큰 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
