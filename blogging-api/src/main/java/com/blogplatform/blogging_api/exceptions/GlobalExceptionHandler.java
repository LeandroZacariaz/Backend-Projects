package com.blogplatform.blogging_api.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.blogplatform.blogging_api.dto.errors.ErrorDtoNotFound;
import com.blogplatform.blogging_api.dto.errors.ErrorGenericDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorGenericDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        var errorList = ex.getFieldErrors().stream()
                        .map(fieldError -> {
                            Map<String, String> errorMap = new HashMap<>();
                            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                            return errorMap; }
                            ).toList();

        ErrorGenericDto errorsDto = new ErrorGenericDto("One or more fields are incorrect.", errorList);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorsDto);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDtoNotFound> handleNotFoundException (ResourceNotFoundException ex, WebRequest webRequest){
        ErrorDtoNotFound errorDtoNotFound = new ErrorDtoNotFound(webRequest.getDescription(false)
                                                                , ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDtoNotFound);
    }
}
