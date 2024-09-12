package medalManagerMain.DTOs;

import java.util.ArrayList;
import java.util.List;

import medalManagerMain.enums.TipoMedalha;
import medalManagerMain.models.Medalha;
import medalManagerMain.models.Pais;
import medalManagerMain.models.Usuario;

public class PaisDTO {
	private Long id;
	private String nome;
	private List<Medalha> medalhas = new ArrayList<Medalha>();
	//private List<Usuario> usuarios = new ArrayList<Usuario>();
	private long qtdGoldMedal;
	private long qtdSilverMedal;
	private long qtdBronzeMedal;
	private int totalMedalhas;
	
	public PaisDTO(Pais pais) {
		var medalhas = pais.getMedalhas();
		this.id = pais.getId();
		this.nome = pais.getNome();
		this.medalhas = medalhas;
		//this.usuarios = pais.getUsuarios();
		this.qtdGoldMedal = medalhas.stream().filter(medalha -> medalha.getTipoMedalha().equals(TipoMedalha.OURO)).count();
		this.qtdSilverMedal = medalhas.stream().filter(medalha -> medalha.getTipoMedalha().equals(TipoMedalha.PRATA)).count();
		this.qtdBronzeMedal = medalhas.stream().filter(medalha -> medalha.getTipoMedalha().equals(TipoMedalha.BRONZE)).count();
		this.totalMedalhas = medalhas.size();
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

	public List<Medalha> getMedalhas() {
		return medalhas;
	}

	public void setMedalhas(List<Medalha> medalhas) {
		this.medalhas = medalhas;
	}

	public long getQtdGoldMedal() {
		return qtdGoldMedal;
	}

	public void setQtdGoldMedal(long qtdGoldMedal) {
		this.qtdGoldMedal = qtdGoldMedal;
	}

	public long getQtdSilverMedal() {
		return qtdSilverMedal;
	}

	public void setQtdSilverMedal(long qtdSilverMedal) {
		this.qtdSilverMedal = qtdSilverMedal;
	}

	public long getQtdBronzeMedal() {
		return qtdBronzeMedal;
	}

	public void setQtdBronzeMedal(long qtdBronzeMedal) {
		this.qtdBronzeMedal = qtdBronzeMedal;
	}

	public int getTotalMedalhas() {
		return totalMedalhas;
	}

	public void setTotalMedalhas(int totalMedalhas) {
		this.totalMedalhas = totalMedalhas;
	}
	
	
	
}
	