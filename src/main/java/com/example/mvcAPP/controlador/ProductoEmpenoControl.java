package com.example.mvcAPP.controlador;

import com.example.mvcAPP.modelo.ProductoEmpeno;
import com.example.mvcAPP.servicio.ProductoEmpenoServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/registroProductoEmpeno")
public class ProductoEmpenoControl {

    @Autowired
    ProductoEmpenoServicio productoEmpenoServicio;

    @ModelAttribute("productoEmpeno")
    public ProductoEmpeno guardarProductoEmpeno() {
        return new ProductoEmpeno();
    }

    @PostMapping
    private String addProductoEmpeno (@ModelAttribute("productoEmpeno") ProductoEmpeno productoEmpeno){
        if(productoEmpenoServicio.createProductoEmpeno(productoEmpeno)){
            return "redirect:/registroProductoEmpeno?exito";
        }
        return "redirect:/registroProductoEmpeno?error";
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registroProductoEmpeno";
    }
}