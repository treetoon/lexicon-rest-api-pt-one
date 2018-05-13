package com.al.restapi.base.controller.rest;

public class ErrorInformation {
    private String message;
    private String uri;

    public ErrorInformation()
    {
    }

    public ErrorInformation(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
