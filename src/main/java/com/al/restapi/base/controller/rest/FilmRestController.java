package com.al.restapi.base.controller.rest;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest-api")
public class FilmRestController {

    private FilmService filmService;

    @Autowired
    public FilmRestController(FilmService filmService) {
        this.filmService = filmService;
    }

    /**
     * GET /film
     * Returns a list of all objects found in the search
     * If no arguments are added, it returns all
     * @param title film title
     * @param genre film genre
     * @return list of film objects from the db
     */
    @GetMapping("/film")
    public List<FilmEntity> findFilms(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String genre){
        return filmService.findFilms(title, genre);
    }

    /**
     * GET /film/{id}
     * Returns one film object
     * @param id id number of film object
     * @return film object from the db of the specified id
     */
    @GetMapping("/film/{id}")
    public Optional<FilmEntity> findFilmById(@PathVariable Long id){
        return filmService.findFilmById(id);
    }

    /**
     * POST /film adds a list of objects
     * @param filmEntity list of film objects to be added to the db
     * @return list of film objects that were added
     */
    @PostMapping("/film")
    public List<FilmEntity> saveFilm(@Valid @RequestBody List<FilmEntity> filmEntity){
        return filmService.saveFilm(filmEntity);
    }


    //@PutMapping



    //update
    //delete
}
