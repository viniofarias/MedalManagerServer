package medalManagerMain.settings.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {
	@Bean
	public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOriginPattern("*"); // Permite todos os domínios
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    config.addExposedHeader("Authorization");
	    config.addExposedHeader("UserID");
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	  }
}
