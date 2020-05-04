package in.projecteka.uos.clients;

import in.projecteka.uos.clients.model.Session;
import in.projecteka.uos.clients.properties.IdentityServiceProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class IdentityServiceClient {
    private final WebClient.Builder webClientBuilder;

    public IdentityServiceClient(WebClient.Builder webClientBuilder,
                                 IdentityServiceProperties identityServiceProperties) {
        this.webClientBuilder = webClientBuilder;
        this.webClientBuilder.baseUrl(identityServiceProperties.getBaseUrl());
    }

    public Mono<Session> getToken(MultiValueMap<String, String> formData) {
        return webClientBuilder.build()
                .post()
                .uri(uriBuilder ->
                        uriBuilder.path("/realms/Uos-manager/protocol/openid-connect/token").build())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> Mono.error(ClientError.networkServiceCallFailed()))
                .bodyToMono(Session.class);
    }
}
