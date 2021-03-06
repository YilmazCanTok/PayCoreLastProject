package patika.paycorelastproject.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map> exception(NotFoundException exception) {
        // You can define any other class for better visualization for response
        Map<String, String> response = new HashMap<>();
        response.put("cause", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}