package co.com.poli.proyectos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "bad request 400")
public class BadRequest extends Exception {
    public BadRequest(String errorMessage) {
        super(errorMessage);
    }



}