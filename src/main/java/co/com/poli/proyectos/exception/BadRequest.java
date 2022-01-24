package co.com.poli.proyectos.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BadRequest extends RuntimeException {




    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Map<String,Object> showCustomMessage(Exception e){


        Map<String,Object> response = new HashMap<>();
        response.put("status","Your input is invalid");

        return response;
    }
}