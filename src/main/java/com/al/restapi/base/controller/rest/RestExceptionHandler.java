package com.al.restapi.base.controller.rest;

import com.al.restapi.base.service.film.FilmNotFoundException;
import com.al.restapi.base.service.member.MemberNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { FilmNotFoundException.class, MemberNotFoundException.class })
    protected ResponseEntity itemNotFoundExceptionHandler(Exception e, WebRequest request) {
        String bodyOfResponse = e.getMessage();

        return handleExceptionInternal(e, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
