package com.example.mvcAPP.servicio;

import com.example.mvcAPP.modelo.Cliente;
import com.example.mvcAPP.repositorio.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private RepositorioCliente repositorioCliente;

    ///crear cliente
    @Transactional
    public boolean createCliente (Cliente cliente)  {
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

    ////////////////////////nuevo////////////////////
    ///guardar cliente
    @Transactional
    public boolean modifyCliente(Cliente cliente){
        try {
            if(!repositorioCliente.existsById(cliente.getCedula())){
                return false;
            }else {
                repositorioCliente.save(cliente);
                return true;

            }
        }catch (Exception e){
            throw e;
        }
    }

    /*@Transactional
    public Cliente modifyCliente(Cliente cliente){
        return repositorioCliente.save(cliente);
    }*/

    ///listar todos los clientes
    public List<Cliente> allClientes (){
        return repositorioCliente.findAll();
    }

    ///buscar cliente por cedula
    public Cliente findByIdCliente (Long id) {
        return repositorioCliente.findById(id).get();
    }
}