package auth.jwt.settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
                .info(new Info().title("Auth Api with JWT")
                .version("1.0")
                .description("Auth API Swagger"));
	}
}
