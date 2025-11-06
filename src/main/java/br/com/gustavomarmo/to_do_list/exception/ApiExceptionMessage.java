package br.com.gustavomarmo.to_do_list.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiExceptionMessage {
    private HttpStatus status;
    private String message;

    public ApiExceptionMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
