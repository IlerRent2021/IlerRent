/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Vehiculo {
    private int ID;
    private ImageIcon Img;
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
        this.Img = ImagenVehiculo(Img);
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Combustible = Combustible;
        this.Precio = Precio.replace(",", ".");
        this.Sede = Sede;
        this.Estado = Estado;
    }

    //Esta función se encarga de pasar los bytes de la imagen de la base de datos a un ImageIcon para mostrar la imagen en la aplicación
    public ImageIcon ImagenVehiculo(byte[] Img){
        try{
            BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(Img));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        ImageIcon icono = new ImageIcon(Img);
        return icono;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ImageIcon getImg() {
        return Img;
    }

    public void setImg(ImageIcon Img) {
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
