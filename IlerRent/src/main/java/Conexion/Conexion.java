package Conexion;

import Logica.Sede;
import Logica.Vehiculo;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    private final String DB="jFv2sfZniE";
    private final String USER="jFv2sfZniE";
    private final String PASS="RfAv4px0GL";
    private final String URL="jdbc:mysql://remotemysql.com:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
      
    public Connection openConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASS);
            //JOptionPane.showMessageDialog(null, "Conectado");

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error de conexion");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
            
        return con;
        }
    
    public void closeConnection(Connection connect) throws SQLException{
            
        connect.close();
        System.out.println("Conexión Cerrada Exitosamente");
            
    } 
  //Esta funcion se encarga de pasar los bytes de la imagen de la base de datos a una imagen para mostrarla junto a todos sus demas datos
//    public List<Vehiculo> MostrarVehiculo(){
//        List <Vehiculo> VistaVehiculo = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection Conection= (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASS);
//            JOptionPane.showMessageDialog(null, "Conectado");
//            Statement Consulta = Conection.createStatement();
//            ResultSet Resultado = Consulta.executeQuery("SELECT * FROM Vehiculos");
//            while (Resultado.next()) {
//                VistaVehiculo.add(new Vehiculo(Resultado.getInt("ID"), (ImageIcon) Resultado.getBlob("Img"),Resultado.getString("Marca"),Resultado.getString("Modelo"),Resultado.getString("Combustible"),Resultado.getString("Precio"),Resultado.getInt("Sede"),Resultado.getString("Estado")));
//            }   
//        } catch (SQLException e) {
//            return null;
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return VistaVehiculo;
//    }
    
    //ESTA FUNCION SOBRA
    public Sede buscador(String ciudad) throws SQLException, ClassNotFoundException{
        if(buscarSede(ciudad) == null){
            JOptionPane.showMessageDialog(null, "NO HAY SEDE");
            return null;
        }else{
        return buscarSede(ciudad);
        }
    }       
    public Sede buscarSede(String ciudad) throws SQLException, ClassNotFoundException{
        
        Connection conn=openConnection();
        Sede sede=null;
        
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM sede WHERE ciudad like ?");

            statement.setString(1, ciudad);
            

            ResultSet rs= statement.executeQuery();

            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "busco una sede");
                int id=rs.getInt("id");
                String ciu=rs.getString("ciudad");
                double lat=rs.getDouble("lat");
                double lon=rs.getDouble("lon");
                sede =new Sede(id, ciu, lat, lon);
            }
        return sede;

    }

}
