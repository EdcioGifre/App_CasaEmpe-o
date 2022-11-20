package com.example.mvcAPP.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControl {
    @GetMapping("/saludar")
    public String saluda(){return "holiss!!";}

    @GetMapping
    public String iniciar(){
        return "listaClientes";
    }

    @GetMapping("/listaClientes")
    public String iniciarI(){
        return "listaClientes";
    }


}