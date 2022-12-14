package com.example.mvcAPP.controlador;

import com.example.mvcAPP.modelo.Cliente;
import com.example.mvcAPP.servicio.ClienteServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/registroCliente")
public class ClienteControl {

    @Autowired
    ClienteServicio clienteServicio;

    @ModelAttribute("cliente")
    public Cliente guardarCliente() {
        return new Cliente();
    }

    @PostMapping
    private String addCliente (@ModelAttribute("cliente") Cliente cliente){
        if(clienteServicio.createCliente(cliente)){
            return "redirect:/registroCliente?exito";
        }
        return "redirect:/registroCliente?error";
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registroCliente";
    }
}