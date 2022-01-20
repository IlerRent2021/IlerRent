/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

/**
 *
 * @author alumno
 */


public class Sede {
    int id;
    String ciudad;
    double lat;
    double lon;
    String direccion;
    geocodificacion g;

//    public Sede(int id, String ciudad, double lat, double lon) {
//        this.id = id;
//        this.ciudad = ciudad;
//        this.lat = lat;
//        this.lon = lon;
//        g=new geocodificacion(lat, lon);
//        this.direccion = g.getDireccion();
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public geocodificacion getG() {
        return g;
    }

    public void setG(geocodificacion g) {
        this.g = g;
    }
    
    
}
