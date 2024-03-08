package ar.com.dario.colmena.api.security;

import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokensUtil {
    private final static String ACCESS_TOKEN = "untokenalazarparaautenticar";
    private final static Long ACCESS_TOKEN_VALIDITY_TIME = 2_592_00L;


    public static String createToken(String name, String email){
        long expitationTime = ACCESS_TOKEN_VALIDITY_TIME * 1_000;
        Date expitationDate = new Date(System.currentTimeMillis() + expitationTime);

        Map<String, Object> extra = new HashMap<>();

        extra.put("nombre", name);

        return Jwts.builder()
                    .setSubject(email)
                    .setExpiration(expitationDate)
                    .addClaims(extra)
                    .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN.getBytes()))
                    .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication (String token){

        try {
            Claims claims = Jwts.parserBuilder()
                                .setSigningKey(ACCESS_TOKEN.getBytes())
                                .build()
                                .parseClaimsJws(token)
                                .getBody();

            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (Exception e) {
            return null;
        }
    }

}
