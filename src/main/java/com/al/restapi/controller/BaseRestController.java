package com.al.restapi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class BaseRestController {

    @GetMapping("/greeting/{x}")
    public List<String> func(@RequestParam(value="namn", defaultValue="World") String name,
                             @PathVariable("x") int i){
        List<String> str = new ArrayList<>();
        str.add("asd");
        str.add("asd2");
        str.add(name);

        System.out.println(i);

        return str;
    }

    @PostMapping("/greeting")
    public String func2(@RequestParam(value="namn", defaultValue="World") String name){
        return "Hello2" + " : " + name;
    }
}
