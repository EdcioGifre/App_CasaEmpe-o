package com.example.mvcAPP.servicio;

import com.example.mvcAPP.modelo.ProductoVenta;
import com.example.mvcAPP.repositorio.RepositorioProdVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoVentaServicio {

    @Autowired
    private RepositorioProdVenta repositorioProdVenta;

    ///crear productoVenta
    @Transactional
    public boolean createProductoVenta (ProductoVenta productoVenta) {
        try {
            if(!repositorioProdVenta.existsById(productoVenta.getCodigo())){
                repositorioProdVenta.save(productoVenta);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw e;
        }
    }

    ///eliminar 1 productoVenta
    @Transactional
    public String deleteProductoVenta (ProductoVenta productoVenta) {
        if(repositorioProdVenta.existsById(productoVenta.getCodigo())){
            repositorioProdVenta.delete(productoVenta);
            return "ProductoV eliminado con exito.";
        }else {
            return "El productoV no existe, no se puede eliminar.";
        }
    }

    ///listar todos los productosVenta
    public List<ProductoVenta> allProductosVenta (){
        return repositorioProdVenta.findAll();
    }

    ///buscar cliente por cedula
    public ProductoVenta findByIdProductoVenta (int codigo) {
        return repositorioProdVenta.findById(codigo).get();
    }
}
