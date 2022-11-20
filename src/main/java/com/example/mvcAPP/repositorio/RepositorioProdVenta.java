package com.example.mvcAPP.repositorio;

import com.example.mvcAPP.modelo.ProductoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProdVenta extends JpaRepository<ProductoVenta, Integer> {
    public boolean existsById(int codigo);
}