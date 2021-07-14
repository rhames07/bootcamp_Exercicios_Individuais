package br.com.meli.obterdiploma.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super("Erro: " + message);
    }
}
