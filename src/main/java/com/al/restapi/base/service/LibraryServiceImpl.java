package com.al.restapi.base.service;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.repository.FilmRepository;
import com.al.restapi.base.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private FilmService filmService;
    private FilmRepository filmRepository;

    @Autowired
    public LibraryServiceImpl(FilmService filmService, FilmRepository filmRepository) {
        this.filmService = filmService;
        this.filmRepository = filmRepository;
    }

    public List<FilmEntity> getAllFilms(){
        return filmService.getAllFilms();
    }
}
