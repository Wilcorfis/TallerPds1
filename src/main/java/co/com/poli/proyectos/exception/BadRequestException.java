package co.com.poli.proyectos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
        reason = "Error de validación de parámetros")
public class BadRequestException extends RuntimeException {
   
}