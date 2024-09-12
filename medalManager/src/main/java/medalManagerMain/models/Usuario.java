package medalManagerMain.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import medalManagerMain.DTOs.CadastrarUsuarioDTO;
import medalManagerMain.DTOs.UsuarioDto;

@Entity(name="usuarios")
public class Usuario implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String login;
	private String senha;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	name = "usuarios_roles",
	joinColumns = @JoinColumn(name = "usuarios_id"),
	inverseJoinColumns = @JoinColumn(name = "roles_id")
	)
	private List<Role> roles = new ArrayList<Role>();
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(
			name = "usuarios_paises",
			joinColumns = @JoinColumn(name = "usuarios_id"),
			inverseJoinColumns = @JoinColumn(name = "paises_id")
			)
	private List<Pais> paises = new ArrayList<Pais>();
	
	public Usuario(){}
	public Usuario(Long id, String nome, String login, String senha) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	public Usuario(CadastrarUsuarioDTO usuarioDTO) {
		this.nome = usuarioDTO.nome();
		this.login = usuarioDTO.login();
		this.senha = usuarioDTO.senha();
	}
	public Usuario(UsuarioDto usuarioDto) {
		this.id = usuarioDto.id();
		this.nome = usuarioDto.nome();
		this.login = usuarioDto.login();
		this.roles = usuarioDto.roles().stream().map(Role::new).toList();
		this.paises = usuarioDto.paises();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	public List<Pais> getPaises() {
		return paises;
	}
	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}
	
	
	
	
}
