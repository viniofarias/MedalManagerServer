package medalManagerMain.DTOs;

import java.util.ArrayList;
import java.util.List;

import medalManagerMain.enums.TipoMedalha;
import medalManagerMain.models.Esporte;
import medalManagerMain.models.Medalha;

public class EsporteDTO {
	private Long id;
	private String nome;
	private List<Medalha> medalhas = new ArrayList<Medalha>();
	private long qtdGoldMedal;
	private long qtdSilverMedal;
	private long qtdBronzeMedal;
	private int totalMedalhas;
	
	public EsporteDTO(Esporte esporte) {
		var medalhas = esporte.getMedalhas();
		this.id = esporte.getId();
		this.nome = esporte.getNome();
		this.medalhas = medalhas;
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
