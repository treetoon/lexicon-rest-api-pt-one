package com.al.restapi.base.repository;

import com.al.restapi.base.model.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository  extends JpaRepository<LoanEntity, Long> {
    //spring populates custom made functions automagically
    //docs.spring.io/autorepo/docs/spring-data-jpa/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository


}
