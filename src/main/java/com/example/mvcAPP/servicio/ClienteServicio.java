package com.example.mvcAPP.servicio;

import com.example.mvcAPP.modelo.Cliente;
import com.example.mvcAPP.repositorio.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private RepositorioCliente repositorioCliente;

    ///crear cliente
    @Transactional
    public boolean createCliente (Cliente cliente) {
        try {
            if(!repositorioCliente.existsById(cliente.getCedula())){
                repositorioCliente.save(cliente);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw e;
        }
    }

    ///eliminar 1 cliente
    @Transactional
    public String deleteCliente (Cliente cliente) {
        if(repositorioCliente.existsById(cliente.getCedula())){
            repositorioCliente.delete(cliente);
            return "Cliente eliminado con exito.";
        }else {
            return "El cliente no existe, no se puede eliminar.";
        }
    }

    ///listar todos los clientes
    public List<Cliente> allClientes (){
        return repositorioCliente.findAll();
    }

    ///buscar cliente por cedula
    public Optional<Cliente> findByIdCliente (Long id) {
        return repositorioCliente.findById(id);
    }
}