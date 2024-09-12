package auth.jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.exceptions.JWTVerificationException;

import auth.jwt.DTO.AcessoDTO;
import auth.jwt.services.JWTokenService;

@RestController
@RequestMapping(value = "/auth", produces = {"application/json"})
public class AuthenticationController {
	@Autowired
	private JWTokenService tokenService;
	
	@PostMapping(value = "/gerarToken")
	public ResponseEntity<Object> gerarToken(@RequestBody AcessoDTO acesso) {
		try {
			var token = tokenService.gerarToken(acesso);
			acesso.setToken(token);
			return ResponseEntity.ok(acesso);
		}catch (RuntimeException ex){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		
	}
	
	@PostMapping(value = "/validarToken")
	public ResponseEntity validarToken(@RequestBody AcessoDTO acesso){
		try {
			var usuarioID = tokenService.checkToken(acesso);
			return ResponseEntity.ok(usuarioID);
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		
	}
}
