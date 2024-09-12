package auth.jwt.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import auth.jwt.DTO.AcessoDTO;

@Service
public class JWTokenService {
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String gerarToken(AcessoDTO acesso) {
		try {
			var algoritmo = Algorithm.HMAC256(secret);
			return JWT.create()
			.withIssuer(acesso.getAplicacao())
			.withExpiresAt(dataExpiracao())
			.withClaim("usuarioID", acesso.getUsuarioID())
			.sign(algoritmo);
		} catch ( JWTCreationException exception){
			throw new RuntimeException("erro ao gerrar token jwt", exception);
		} 
	}
		
	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
	public Long checkToken(AcessoDTO acesso) {
		 try {
				 var algoritmo = Algorithm.HMAC256(secret);
				 Long usuario =  JWT.require(algoritmo)
				 .withIssuer(acesso.getAplicacao())
				 .build()
				 .verify(acesso.getToken()).getClaim("usuarioID").asLong();
				 
				 return usuario;

		 } catch ( JWTVerificationException exception) {
			 throw new RuntimeException("Token JWT inválido ou expirado!");
		 }
	}

}
