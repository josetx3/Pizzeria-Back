package com.jose.pizza.service.exception;

public class EmailApiException extends RuntimeException{
    public EmailApiException(){
        super("Error al enviar el email");
    }
}
