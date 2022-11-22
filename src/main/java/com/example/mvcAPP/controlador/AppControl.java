package com.example.mvcAPP.controlador;

import com.example.mvcAPP.modelo.Cliente;
import com.example.mvcAPP.modelo.ProductoEmpeno;
import com.example.mvcAPP.modelo.ProductoVenta;
import com.example.mvcAPP.servicio.ClienteServicio;
import com.example.mvcAPP.servicio.ProductoEmpenoServicio;
import com.example.mvcAPP.servicio.ProductoVentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //////////////////////////////////////////////////////////////
    ///////////////////////////////////////CLIENTE
    //////////////////////////////////////////////////////////////
    @GetMapping("/listaClientes")
    public String paginaListaClientes(Model modelo){
        modelo.addAttribute("clientes", clienteServicio.allClientes());
        return "listaClientes";
    }

    /*@PostMapping("/listaClientes")
    public String guardarListaClientes(@ModelAttribute("cliente") Cliente cliente){
        if(clienteServicio.modifyCliente(cliente)){
            return "redirect:/listaClientes/modificarCliente/{cedula}?exito}";
        }
        return "redirect:/listaClientes/modificarCliente/{cedula}?error}";
    }

    ///@GetMapping("/listaClientes/modificar/{cedula}")
    @GetMapping("/listaClientes/modificarCliente/{cedula}")
    public String paginaFormularioDeModificar(@PathVariable Long cedula, Model modelo){
        modelo.addAttribute("cliente",clienteServicio.findByIdCliente(cedula));
        return "modificarCliente";
    }

    //@PostMapping("/listaClientes/{cedula}")
    @PutMapping("/listaClientes/{cedula}")
    public String actualizarListaClientes(@PathVariable Long cedula, @ModelAttribute("cliente") Cliente cliente, Model modelo){
        Cliente cliente1 = clienteServicio.findByIdCliente(cedula);
        if(clienteServicio.modifyCliente(cliente1)){
            cliente1.setCedula(cedula);
            cliente1.setNombre(cliente.getNombre());
            cliente1.setApellido(cliente.getApellido());
            cliente1.setTelefono(cliente.getTelefono());
            return "redirect:/listaClientes/modificarCliente/{cedula}?exito}";
        }
        return "redirect:/listaClientes/modificarCliente/{cedula}?error}";
        //return "redirect:/listaClientes";
    }*/

    @GetMapping("/listaClientes/{cedula}")
    public String eliminarCliente(@PathVariable Long cedula){
        Cliente cliente1 = clienteServicio.findByIdCliente(cedula);
        clienteServicio.deleteCliente(cliente1);
        return "redirect:/listaClientes";
    }

    //////////////////////////////////////////////////////////////
    ///////////////////////////////////////PRODUCTO EMPEÑO
    //////////////////////////////////////////////////////////////
    @Autowired
    ProductoEmpenoServicio productoEmpenoServicio;

    @GetMapping("/listaProductosEmpeno")
    public String paginaListaProductosEmpeno(Model modelo){
        modelo.addAttribute("productosEmpeno", productoEmpenoServicio.allProductosEmpeno());
        return "listaProductosEmpeno";
    }

    @GetMapping("/listaProductosEmpeno/{codigo}")
    public String eliminarProductoEmpeno(@PathVariable int codigo){
        ProductoEmpeno productoEmpeno = productoEmpenoServicio.findByIdProductoEmpeno(codigo);
        productoEmpenoServicio.deleteProductoEmpeno(productoEmpeno);
        return "redirect:/listaProductosEmpeno";
    }

    //////////////////////////////////////////////////////////////
    ///////////////////////////////////////PRODUCTO VENTA
    //////////////////////////////////////////////////////////////
    @Autowired
    ProductoVentaServicio productoVentaServicio;

    @GetMapping("/listaProductosVenta")
    public String paginaListaProductosVenta(Model modelo){
        modelo.addAttribute("productosVenta", productoVentaServicio.allProductosVenta());
        return "listaProductosVenta";
    }

    @GetMapping("/listaProductosVenta/{codigo}")
    public String eliminarProductoVenta(@PathVariable int codigo){
        ProductoVenta productoVenta1 = productoVentaServicio.findByIdProductoVenta(codigo);
        productoVentaServicio.deleteProductoVenta(productoVenta1);
        return "redirect:/listaProductosVenta";
    }
}