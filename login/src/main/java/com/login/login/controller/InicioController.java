package com.login.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

    @GetMapping("/inicio")
    public String iniciarSesion() {
        return "inicio";
    }


}
