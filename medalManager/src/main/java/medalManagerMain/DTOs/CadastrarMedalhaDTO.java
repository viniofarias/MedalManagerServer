package medalManagerMain.DTOs;

import medalManagerMain.models.Medalha;

public record CadastrarMedalhaDTO(Long idEsporte, Long idPais, String tipoMedalha) {
	public CadastrarMedalhaDTO(Medalha medalha) {
		this( medalha.getEsporteID(), medalha.getPaisID(), medalha.getTipoMedalha().name());
	}
}
