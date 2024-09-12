package medalManagerMain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import medalManagerMain.repositories.UsuarioRepository;
@Service
public class AutenticacaoService implements UserDetailsService {
	@Autowired
	private UsuarioRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		var usuario = repository.findByLogin(username);
		return usuario;
	}
}
