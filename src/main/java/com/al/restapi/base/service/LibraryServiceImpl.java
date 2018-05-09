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

    @Autowired
    public LibraryServiceImpl(FilmService filmService) {
        this.filmService = filmService;
    }

    public List<FilmEntity> findAllFilms(){
        return filmService.findAllFilms();
    }

    public FilmEntity saveFilm(FilmEntity filmEntity){
        return filmService.saveFilm(filmEntity);
    }
}
