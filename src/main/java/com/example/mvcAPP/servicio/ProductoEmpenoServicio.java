package com.example.mvcAPP.servicio;

import com.example.mvcAPP.modelo.ProductoEmpeno;
import com.example.mvcAPP.repositorio.RepositorioProdEmpeno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoEmpenoServicio {

    @Autowired
    private RepositorioProdEmpeno repositorioProdEmpeno;

    ///crear productoEmpeno
    @Transactional
    public boolean createProductoEmpeno (ProductoEmpeno productoEmpeno) {
        try {
            if(!repositorioProdEmpeno.existsById(productoEmpeno.getCodigo())){
                repositorioProdEmpeno.save(productoEmpeno);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw e;
        }
    }

    ///eliminar 1 productoEmpeno
    @Transactional
    public String deleteProductoEmpeno (ProductoEmpeno productoEmpeno) {
        if(repositorioProdEmpeno.existsById(productoEmpeno.getCodigo())){
            repositorioProdEmpeno.delete(productoEmpeno);
            return "ProductoE eliminado con exito.";
        }else {
            return "El productoE no existe, no se puede eliminar.";
        }
    }

    ///listar todos los productosEmpeno
    public List<ProductoEmpeno> allProductosEmpeno (){
        return repositorioProdEmpeno.findAll();
    }

    ///buscar productosEmpeno por codigo
    public Optional<ProductoEmpeno> findByIdProductoEmpeno (int codigo) {
        return repositorioProdEmpeno.findById(codigo);
    }
}