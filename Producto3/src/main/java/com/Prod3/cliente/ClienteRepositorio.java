package com.Prod3.cliente;

import org.springframework.data.repository.CrudRepository;

//public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {
   public long countClienteByIdClientes(Integer id);


}
