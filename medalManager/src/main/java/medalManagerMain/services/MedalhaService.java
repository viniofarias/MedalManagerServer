package medalManagerMain.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medalManagerMain.DTOs.CadastrarMedalhaDTO;
import medalManagerMain.DTOs.MedalhaDTO;
import medalManagerMain.DTOs.NotificarMedalhaDTO;
import medalManagerMain.enums.TipoMedalha;
import medalManagerMain.models.Esporte;
import medalManagerMain.models.Medalha;
import medalManagerMain.models.Pais;
import medalManagerMain.repositories.EsporteRepository;
import medalManagerMain.repositories.MedalhaRepository;
import medalManagerMain.repositories.PaisRepository;

@Service
public class MedalhaService {
	@Autowired
	private MedalhaRepository medalhaRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EsporteRepository esporteRepository;
	
	public NotificarMedalhaDTO adicionarUmaMedalha(CadastrarMedalhaDTO medalhaDTO) throws Exception {

		Pais pais = paisRepository.findById(medalhaDTO.idPais()).get();
		
		Esporte esporte = esporteRepository.findById(medalhaDTO.idEsporte()).get();
		
		Medalha newMedal = new Medalha();
		
		newMedal.setTipoMedalha(TipoMedalha.valueOf(medalhaDTO.tipoMedalha()));
		newMedal.setEsporte(esporte);
		newMedal.setPais(pais);
		
		Medalha medalhaSalva = medalhaRepository.save(newMedal);
		if(medalhaSalva == null) {
			throw new Exception();
		}
		
		return new NotificarMedalhaDTO(medalhaSalva);
		
	}
}
