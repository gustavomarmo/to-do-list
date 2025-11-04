package br.com.gustavomarmo.to_do_list.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiErrorMessage {
    private HttpStatus status;
    private String message;

    public ApiErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


}
