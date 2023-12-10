package com.Prod3.alquiler;

import org.springframework.data.jpa.repository.JpaRepository;

//public interface AlquilerRepositorio extends CrudRepository <Alquiler, Integer> {
public interface AlquilerRepositorio extends JpaRepository<Alquiler, Integer> {
    public long countAlquilerByIdAlquiler(Integer id);
}
