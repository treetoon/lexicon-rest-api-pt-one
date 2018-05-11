package com.al.restapi.base.controller.rest;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    //TODO return Optional<?>?
    //TODO HttpEntity<?> or annotation: return status
    //TODO Pagination?
    //TODO error handling

    /**
     * GET /film
     * Returns a list of all objects found in the search
     * If no arguments are added, it returns all
     * @param title film title
     * @param genre film genre
     * @return list of film objects from the db
     */
//    @GetMapping("/film")
//    public List<FilmEntity> findFilms(@RequestParam(required = false) String title,
//                                      @RequestParam(required = false) String genre){
//        return filmService.findFilms(title, genre);
//    }
    @GetMapping("/film")
    public ResponseEntity<List<FilmEntity>> findFilms(@RequestParam(required = false) String title,
                                                      @RequestParam(required = false) String genre){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");

        return new ResponseEntity<>(filmService.findFilms(title, genre),
                                    responseHeaders,
                                    HttpStatus.ACCEPTED);
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

    /**
     * PUT /film/{id}
     * Updates one film object based on specified id
     * @param id id number of film object
     * @param newFilm supplied film object used to update the db
     * @return updated film object from the db of the specified id
     */
    @PutMapping("film/{id}")
    public Optional<FilmEntity> updateFilmById(@PathVariable Long id,
                                               @RequestBody FilmEntity newFilm){
        return filmService.updateFilmById(id, newFilm);
    }

    /**
     * DELETE /film/{id}
     * Deletes one film object based on specified id
     * @param id id number of film object
     * @return ?
     */
    @DeleteMapping("/film/{id}")
    public ResponseEntity<?> deleteFilmById(@PathVariable Long id){
        filmService.deleteFilmById(id);
        return ResponseEntity.ok().build();
    }
}
