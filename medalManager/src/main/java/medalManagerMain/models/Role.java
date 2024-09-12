package medalManagerMain.models;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import medalManagerMain.DTOs.RoleDto;

@Entity(name = "roles")
public class Role implements GrantedAuthority{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;
	
	public Role() {}
	
	public Role(Role roleDto) {
		this.id = roleDto.id;
		this.role = roleDto.role;
	}
	
	public Role(RoleDto roleDto) {
		this.id = roleDto.id();
		this.role = roleDto.role();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}
	
	
}
