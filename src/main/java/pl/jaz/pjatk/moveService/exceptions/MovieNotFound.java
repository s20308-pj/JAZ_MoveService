package pl.jaz.pjatk.moveService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieNotFound extends RuntimeException{
    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<Object> handlerRuntimeException(MovieNotFound ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
