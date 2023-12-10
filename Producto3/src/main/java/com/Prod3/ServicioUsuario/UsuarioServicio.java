package com.Prod3.ServicioUsuario;

import com.Prod3.controladores.dto.UsuarioRegistroDTO;
import com.Prod3.modeloUsuarioRol.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService {
    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    public List<Usuario> listarUsuarios();


}
