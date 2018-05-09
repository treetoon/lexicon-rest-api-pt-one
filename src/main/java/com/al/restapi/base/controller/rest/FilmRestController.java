package com.al.restapi.base.controller.rest;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.repository.FilmRepository;
import com.al.restapi.base.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class FilmRestController {

    private LibraryService lib;

    @Autowired
    public FilmRestController(LibraryService lib) {
        this.lib = lib;
    }

    @GetMapping
    public List<FilmEntity> getAllFilms(){
        return lib.getAllFilms();
    }






    @GetMapping("/g/{x}")
    public List<String> func(@RequestParam(value="namn", defaultValue="World") String name,
                             @PathVariable("x") int i){
        List<String> str = new ArrayList<>();
        str.add("asd");
        str.add("asd2");
        str.add(name);

        System.out.println(i);

        return str;
    }

    @PostMapping("/g")
    public String func2(@RequestParam(value="namn", defaultValue="World") String name){
        return "Hello2" + " : " + name;
    }
}
