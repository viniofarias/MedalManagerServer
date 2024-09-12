package medalManagerMain.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("jwt")
public interface AuthJWTClient {
	@RequestMapping(method = RequestMethod.POST, value = "/auth/gerarToken")
	public ResponseEntity<Object> gerarToken (@RequestBody AcessoDTO acesso);

	@RequestMapping(method = RequestMethod.POST, value = "/auth/validarToken")
	public ResponseEntity<Long> validarToken (@RequestBody AcessoDTO acesso);
}
