package com.Prod3.controladores.dto;

public class UsuarioRegistroDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    private boolean super_admin;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isSuper_admin() {
        return super_admin;
    }

    public void setSuper_admin(boolean super_admin) {
        this.super_admin = super_admin;
    }


    public UsuarioRegistroDTO(String nombre, String apellido, String email, String password, boolean super_admin) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.super_admin=super_admin;
    }

    public UsuarioRegistroDTO() {

    }

}
