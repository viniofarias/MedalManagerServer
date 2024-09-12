package medalManagerMain.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medalManagerMain.DTOs.CadastrarMedalhaDTO;
import medalManagerMain.DTOs.MedalhaDTO;
import medalManagerMain.DTOs.NotificarMedalhaDTO;
import medalManagerMain.services.MedalhaService;

@RestController
@RequestMapping("/medalha")
public class MedalhaController {
	@Autowired
	private MedalhaService medalhaService;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<NotificarMedalhaDTO> adicionarUmaMedalha(@RequestBody CadastrarMedalhaDTO medalha) {
		try {
			NotificarMedalhaDTO medalhaDTO = medalhaService.adicionarUmaMedalha(medalha);
			this.rabbitTemplate.convertAndSend("email.notificacao",medalhaDTO);
			return ResponseEntity.ok(medalhaDTO);
		} catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}		
	}
}
