/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ilerrent;

/**
 *
 * @author alumno
 */
public class Vehiculo {
    private int ID;
    private byte[] Img;
    private String Marca;
    private String Modelo;
    private String Combustible;
    private String Precio;
    private int Sede;
    private String Estado;

    public Vehiculo() {
    }

    public Vehiculo(int ID, byte[] Img, String Marca, String Modelo, String Combustible, String Precio, int Sede, String Estado) {
        this.ID = ID;
        this.Img = Img;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Combustible = Combustible;
        this.Precio = Precio;
        this.Sede = Sede;
        this.Estado = Estado;
    }

    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public byte[] getImg() {
        return Img;
    }

    public void setImg(byte[] Img) {
        this.Img = Img;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getCombustible() {
        return Combustible;
    }

    public void setCombustible(String Combustible) {
        this.Combustible = Combustible;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public int getSede() {
        return Sede;
    }

    public void setSede(int Sede) {
        this.Sede = Sede;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
