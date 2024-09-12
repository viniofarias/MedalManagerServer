package medalManagerMain.settings.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import medalManagerMain.clients.AcessoDTO;
import medalManagerMain.repositories.UsuarioRepository;
import medalManagerMain.services.JWTokenService;

@Component
public class SecurityFilter extends OncePerRequestFilter{
	@Value("${spring.application.name}")
    private String applicationName;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private JWTokenService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
		var token = recuperarToken(request);
		if(token != null) {
			AcessoDTO acesso = new AcessoDTO();
			acesso.setAplicacao(applicationName);
			acesso.setToken(token);
			var usuarioID = jwtService.validarToken(acesso).getBody();
			var usuario = usuarioRepository.findById(usuarioID).get();
			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
	}
	
	public String recuperarToken(HttpServletRequest request) {
	    var token = request.getHeader("Authorization");
	    
	    
	    //System.out.println("Header Authorization: " + token); // Imprime o valor completo do cabeçalho Authorization
	    
	    if (token != null && token.startsWith("Bearer ")) {
	        String tokenSemBearer = token.replace("Bearer ", "").trim();
	        //System.out.println("Token processado: " + tokenSemBearer); // Imprime o token sem o prefixo Bearer
	        return tokenSemBearer;
	    }
	    
	    return null;
	}
}
