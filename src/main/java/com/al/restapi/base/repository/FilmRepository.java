package com.al.restapi.base.repository;

import com.al.restapi.base.model.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long>
{
    //spring populates custom made functions automagically
    //docs.spring.io/autorepo/docs/spring-data-jpa/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository

    List<FilmEntity> findByTitle(String title);
    List<FilmEntity> findByGenre(String genre);
    List<FilmEntity> findByTitleAndGenre(String title, String genre);
}
