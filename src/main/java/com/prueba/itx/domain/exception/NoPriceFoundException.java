package com.prueba.itx.domain.exception;

public class NoPriceFoundException extends RuntimeException {

    public NoPriceFoundException() {
        super();
    }

    public NoPriceFoundException(String message) {
        super(message);
    }
    
}