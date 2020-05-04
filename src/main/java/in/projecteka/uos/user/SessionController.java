package in.projecteka.uos.user;

import in.projecteka.uos.clients.model.Session;
import in.projecteka.uos.user.model.SessionRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class SessionController {
    private final SessionService sessionService;

    @PostMapping("/sessions")
    public Mono<Session> forNew(@RequestBody SessionRequest sessionRequest) {
        return sessionService.forNew(sessionRequest);
    }
}
