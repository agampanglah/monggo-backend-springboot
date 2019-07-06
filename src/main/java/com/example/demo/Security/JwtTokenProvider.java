package com.example.demo.Security;

import com.example.demo.Entity.User;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.Security.SecurityConstant.EXPIRED_TIME;
import static com.example.demo.Security.SecurityConstant.SECRET;

@Component
public class JwtTokenProvider {


    public String generateToken(Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date session = new Date(now.getTime() + EXPIRED_TIME);

        String userId = Long.toString(user.getId());

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", (Long.toString(user.getId())));
        claims.put("username", user.getUsername());
        claims.put("fullname", user.getFullname());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(session)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }


    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;

        } catch (SignatureException ex) {
            System.out.println("Invalid JWT Signature");
        } catch (MalformedJwtException ex) {
            System.out.println("invalid JWT Token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT TOken");
        } catch (UnsupportedOperationException ex) {
            System.out.println("unsopprted JWT");
        } catch (IllegalArgumentException ex) {
            System.out.println("Jwt claims String is Empty");
        }

        return false;
    }


    public Long getUserId(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String id = (String)claims.get("id");

        return Long.parseLong(id);
    }

}
