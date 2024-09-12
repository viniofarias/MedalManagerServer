package com.services.emailservice.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.services.emailservice.dtos.EmailDto;
import com.services.emailservice.dtos.NotificarMedalhaDTO;
import com.services.emailservice.service.EmailService;

@Component
public class EmailListener {

	@Autowired
	EmailService emailService;

	@RabbitListener(queues = "email.notificacao")
	public void receberEmail(@Payload NotificarMedalhaDTO parametro) {

		for (String email : parametro.emailsUsers()) {

			EmailDto emaildto = new EmailDto("viniofarias10@gmail.com", email,
					"Notificação de uma nova medalha!",
					"O país  " + parametro.pais() + " ganhou mais uma medalha de "
							+ parametro.tipoMedalha() + " no esporte " + parametro.esporte() + ".");

			emailService.sendEmail(emaildto);
		}
	}

}
