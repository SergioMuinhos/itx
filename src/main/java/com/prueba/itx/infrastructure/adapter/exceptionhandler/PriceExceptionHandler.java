package com.prueba.itx.infrastructure.adapter.exceptionhandler;

import com.prueba.itx.domain.exception.NoPriceFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PriceExceptionHandler {

    @ExceptionHandler(NoPriceFoundException.class)
    public ResponseEntity<Object> handlerNoPriceFoundException() {
        return new ResponseEntity<>("No se ha encontrado ningun precio para los datos introducidos", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerException() {
        return new ResponseEntity<>("Ha ocurrido un error", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
