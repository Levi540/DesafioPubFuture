package br.com.pubfuture.finances.config;

import br.com.pubfuture.finances.api.model.ResponseError;
import br.com.pubfuture.finances.exception.ExpenseNotFoundException;
import br.com.pubfuture.finances.exception.IncomeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({ IncomeNotFoundException.class })
    public ResponseEntity<Object> HandleNotFoundException(Exception exception) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, exception);
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, Exception exception) {
        return new ResponseEntity<>(
            new ResponseError().status(httpStatus.getReasonPhrase()).code(httpStatus.value()).message(exception.getMessage()),
            httpStatus
        );
    }
}
