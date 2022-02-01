/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;

/**
 *
 * @author alumno
 */
public class Reserva {
    private int id;
    private Sede lugar_inicio;
    private Sede lugar_destino;
    private Date fecha_inicio;
    private Date fecha_destino;
    private Vehiculo vehiculo;
    private String usuario;
    private String precio_total;

    public Reserva() {
    }

    public Reserva(int id, Sede lugar_inicio, Sede lugar_destino, Date fecha_inicio, Date fecha_destino, Vehiculo vehiculo, String usuario, String precio_total) {
        this.id = id;
        this.lugar_inicio = lugar_inicio;
        this.lugar_destino = lugar_destino;
        this.fecha_inicio = fecha_inicio;
        this.fecha_destino = fecha_destino;
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.precio_total = precio_total;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sede getLugar_inicio() {
        return lugar_inicio;
    }

    public void setLugar_inicio(Sede lugar_inicio) {
        this.lugar_inicio = lugar_inicio;
    }

    public Sede getLugar_destino() {
        return lugar_destino;
    }

    public void setLugar_destino(Sede lugar_destino) {
        this.lugar_destino = lugar_destino;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_destino() {
        return fecha_destino;
    }

    public void setFecha_destino(Date fecha_destino) {
        this.fecha_destino = fecha_destino;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(String precio_total) {
        this.precio_total = precio_total;
    }
    
    
    
    
    
}
