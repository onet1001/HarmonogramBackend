package pl.onak.d.planner.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {

    private String errorMessage;
    private HttpStatus errorStatus;
}
