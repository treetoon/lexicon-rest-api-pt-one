package com.al.restapi.base.service.film;

import com.al.restapi.base.model.FilmEntity;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<FilmEntity> findFilms(String title, String genre) throws FilmNotFoundException;
    Optional<FilmEntity> findFilmById(Long id);

    List<FilmEntity> saveFilm(List<FilmEntity> filmEntity);
    void deleteFilmById(Long id);
    Optional<FilmEntity> updateFilmById(Long id, FilmEntity newFilm);
}
