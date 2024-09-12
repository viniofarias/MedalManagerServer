package medalManagerMain.DTOs;


import medalManagerMain.enums.TipoMedalha;
import medalManagerMain.models.Esporte;
import medalManagerMain.models.Medalha;

public record MedalhaDTO(Long id, TipoMedalha tipoMedalha, Esporte esporte) {
	public MedalhaDTO(Medalha medalha) {
		this( medalha.getId(),medalha.getTipoMedalha(), medalha.getEsporte());
	}
}
