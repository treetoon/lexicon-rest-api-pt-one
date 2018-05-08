package com.al.restapi.base.controller;

import com.al.restapi.base.data.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class BaseRestController {

    @Autowired
    FilmRepository repo;

    @GetMapping("/g")
    public int func(){
        return 123456;
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
