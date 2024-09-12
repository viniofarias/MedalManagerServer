package medalManagerMain.DTOs;

import java.util.List;

import medalManagerMain.models.Medalha;
import medalManagerMain.models.Pais;
import medalManagerMain.models.Usuario;





public record UsuarioDto(Long id, String nome, String login, String senha, List<RoleDto> roles, List<Pais> paises) {
	public UsuarioDto(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha(), 
				usuario.getRoles().stream().map(RoleDto::new).toList(), usuario.getPaises());
	}
}
