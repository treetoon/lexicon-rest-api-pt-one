package com.al.restapi.base.repository;

import com.al.restapi.base.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository  extends JpaRepository<MemberEntity, Long> {
    //spring populates custom made functions automagically
    //docs.spring.io/autorepo/docs/spring-data-jpa/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository

    List<MemberEntity> findByName(String name);
}
