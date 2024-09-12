package medalManagerMain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import medalManagerMain.DTOs.EsporteDTO;
import medalManagerMain.models.Esporte;
import medalManagerMain.models.Medalha;
import medalManagerMain.models.Pais;
import medalManagerMain.repositories.PaisRepository;

@Service
public class EsporteService {
	@Autowired
	private PaisRepository paisRepository;
	
	public List<EsporteDTO> getMedalhasPorEsporteEPorPais(String idPais){
		var paisID = Long.valueOf(idPais);
		Pais pais = paisRepository.findById(paisID).get();
		var medalhas = pais.getMedalhas();
		List<EsporteDTO> list = new ArrayList<EsporteDTO>();
		var medalhasPorEsporte = medalhas.stream().collect(Collectors.groupingBy(Medalha::getEsporte));
		for(Map.Entry<Esporte, List<Medalha>> entry : medalhasPorEsporte.entrySet()) {
			Esporte esporte = entry.getKey();
            List<Medalha> listaMedalhas = entry.getValue();
            EsporteDTO esporteDTO = new EsporteDTO(esporte);
            esporteDTO.setMedalhas(listaMedalhas);
            list.add(esporteDTO);
		}
		return list;
	}
}
