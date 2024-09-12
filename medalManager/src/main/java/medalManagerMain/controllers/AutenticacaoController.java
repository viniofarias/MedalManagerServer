package medalManagerMain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medalManagerMain.DTOs.DadoAutenticacao;
import medalManagerMain.clients.AcessoDTO;
import medalManagerMain.clients.AuthJWTClient;
import medalManagerMain.models.Usuario;
import medalManagerMain.services.JWTokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private JWTokenService jwtService;
	
	@Value("${spring.application.name}")
    private String applicationName;
	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody DadoAutenticacao dados) {
		try {
			var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
			var authentication = manager.authenticate(token);
			var user = (Usuario)authentication.getPrincipal();
			AcessoDTO acesso = new AcessoDTO();
			acesso.setUsuarioID(user.getId());
			acesso.setAplicacao(applicationName);
			var acess = jwtService.gerarToken(acesso).getBody();
			return ResponseEntity.ok(acess);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		
	}
}
