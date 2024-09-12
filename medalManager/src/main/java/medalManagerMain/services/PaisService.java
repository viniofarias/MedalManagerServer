package medalManagerMain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import medalManagerMain.DTOs.PaisDTO;
import medalManagerMain.models.Pais;
import medalManagerMain.repositories.PaisRepository;

@Service
public class PaisService {
	@Autowired
	private PaisRepository paisRepository;
	
	public Page<PaisDTO> getAllPais(Pageable pagi){
		return paisRepository.findAll(pagi).map(PaisDTO::new);
	}
}
