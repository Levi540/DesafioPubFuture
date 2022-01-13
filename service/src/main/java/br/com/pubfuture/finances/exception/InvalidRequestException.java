package br.com.pubfuture.finances.exception;

import br.com.pubfuture.finances.validator.ValidationErrors;

public class InvalidRequestException extends RuntimeException {
    private final ValidationErrors validationErrors;

    public InvalidRequestException(ValidationErrors validationErrors) {
        super(validationErrors.toString());
        this.validationErrors = validationErrors;
    }

    public ValidationErrors getValidationErrors() {
        return validationErrors;
    }
}
