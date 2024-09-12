package medalManagerMain.DTOs;

import medalManagerMain.models.Role;

public record RoleDto(Long id, String role) {
	public RoleDto(Role role) {
		this(role.getId(), role.getRole());
	}
}
