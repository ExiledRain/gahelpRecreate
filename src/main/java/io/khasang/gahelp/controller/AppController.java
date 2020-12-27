package io.khasang.gahelp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/")
    public String getStatus() {
        return "status";
    }

    @RequestMapping("/hello/{name}")
    public String getHelloPage(@PathVariable("name")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
