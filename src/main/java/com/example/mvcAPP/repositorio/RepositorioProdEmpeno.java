package com.example.mvcAPP.repositorio;

import com.example.mvcAPP.modelo.ProductoEmpeno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProdEmpeno extends JpaRepository<ProductoEmpeno, Integer> {
    public boolean existsById(int codigo);
}