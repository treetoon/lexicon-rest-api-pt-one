package com.al.restapi.base.service.film;

public class FilmNotFoundException extends Exception {
    public FilmNotFoundException(String message) {
        super(message);
    }

    public FilmNotFoundException(Throwable cause) {
        super(cause);
    }

    public FilmNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
