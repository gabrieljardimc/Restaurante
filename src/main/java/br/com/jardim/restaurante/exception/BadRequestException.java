package br.com.jardim.restaurante.exception;

public class BadRequestException extends Exception{

    public BadRequestException(String message) {
        super(message);
    }

}
