package com.al.restapi.base.service.film;

import com.al.restapi.base.model.FilmEntity;

import java.util.List;

public interface FilmService {
    List<FilmEntity> getAllFilms();
}
