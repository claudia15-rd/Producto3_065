package com.Prod3.vehiculo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculos;

    @Column(nullable = false, length = 30)
    private String tipo;
    @Column(nullable = false, length = 30)
    private String marca;
    @Column(nullable = false, length=30)
    private String modelo;
    @Column(length = 15)
    private Integer  capacidad;
    @Column(nullable = false, length = 30)
    private String matricula;

    public Integer getIdVehiculos() {
        return idVehiculos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdVehiculos(Integer idVehiculos) {
        this.idVehiculos = idVehiculos;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "idVehiculos=" + idVehiculos +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
