package br.com.meli.linktracker.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Exception e){
        super(e.getMessage());
    }
}
