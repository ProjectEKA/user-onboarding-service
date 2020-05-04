package in.projecteka.uos.user;

import in.projecteka.uos.clients.ClientError;
import in.projecteka.uos.clients.model.Session;
import in.projecteka.uos.user.model.SessionRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class SessionService {
    private final TokenService tokenService;
    private final Logger logger = LoggerFactory.getLogger(SessionService.class);

    public Mono<Session> forNew(SessionRequest request) {
        if (StringUtils.isEmpty(request.getUsername()) || StringUtils.isEmpty(request.getPassword()))
            return Mono.error(ClientError.unAuthorizedRequest());
        return tokenService.tokenForUser(request.getUsername(), request.getPassword())
                .doOnError(error -> logger.error(error.getMessage(), error))
                .onErrorResume(error -> Mono.error(ClientError.unAuthorizedRequest()));
    }
}
