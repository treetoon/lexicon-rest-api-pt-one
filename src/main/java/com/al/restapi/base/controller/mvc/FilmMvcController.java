package com.al.restapi.base.controller.mvc;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.service.film.FilmNotFoundException;
import com.al.restapi.base.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FilmMvcController {
    private FilmService filmService;

    @Autowired
    public FilmMvcController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping({"/", "/index"})
    public String getIndex(Model m){
        return "index";
    }

    @GetMapping("/film")
    public String getFilm(Model model) {
        try {
            model.addAttribute("filmList", filmService.findFilms());
        } catch (FilmNotFoundException e) {
            model.addAttribute("Error: ", e.getMessage());
            return "pages/film/film";
        }
        return "pages/film/film";
    }

    @DeleteMapping("/film")
    public String deleteFilm(Model model, @RequestParam Long id) {
        try {
            filmService.deleteFilmById(id);
            model.addAttribute("filmList", filmService.findFilms());
        } catch (FilmNotFoundException e) {
            model.addAttribute("Error: ", e.getMessage());
            return "pages/film/film";
        }
        return "pages/film/film";
    }

    @PostMapping("/film-add")
    public String addFilm(Model model, @RequestParam Long id) {
        try {
            model.addAttribute("film", filmService.findFilmById(id));
        } catch (FilmNotFoundException e) {
            model.addAttribute("Error: ", e.getMessage());
            return "pages/film/film-add";
        }
        return "pages/film/film-add";
    }

//    @PostMapping("/film-add")
//    public String postFilmAdd(Model m, FilmEntity film) {
//        System.out.println(film.getTitle());
//        return "pages/film/film-add";
//    }
}
