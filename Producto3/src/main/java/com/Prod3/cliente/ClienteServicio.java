package com.Prod3.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired private ClienteRepositorio repo;

    public List<Cliente> listAllClientes() {
        return  (List<Cliente>) repo.findAll();

    }

    public void save(Cliente cliente) {
        repo.save(cliente);
    }

    public Cliente get(Integer id) throws ClienteNotFoundException {
        Optional<Cliente> result = repo.findById(id);
        if (result.isPresent())
        {
            return result.get();

        }
        throw new ClienteNotFoundException("No se ha encontrado ningún cliente con ID " + id);
    }

    public void borrarCliente(Integer id) throws ClienteNotFoundException {
        Long count =repo.countClienteByIdClientes(id);
        if (count == null || count == 0){
            throw new ClienteNotFoundException("No se ha encontrado ningún cliente con ID " + id);
        }
        repo.deleteById(id);




    }
}
