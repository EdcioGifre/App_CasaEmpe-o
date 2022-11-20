package com.example.mvcAPP.controlador;

import com.example.mvcAPP.servicio.ClienteServicio;
import com.example.mvcAPP.servicio.ProductoEmpenoServicio;
import com.example.mvcAPP.servicio.ProductoVentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControl {

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    ProductoEmpenoServicio productoEmpenoServicio;

    @Autowired
    ProductoVentaServicio productoVentaServicio;
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

    @GetMapping("/listaProductosEmpeno")
    public String paginaListaProductosEmpeno(Model modelo){
        modelo.addAttribute("productosEmpeno", productoEmpenoServicio.allProductosEmpeno());
        return "listaProductosEmpeno";
    }

    @GetMapping("/listaProductosVenta")
    public String paginaListaProductosVenta(Model modelo){
        modelo.addAttribute("productosVenta", productoVentaServicio.allProductosVenta());
        return "listaProductosVenta";
    }
}