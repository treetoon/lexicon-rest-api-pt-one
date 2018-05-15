package com.al.restapi.base.repository;

import com.al.restapi.base.model.MemberEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {
    //spring populates custom made functions automagically
    //docs.spring.io/autorepo/docs/spring-data-jpa/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository

    List<MemberEntity> findByTitle(String title);
    List<MemberEntity> findByGenre(String genre);
    List<MemberEntity> findByTitleAndGenre(String title, String genre);
}
