package com.Prod3.servicio;

import java.util.List;

import com.Prod3.modeloUsuarioRol.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.Prod3.controladores.dto.UsuarioRegistroDTO;



public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
