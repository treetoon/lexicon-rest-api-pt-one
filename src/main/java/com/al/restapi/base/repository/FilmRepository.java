package com.al.restapi.base.repository;

import com.al.restapi.base.model.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
//jpql or default db methods
}
