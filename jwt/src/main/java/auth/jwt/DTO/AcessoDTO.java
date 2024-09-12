package auth.jwt.DTO;

public class AcessoDTO {
	private long usuarioID;
	private String aplicacao;
	private String token;
	
	public AcessoDTO(long usuarioID, String aplicacao, String token) {
		this.usuarioID = usuarioID;
		this.aplicacao = aplicacao;
		this.token = token;
	}
	
	public AcessoDTO() {}
	
	public long getUsuarioID() {
		return usuarioID;
	}
	public String getAplicacao() {
		return aplicacao;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setUsuarioID(long usuarioID) {
		this.usuarioID = usuarioID;
	}
	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}
	
}
