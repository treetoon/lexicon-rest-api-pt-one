package com.al.restapi.base.service;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {
    private FilmService filmService;

    @Autowired
    public LibraryServiceImpl(FilmService filmService) {
        this.filmService = filmService;
    }

    /*
    @Override
    public List<FilmEntity> findFilms(){
        return filmService.findFilms();
    }

    @Override
    public List<FilmEntity> saveFilm(List<FilmEntity> filmEntity){
        return filmService.saveFilm(filmEntity);
    }

    @Override
    public Optional<FilmEntity> findFilmById(Long id) {
        return filmService.findFilmById(id);
    }

    @Override
    public List<FilmEntity> findFilmBySearch(String title) {
        return filmService.findFilmBySearch();
    }
    */
}
