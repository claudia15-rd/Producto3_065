package com.Prod3.vehiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServicio {
    @Autowired
    private VehiculoRepositorio repo;

    public List<Vehiculo> listAllVehiculos() {
        return  (List<Vehiculo>) repo.findAll();

    }

    public void save(Vehiculo vehiculo) {
        repo.save(vehiculo);
    }

    public Vehiculo get(Integer id) throws VehiculoNotFoundException {
        Optional<Vehiculo> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();

        }
        throw new VehiculoNotFoundException("No se ha encontrado ningún vehículo con el ID: " + id);

    }

    public void borrarVehiculo(Integer id) throws VehiculoNotFoundException {
        Long count =repo.countVehiculosByIdVehiculos(id);
        if (count == null || count == 0){
            throw new VehiculoNotFoundException("No se ha encontrado ningún vehículo con ID " + id);
        }
        repo.deleteById(id);




    }


}
