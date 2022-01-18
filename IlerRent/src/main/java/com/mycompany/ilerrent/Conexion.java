package com.mycompany.ilerrent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Conexion {
    private static Connection Conection;
    private static Statement Consulta;
    private static ResultSet Resultado;
    private final String DB="jFv2sfZniE";
    private final String USER="jFv2sfZniE";
    private final String PASS="RfAv4px0GL";
    private final String URL="jdbc:mysql://remotemysql.com:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
      
    public Connection openConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASS);
            JOptionPane.showMessageDialog(null, "Conectado");

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error de conexion");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
            
        return con;
        }
    

     public List<Vehiculo> MostrarVehiculo(){
        List <Vehiculo> VistaVehiculo = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conection = (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASS);
            JOptionPane.showMessageDialog(null, "Conectado");
            Consulta = Conection.createStatement();
            Resultado = Consulta.executeQuery("SELECT * FROM Vehiculos");
            while (Resultado.next()) {
                VistaVehiculo.add(new Vehiculo(Resultado.getInt("ID"),Resultado.getBytes("Img"),Resultado.getString("Marca"),Resultado.getString("Modelo"),Resultado.getString("Combustible"),Resultado.getString("Precio"),Resultado.getInt("Sede"),Resultado.getString("Estado")));
            }   
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return VistaVehiculo;
    }
    
    public void closeConnection(Connection connect) throws SQLException{      
        connect.close();
        System.out.println("Conexión Cerrada Exitosamente");
            
    }   
}