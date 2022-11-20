package com.example.mvcAPP.controlador;

import com.example.mvcAPP.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControl {

    @Autowired
    ClienteServicio clienteServicio;
    @GetMapping("/saludar")
    public String saluda(){return "holiss!!";}

    @GetMapping
    public String iniciar(){
        return "listaClientes";
    }

    @GetMapping("/listaClientes")
    public String paginaListaClientes(Model modelo){
        modelo.addAttribute("clientes", clienteServicio.allClientes());
        return "listaClientes";
    }
}