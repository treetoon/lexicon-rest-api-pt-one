package com.al.restapi.base.controller.mvc;

import com.al.restapi.base.service.film.FilmNotFoundException;
import com.al.restapi.base.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    private FilmService filmService;

    @Autowired
    public MvcController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping({"/", "/index"})
    public String getIndex(Model m){
        return "index";
    }

    @RequestMapping("/film")
    public String getTest(Model m) {
        try {
            m.addAttribute("filmList", filmService.findFilms());
        } catch (FilmNotFoundException e) {
            e.printStackTrace();
        }
        return "film";
    }
}
