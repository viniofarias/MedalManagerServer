package gateway.routergateway.settings;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Gateway of Olympics Medals")
				.version("1.0")
				.description("Gateway API"));
	}
}
