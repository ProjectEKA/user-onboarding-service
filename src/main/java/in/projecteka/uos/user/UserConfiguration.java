package in.projecteka.uos.user;

import in.projecteka.uos.clients.IdentityServiceClient;
import in.projecteka.uos.clients.properties.IdentityServiceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UserConfiguration {
    @Bean
    public IdentityServiceClient keycloakClient(WebClient.Builder builder,
                                                IdentityServiceProperties identityServiceProperties) {
        return new IdentityServiceClient(builder, identityServiceProperties);
    }
    
    @Bean
    public SessionService sessionService(TokenService tokenService) {
        return new SessionService(tokenService);
    }
}
