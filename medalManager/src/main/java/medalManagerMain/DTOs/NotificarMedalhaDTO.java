package medalManagerMain.DTOs;

import java.util.List;

import medalManagerMain.models.Medalha;
import medalManagerMain.models.Usuario;


public record NotificarMedalhaDTO(String esporte, String pais, String tipoMedalha, List<String> emailsUsers) {
	public NotificarMedalhaDTO(Medalha medalha) {
		this(medalha.getEsporte().getNome(), medalha.getPais().getNome(), medalha.getTipoMedalha().name(),
			medalha.getPais().getUsuarios().stream().map(Usuario::getLogin).toList()
			);
	}
}
