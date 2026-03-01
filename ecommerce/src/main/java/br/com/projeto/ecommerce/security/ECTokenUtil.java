package br.com.projeto.ecommerce.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.projeto.ecommerce.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class ECTokenUtil {
	
	public static final long UM_SEGUNDO = 1000;
	public static final	long UM_MINUTO = UM_SEGUNDO *60;
	public static final long UMA_HORA = UM_MINUTO*60;
	public static final long UM_DIA = UMA_HORA *24;
	public static final long UMA_SEMANA = UM_DIA * 7;
	
	public static final String EMISSOR ="**TrueDev**";
	public static final String TOKEN_KEY = "01234567890123456789012345678901";
	public static final String TOKEN_HEADER = "Bearer ";
	
	private static SecretKey getKet() {
		return Keys.hmacShaKeyFor(TOKEN_KEY.getBytes());
	}
	
	public static ECToken generateToken(Usuario usuario) {
		    String jwt = Jwts.builder()
		    		.issuer(EMISSOR)
		    		.subject(usuario.getLogin())
		    		.expiration(new Date(System.currentTimeMillis() + UM_MINUTO))
		    		.signWith(getKet())
		    		.compact();
		    
			ECToken token = new ECToken();
			token.setToken(TOKEN_HEADER + jwt);
			return token;		
		}
		
	public static Authentication decodeToken(HttpServletRequest request) {

	    String token = request.getHeader("Authorization");

	    if (token == null || !token.startsWith(TOKEN_HEADER)) {
	        return null; 
	    }

	    token = token.replace(TOKEN_HEADER, "");

	    try {
	        Claims claims = Jwts.parser()               
	            .verifyWith(getKet())              
	            .build()
	            .parseSignedClaims(token)               
	            .getPayload();                         

	        String login    = claims.getSubject();
	        String emissor  = claims.getIssuer();
	        Date   validade = claims.getExpiration();
	        if (login.length() > 0
	                && emissor.equals(EMISSOR)
	                && validade.after(new Date(System.currentTimeMillis()))) {
	            return new UsernamePasswordAuthenticationToken(
	                login, null, Collections.emptyList()
	            );
	        }
	    } catch (Exception e) {
	        return null;
	    }

	    return null;
	}
}
