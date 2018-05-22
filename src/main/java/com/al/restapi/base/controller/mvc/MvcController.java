package com.al.restapi.base.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    @RequestMapping({"/", "index"})
    public String getIndex(){
        return "index";
    }
}
