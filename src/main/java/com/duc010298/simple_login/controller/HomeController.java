package com.duc010298.simple_login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/login")
    public String admin() {
        return "login";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

}
