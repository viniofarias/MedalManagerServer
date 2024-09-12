package medalManagerMain.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import medalManagerMain.DTOs.CadastrarUsuarioDTO;
import medalManagerMain.DTOs.UsuarioDto;
import medalManagerMain.models.Pais;
import medalManagerMain.models.Usuario;
import medalManagerMain.repositories.PaisRepository;
import medalManagerMain.repositories.UsuarioRepository;


@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PaisRepository paisRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UsuarioDto CreateUser(CadastrarUsuarioDTO usuarioDto) {

		Usuario usuario = new Usuario(usuarioDto);
		String senha = usuario.getSenha();
		usuario.setSenha(passwordEncoder.encode(senha));
		usuarioRepository.save(usuario);
		return new UsuarioDto(usuario);
	}
	
	public Page<UsuarioDto> getAllUsers(Pageable pag){
		return usuarioRepository.findAll(pag).map(UsuarioDto::new);
	}
	
	public UsuarioDto followUserPais(Long idUsuario, Long idPais) throws Exception{
		
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		Pais pais = paisRepository.findById(idPais).get();
		
		usuario.getPaises().add(pais);

		Usuario novoUsuario = usuarioRepository.save(usuario);
		
		if(novoUsuario == null)
			throw new Exception();
		
		return new UsuarioDto(novoUsuario);
	}
	
	public UsuarioDto getByID(Long usuarioID) throws Exception {
		Usuario usuario = usuarioRepository.findById(usuarioID).get();
		if(usuario == null) {
			throw new Exception();
		}		
		return new UsuarioDto(usuario);
	}
	
}
