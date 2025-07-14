package lk.ijse.edu.back_end.exceptions;

import lk.ijse.edu.back_end.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> handleGenericException(Exception e) {
        return new ResponseEntity<>(new APIResponse<>(500, e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
