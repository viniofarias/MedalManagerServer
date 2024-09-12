package medalManagerMain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medalManagerMain.DTOs.CadastrarUsuarioDTO;
import medalManagerMain.DTOs.UsuarioDto;
import medalManagerMain.clients.AcessoDTO;
import medalManagerMain.services.JWTokenService;
import medalManagerMain.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	@Value("${spring.application.name}")
    private String applicationName;
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JWTokenService jwtService;
	

	@GetMapping
	public Page<UsuarioDto> getAllUsers(Pageable pag){
		return usuarioService.getAllUsers(pag);
	}
	
	@GetMapping(value = "getById")
	public ResponseEntity<UsuarioDto> getByID(@RequestHeader("Authorization") String token){
		try {
		    String tokenSemBearer = null;
		    if (token != null && token.startsWith("Bearer ")) {
		    	tokenSemBearer = token.replace("Bearer ", "").trim();
		    }
		    
		    if (tokenSemBearer == null) {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		    }
		    
		    AcessoDTO acesso = new AcessoDTO();
			acesso.setAplicacao(applicationName);
			acesso.setToken(tokenSemBearer);
			Long usuarioID = jwtService.validarToken(acesso).getBody();

			return ResponseEntity.ok(usuarioService.getByID(usuarioID));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> CreateUser(@RequestBody CadastrarUsuarioDTO usuarioDto) {
		
		UsuarioDto usuarioDtoSalvo = usuarioService.CreateUser(usuarioDto);	
		return ResponseEntity.ok(usuarioDtoSalvo);
	}
	

	@PostMapping(value = "/usuarioPais/{idPais}")
	public ResponseEntity<UsuarioDto> FollowUserPais(@RequestHeader("Authorization") String token, @PathVariable Long idPais) {
		
		try {
		    String tokenSemBearer = null;
		    if (token != null && token.startsWith("Bearer ")) {
		    	tokenSemBearer = token.replace("Bearer ", "").trim();
		    }
		    
		    if (tokenSemBearer == null) {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		    }
		    
		    AcessoDTO acesso = new AcessoDTO();
			acesso.setAplicacao(applicationName);
			acesso.setToken(tokenSemBearer);
			Long usuarioID = jwtService.validarToken(acesso).getBody();

			return ResponseEntity.ok(usuarioService.followUserPais(usuarioID, idPais));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
