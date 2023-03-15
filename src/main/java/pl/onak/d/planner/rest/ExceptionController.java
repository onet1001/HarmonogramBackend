package pl.onak.d.planner.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.onak.d.planner.dto.ErrorResponse;
import pl.onak.d.planner.exeption.UserExistsException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({UserExistsException.class})
    public ResponseEntity<ErrorResponse> userExistsException(UserExistsException exception) {
        return new ResponseEntity<ErrorResponse>(ErrorResponse.builder()
                .errorMessage(exception.getMessage())
                .errorStatus(HttpStatus.BAD_REQUEST)
                .build(), HttpStatus.BAD_REQUEST);
         }
}
