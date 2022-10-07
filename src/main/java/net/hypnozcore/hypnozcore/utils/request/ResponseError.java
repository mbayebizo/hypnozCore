package net.hypnozcore.hypnozcore.utils.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {
    HttpStatus httpStatus;
    Integer statusCode;
    String errorMessage;
    public static ResponseError getResponseError(HttpStatus status, int statusCode, String errorMessage) {
        ResponseError error = new ResponseError();
        error.httpStatus = status;
        error.statusCode=statusCode;
        error.errorMessage= errorMessage;
        return error;
    }

}
