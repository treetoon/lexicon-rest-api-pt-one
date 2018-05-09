package com.al.restapi.base.service;

import com.al.restapi.base.model.FilmEntity;

import java.util.List;

public interface LibraryService {

    List<FilmEntity> getAllFilms();
}
