package com.services.emailservice.dtos;

import java.util.List;

public record NotificarMedalhaDTO(String esporte, String pais, String tipoMedalha, List<String> emailsUsers) {

}
