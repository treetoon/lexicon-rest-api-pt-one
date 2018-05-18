package com.al.restapi.base.service.loan;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.model.LoanEntity;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    List<LoanEntity> findLoans() throws LoanNotFoundException;
    Optional<LoanEntity> findLoanById(Long id) throws LoanNotFoundException;
    Optional<LoanEntity> createLoan(Long memberId, List<FilmEntity> filmList) throws Exception;
}
