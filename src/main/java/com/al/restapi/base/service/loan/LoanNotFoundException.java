package com.al.restapi.base.service.loan;

public class LoanNotFoundException extends Exception {
    public LoanNotFoundException()
    {
    }

    public LoanNotFoundException(String message) {
        super(message);
    }

    public LoanNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoanNotFoundException(Throwable cause) {
        super(cause);
    }
}
