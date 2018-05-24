package com.al.restapi.base.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    @RequestMapping({"/", "index"})
    public String getIndex(Model m){
        return "index";
    }

    @RequestMapping("test")
    public String getTest(Model m){
        return "test";
    }
}
