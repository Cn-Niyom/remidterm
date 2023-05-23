package sit.remidterm.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
//        errorResponse.addValidationError("file", ex.getMessage());
//        errorResponse.addValidationError("file", request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IncorrectPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> handleIncorrectPasswordException(IncorrectPasswordException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), request.getDescription(false));
        errorResponse.addValidationError("Error", ex.getMessage());
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
////        errorResponse.addValidationError("file", ex.getMessage());
////        errorResponse.addValidationError("file", request.getDescription(false));
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }






//    @ExceptionHandler(FileNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<ErrorResponse> handleFileNotFound(FileNotFoundException ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
//        errorResponse.addValidationError("file", ex.getMessage());
//        errorResponse.addValidationError("file", request.getDescription(false));
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(NullPointerException.class)
////    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
//        errorResponse.addValidationError("file", ex.getMessage());
//        errorResponse.addValidationError("file", request.getDescription(false));
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity<ErrorResponse> handleNumberFormatException(NumberFormatException ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
//        errorResponse.addValidationError("file", ex.getMessage());
//        errorResponse.addValidationError("file", request.getDescription(false));
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
}
