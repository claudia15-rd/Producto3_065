package com.Prod3.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Prod3.modeloUsuarioRol.Usuario;
import com.Prod3.controladores.dto.UsuarioRegistroDTO;
import com.Prod3.modeloUsuarioRol.Rol;
import com.Prod3.RepositorioUsuario.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario;
		if (registroDTO.isSuper_admin()==true)
		{
			 usuario = new Usuario(registroDTO.getNombre(),
					registroDTO.getApellido(),registroDTO.getEmail(),
					passwordEncoder.encode(registroDTO.getPassword()),true,Arrays.asList(new Rol("ROLE_ADMIN")));
		}
		else
		{
			 usuario = new Usuario(registroDTO.getNombre(),
					registroDTO.getApellido(),registroDTO.getEmail(),
					passwordEncoder.encode(registroDTO.getPassword()),false,Arrays.asList(new Rol("ROLE_USER")));
		}


		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}
}
