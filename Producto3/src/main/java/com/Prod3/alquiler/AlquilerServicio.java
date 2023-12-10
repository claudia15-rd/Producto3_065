package com.Prod3.alquiler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerServicio {

    @Autowired private AlquilerRepositorio repo;


    public List<Alquiler> listAllAlquileres() {
        return  (List<Alquiler>) repo.findAll();

    }

    public void save(Alquiler alquiler)
    {
        repo.save(alquiler);
    }

    public Alquiler get(Integer id)  throws AlquilerNotFoundException{
        Optional<Alquiler> result = repo.findById(id);
        if (result.isPresent())
        {
            return result.get();

        }
        throw new AlquilerNotFoundException("No se ha encontrado ningún cliente con ID " + id);
    }

    public void borrarAlquiler(Integer id) throws AlquilerNotFoundException {
        Long count =repo.countAlquilerByIdAlquiler(id);
        if (count == null || count ==0)
        {
            throw new AlquilerNotFoundException("No se ha encontrado ningún alguiler con ID " + id);
        }
        repo.deleteById(id);
    }


}
