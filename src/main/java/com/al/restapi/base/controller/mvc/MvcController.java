package com.al.restapi.base.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcController {
    @RequestMapping({"/", "default"})
    public String getIndex(ModelAndView mv){
        return "default";
    }

    @RequestMapping("test")
    public String getTest(ModelAndView mv){
        return "test";
    }
}
