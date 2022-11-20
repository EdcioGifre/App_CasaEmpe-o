package com.example.mvcAPP.controlador;

import com.example.mvcAPP.modelo.Cliente;
import com.example.mvcAPP.modelo.ProductoVenta;
import com.example.mvcAPP.servicio.ClienteServicio;
import com.example.mvcAPP.servicio.ProductoVentaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/registroProductoVenta")
public class ProductoVentaControl {

    @Autowired
    ProductoVentaServicio productoVentaServicio;

    @ModelAttribute("productoVenta")
    public ProductoVenta guardarProductoVenta() {
        return new ProductoVenta();
    }

    @PostMapping
    private String addProductoVenta (@ModelAttribute("productoVenta") ProductoVenta productoVenta){
        if(productoVentaServicio.createProductoVenta(productoVenta)){
            return "redirect:/registroProductoVenta?exito";
        }
        return "redirect:/registroProductoVenta?error";
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registroProductoVenta";
    }
}