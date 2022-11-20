package com.example.mvcAPP.repositorio;

import com.example.mvcAPP.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository <Cliente, Long> {
    public boolean existsById(Long cedula);
}