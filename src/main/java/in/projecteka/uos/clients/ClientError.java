package in.projecteka.uos.clients;

import in.projecteka.uos.Error;
import in.projecteka.uos.ErrorRepresentation;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import static in.projecteka.uos.ErrorCode.NETWORK_SERVICE_ERROR;
import static in.projecteka.uos.ErrorCode.USERNAME_OR_PASSWORD_INCORRECT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Getter
@ToString
public class ClientError extends Throwable  {
    private static final String CANNOT_PROCESS_REQUEST_TRY_LATER = "Cannot process the request at the moment, please try later.";
    private final HttpStatus httpStatus;
    private final ErrorRepresentation error;

    public ClientError(HttpStatus httpStatus, ErrorRepresentation errorRepresentation) {
        this.httpStatus = httpStatus;
        error = errorRepresentation;
    }

    public static ClientError unAuthorizedRequest() {
        return new ClientError(UNAUTHORIZED,
                new ErrorRepresentation(new Error(USERNAME_OR_PASSWORD_INCORRECT,
                        "Username or password is incorrect")));
    }

    public static ClientError networkServiceCallFailed() {
        return new ClientError(INTERNAL_SERVER_ERROR,
                new ErrorRepresentation(new Error(NETWORK_SERVICE_ERROR, CANNOT_PROCESS_REQUEST_TRY_LATER)));
    }
}
