package com.Prod3.RepositorioUsuario;

import com.Prod3.modeloUsuarioRol.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepositorio extends JpaRepository <Usuario, Long>{
    public Usuario findByEmail(String email);
}
