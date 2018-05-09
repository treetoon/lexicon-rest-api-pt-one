package com.al.restapi.base.controller.rest;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class FilmRestController {

    private LibraryService lib;

    @Autowired
    public FilmRestController(LibraryService lib) {
        this.lib = lib;
    }

    @GetMapping("/film")
    public List<FilmEntity> getAllFilms(){
        return lib.findAllFilms();
    }

    @PostMapping("/film")
    public FilmEntity saveFilm(@Valid @RequestBody FilmEntity filmEntity){
        return lib.saveFilm(filmEntity);
    }





    //test

    @GetMapping("/g/{x}")
    public String func(@RequestParam(value="namn", defaultValue="World") String name,
                                                            @PathVariable("x") int i){
        return "123";
    }
}
