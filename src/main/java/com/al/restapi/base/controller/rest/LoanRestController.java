package com.al.restapi.base.controller.rest;

import com.al.restapi.base.model.LoanEntity;
import com.al.restapi.base.service.loan.LoanNotFoundException;
import com.al.restapi.base.service.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LoanRestController {

    private LoanService loanService;

    @Autowired
    public LoanRestController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loan")
    @Transactional
    public ResponseEntity saveLoan(@Valid @RequestBody List<LoanEntity> loanEntity) throws LoanNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(loanService.saveLoan(loanEntity));
    }
}
