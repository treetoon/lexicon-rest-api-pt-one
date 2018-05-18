package com.al.restapi.base.controller.rest;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.service.loan.LoanNotFoundException;
import com.al.restapi.base.service.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class LoanRestController {

    private LoanService loanService;

    @Autowired
    public LoanRestController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loan")
    public ResponseEntity findLoans() throws LoanNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanService.findLoans());
    }

    @GetMapping("/loan/{id}")
    public ResponseEntity findLoanById(@PathVariable Long id) throws LoanNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanService.findLoanById(id));
    }

    @PostMapping("/loan/member/{id}")
    @Transactional
    public ResponseEntity createLoan(@Valid @PathVariable("id") Long memberId,
                                     @Valid @RequestBody List<FilmEntity> filmList) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(loanService.createLoan(memberId, filmList));
    }
}
