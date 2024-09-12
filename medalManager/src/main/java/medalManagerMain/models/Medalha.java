package medalManagerMain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import medalManagerMain.DTOs.MedalhaDTO;
import medalManagerMain.enums.TipoMedalha;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "medalhas")
public class Medalha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoMedalha tipoMedalha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "esporte_id")
	private Esporte esporte;
	
	@Transient
	private Long esporteID;
	
	@Transient
	private Long paisID;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	public Medalha(MedalhaDTO medalhaDto) {
		this.id = medalhaDto.id();
		this.tipoMedalha = medalhaDto.tipoMedalha();
		this.esporte = medalhaDto.esporte();
		this.esporteID = medalhaDto.esporte().getId();
	}
	
	public Medalha(TipoMedalha tipoMedalha, Esporte esporte) {
		this.esporte=esporte;
		this.tipoMedalha=tipoMedalha;
	}
	
	public Long getEsporteID() {
		return this.esporte.getId();
	}
	
	public Long getPaisID() {
		return this.pais.getId();
	}
	
	
	
}
