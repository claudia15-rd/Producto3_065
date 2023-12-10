package com.Prod3.alquiler;

import com.Prod3.cliente.Cliente;
import com.Prod3.vehiculo.Vehiculo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "alquileres")

public class Alquiler {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idAlquiler;

    @Column(nullable = false, length = 50)
    private String lugarRecogida;

    @Column(nullable = false, length = 50)
    private String lugarDevolucion;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "fechaRecogida")
    private Date fechaRecogida;

   /* @Column(nullable = false, length = 50)
    Date  horaRecogida;*/


    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="fechaDevolucion")
    private Date fechaDevolucion;

   /* @Column(nullable = false, length = 50)
    Date horaDevolucion;*/

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "idVehiculos")
    private Vehiculo vehiculo;

    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cliente_id", referencedColumnName = "idClientes")
    private Cliente cliente;

    public Integer getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getLugarRecogida() {
        return lugarRecogida;
    }

    public void setLugarRecogida(String lugarRecogida) {
        this.lugarRecogida = lugarRecogida;
    }

    public String getLugarDevolucion() {
        return lugarDevolucion;
    }

    public void setLugarDevolucion(String lugarDevolucion) {
        this.lugarDevolucion = lugarDevolucion;
    }

    public Date getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(Date fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

   /* public Date getHoraRecogida() {
        return horaRecogida;
    }*/

 /*   public void setHoraRecogida(Date horaRecogida) {
        this.horaRecogida = horaRecogida;
    }*/

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

 /*   public Date getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(Date horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }*/

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }



    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "idAlquiler=" + idAlquiler +
                ", lugarRecogida='" + lugarRecogida + '\'' +
                ", lugarDevolucion='" + lugarDevolucion + '\'' +
                ", fechaRecogida=" + fechaRecogida +
                ", fechaDevolucion=" + fechaDevolucion +
                ", vehiculo=" + vehiculo +
                ", cliente=" + cliente +
                '}';
    }
}
