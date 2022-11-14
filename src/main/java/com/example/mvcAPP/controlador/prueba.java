package com.example.mvcAPP.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class prueba {
    @GetMapping("/saludar")
    public String saluda(){return "holissss";}
}
