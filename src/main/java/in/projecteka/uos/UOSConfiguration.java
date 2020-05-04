package in.projecteka.uos;

import in.projecteka.uos.clients.IdentityServiceClient;
import in.projecteka.uos.clients.properties.IdentityServiceProperties;
import in.projecteka.uos.user.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UOSConfiguration {

    @Bean
    public TokenService tokenService(IdentityServiceProperties identityServiceProperties,
                                     IdentityServiceClient identityServiceClient) {
        return new TokenService(identityServiceProperties, identityServiceClient);
    }
}
