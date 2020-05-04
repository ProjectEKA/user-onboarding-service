package in.projecteka.uos;

import in.projecteka.uos.clients.properties.IdentityServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({UOSProperties.class,
								IdentityServiceProperties.class})
public class UOSApplication {

	public static void main(String[] args) {
		SpringApplication.run(UOSApplication.class, args);
	}
}