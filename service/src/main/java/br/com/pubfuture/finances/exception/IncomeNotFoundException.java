package br.com.pubfuture.finances.exception;

public class IncomeNotFoundException extends RuntimeException {

    public IncomeNotFoundException(String message) {
        super(message);
    }
}
