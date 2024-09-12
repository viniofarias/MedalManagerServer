package medalManagerMain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import medalManagerMain.clients.AcessoDTO;
import medalManagerMain.clients.AuthJWTClient;

@Service
public class JWTokenService {
	@Autowired
	private AuthJWTClient authJWTClient;
	
	public ResponseEntity<Object> gerarToken(AcessoDTO acesso) {
		var acessoAuth = authJWTClient.gerarToken(acesso);
		return acessoAuth;
	}
	public ResponseEntity<Long> validarToken(AcessoDTO acesso) {
		var usuarioID = authJWTClient.validarToken(acesso);
		return usuarioID;
	}
}
