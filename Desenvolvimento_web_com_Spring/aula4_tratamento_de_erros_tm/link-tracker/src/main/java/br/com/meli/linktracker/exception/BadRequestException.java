package br.com.meli.linktracker.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Exception e){
        super(e.getMessage());
    }
}
