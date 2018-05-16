package com.al.restapi.base.controller.rest;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.service.film.FilmService;
import com.al.restapi.base.service.film.FilmNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class FilmRestController {

    private FilmService filmService;

    @Autowired
    public FilmRestController(FilmService filmService) {
        this.filmService = filmService;
    }

    //TODO Pagination?

    /**
     * GET /film
     * Returns a list of all objects found in the search
     * If no arguments are added, it returns all
     * @param title film title
     * @param genre film genre
     * @return list of film objects from the db
     */
    @GetMapping("/film")
    public ResponseEntity findFilms(@RequestParam(required = false) String title,
                                    @RequestParam(required = false) String genre) throws FilmNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        //headers.set("MyResponseHeader", "MyValue");

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(filmService.findFilms(title, genre));
    }

    /**
     * GET /film/{id}
     * Returns one film object
     * @param id id number of film object
     * @return film object from the db of the specified id
     */
    @GetMapping("/film/{id}")
    public ResponseEntity findFilmById(@PathVariable Long id) throws FilmNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(filmService.findFilmById(id));
    }

    /**
     * POST /film adds a list of objects
     * @param filmEntity list of film objects to be added to the db
     * @return list of film objects that were added
     */
    @PostMapping("/film")
    @Transactional
    public ResponseEntity saveFilm(@Valid @RequestBody List<FilmEntity> filmEntity) throws FilmNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(filmService.saveFilm(filmEntity));
    }

    /**
     * PUT /film/{id}
     * Updates one film object based on specified id
     * @param id id number of film object
     * @param newFilm supplied film object used to update the db
     * @return updated film object from the db of the specified id
     */
    @PutMapping("film/{id}")
    @Transactional
    public ResponseEntity updateFilmById(@PathVariable Long id,
                                         @Valid @RequestBody FilmEntity newFilm) throws FilmNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(filmService.updateFilmById(id, newFilm));
    }

    /**
     * DELETE /film/{id}
     * Deletes one film object based on specified id
     * @param id id number of film object
     * @return ?
     */
    @DeleteMapping("/film/{id}")
    @Transactional
    public ResponseEntity deleteFilmById(@PathVariable Long id) {
        filmService.deleteFilmById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
