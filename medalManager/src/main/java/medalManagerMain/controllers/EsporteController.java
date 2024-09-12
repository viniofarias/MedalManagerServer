package medalManagerMain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medalManagerMain.DTOs.EsporteDTO;
import medalManagerMain.services.EsporteService;

@RestController
@RequestMapping(value = "/esporte")
public class EsporteController {
	@Autowired
	private EsporteService esporteService;
	
	@GetMapping(value = "/{idPais}")
	public ResponseEntity<List<EsporteDTO>> getMedalhasPorEsporteEPais(@PathVariable String idPais){
		return ResponseEntity.ok(esporteService.getMedalhasPorEsporteEPorPais(idPais));
	}
}
