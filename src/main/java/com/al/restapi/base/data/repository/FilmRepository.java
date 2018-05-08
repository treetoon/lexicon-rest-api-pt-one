package com.al.restapi.base.data.repository;

import com.al.restapi.base.data.model.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
//jpql or default db methods
}
