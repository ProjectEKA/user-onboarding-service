package in.projecteka.uos.user.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SessionRequest {
    GrantType grantType;

    String username;

    String password;
}
