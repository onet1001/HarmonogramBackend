package pl.onak.d.planner.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.onak.d.planner.exeption.UserExistsException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({UserExistsException.class})
    public ResponseEntity<Object> handleException(UserExistsException exception){
        return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.BAD_REQUEST,exception.getCause());
    }

}
