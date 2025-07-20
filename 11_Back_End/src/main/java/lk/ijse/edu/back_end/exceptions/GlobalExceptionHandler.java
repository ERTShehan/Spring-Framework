package lk.ijse.edu.back_end.exceptions;

import lk.ijse.edu.back_end.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> handleGenericException(Exception e) {
        return new ResponseEntity<>(new APIResponse<>(500, "Internal Server Error Occurred", null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<APIResponse<String>>
    handleResourceNotFound(ResourceNotFound ex){
        return new ResponseEntity<>(new APIResponse<>(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null
        ),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return new ResponseEntity<>(new APIResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                "validation faild",
                errors
        ),HttpStatus.BAD_REQUEST);
    }
}
