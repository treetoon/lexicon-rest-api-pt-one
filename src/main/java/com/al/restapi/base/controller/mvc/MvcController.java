package com.al.restapi.base.controller.mvc;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.service.film.FilmNotFoundException;
import com.al.restapi.base.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MvcController {
    private FilmService filmService;

    @Autowired
    public MvcController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping({"/", "/index"})
    public String getIndex(Model m){
        return "index";
    }

    @GetMapping("/film")
    public String getFilm(Model m) {
        return "pages/film/film";
    }

    @GetMapping("/film/add")
    public String getFilmAdd(Model m) {
        try {
            m.addAttribute("filmList", filmService.findFilms());
        } catch (FilmNotFoundException e) {} //dw
        return "pages/film/film-add";
    }

    @PostMapping("/film/add")
    public String postFilmAdd(Model m, FilmEntity film) {
        System.out.println(film.getTitle());
        return "pages/film/film-add";
    }

    @GetMapping("/film/list")
    public String getFilmList(Model m) {
        try {
            m.addAttribute("filmList", filmService.findFilms());
        } catch (FilmNotFoundException e) {} //dw
        return "pages/film/film-list";
    }

    @DeleteMapping("/film/list")
    public String deleteFilm(Model m) {

        return "pages/film/film-list";
    }
}
