package medalManagerMain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import medalManagerMain.DTOs.PaisDTO;
import medalManagerMain.models.Pais;
import medalManagerMain.services.PaisService;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {
	@Autowired
	private PaisService paisService;
	
	@GetMapping
	public Page<PaisDTO> getAllPais(Pageable pagi){
		return paisService.getAllPais(pagi);
	} 
}
