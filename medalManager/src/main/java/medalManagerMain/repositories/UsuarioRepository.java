package medalManagerMain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import medalManagerMain.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public UserDetails findByLogin(String email);
}
