package gateway.routergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class RoutergatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutergatewayApplication.class, args);
	}

}
