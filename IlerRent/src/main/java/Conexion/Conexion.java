package Conexion;

import Logica.Reserva;
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
import java.util.Date;
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
    private static Connection con;
    private final String DB=System.getenv("DB");
    private final String USER=System.getenv("USER");
    private final String PASS=System.getenv("PASS");
    private final String URL=System.getenv("URL");
    
    public Conexion() {
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(URL, USER, PASS);
        }
        
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
      
//    public Connection openConnection() {
//        Connection con = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASS);
//            //JOptionPane.showMessageDialog(null, "Conectado");
//
//        } catch (SQLException e) {
//            System.err.println(e);
//            JOptionPane.showMessageDialog(null, "Error de conexion");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Error de conexion");
//        }
//            
//        return con;
//        }
    
    public void closeConnection(Connection connect) throws SQLException{
            
        connect.close();
        System.out.println("Conexión Cerrada Exitosamente");
            
    } 
//Esta funcion se encarga de pasar los bytes de la imagen de la base de datos a una imagen para mostrarla junto a todos sus demas datos
    public List<Vehiculo> MostrarVehiculo(){
        List <Vehiculo> VistaVehiculo = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conection= (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASS);
            //JOptionPane.showMessageDialog(null, "Conectado");
            Statement Consulta = Conection.createStatement();
            ResultSet Resultado = Consulta.executeQuery("SELECT * FROM Vehiculos where Estado like 'Disponible'");
            while (Resultado.next()) {
                VistaVehiculo.add(new Vehiculo(Resultado.getInt("ID"),Resultado.getBytes("Img"),Resultado.getString("Marca"),Resultado.getString("Modelo"),Resultado.getString("Combustible"),Resultado.getString("Precio"),Resultado.getInt("Sede"),Resultado.getString("Estado")));
            } 
            closeConnection(Conection);
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return VistaVehiculo;
    }
    
    
    //funcion que te busca la sede segun la cuidad pasada por parametros devuelve la sede de la ciudad      
    public Sede buscarSede(String ciudad) throws SQLException, ClassNotFoundException{
        
//        Connection conn=openConnection();
        Sede sede=null;
        
            PreparedStatement statement = con.prepareStatement("SELECT * FROM sede WHERE ciudad like ?");

            statement.setString(1, ciudad);
            

            ResultSet rs= statement.executeQuery();

            while (rs.next()) {
                //guarda el resultado de la selección en una sede
                int id=rs.getInt("id");
                String ciu=rs.getString("ciudad");
                double lat=rs.getDouble("lat");
                double lon=rs.getDouble("lon");
                sede =new Sede(id, ciu, lat, lon);
            }
            //closeConnection(conn);
        return sede;

    }

    //esta funcion te busca las reservas de un usuario en particular
    public List<Reserva> todasreservas(String id) throws SQLException{
        List<Reserva> reservas=new ArrayList<>();
        //Connection conn=openConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Reservas where id_user_fk like ?");
        
        statement.setString(1, id);
        ResultSet rs= statement.executeQuery();
        
        while (rs.next()) {
            //guarda los dsatos de cada reserva
            int idreserva=rs.getInt("id");
            Sede lugar_inicio=bucarSede(rs.getInt("lugar_inicio"));
            Sede lugar_destino=bucarSede(rs.getInt("lugar_destino"));
            Date fecha_inicio=rs.getDate("fecha_inicio");
            Date fecha_fin=rs.getDate("fecha_fin");
            Vehiculo vehiculo=buscarVehiculo(rs.getInt("id_coche_fk"));
            String usuario=id;
            String precio=rs.getString("precio");
            //añade la reserva a la lista de reservas
            reservas.add(new Reserva(idreserva, lugar_inicio, lugar_destino, fecha_inicio,fecha_fin,vehiculo,usuario,precio));
        }



        
        return reservas;
    }
    
    //esta funcion te busca el vehiculo por el id
    public Vehiculo buscarVehiculo(int id_coche_fk) throws SQLException{
            Vehiculo vehiculo=null;
        
            //Connection conn=openConnection();

            PreparedStatement statement = con.prepareStatement("SELECT * FROM Vehiculos where id like ?");
            statement.setInt(1, id_coche_fk);
             ResultSet rs= statement.executeQuery();
            while (rs.next()) {
                //guarda los datos del vehiculo
                int id=rs.getInt("ID");
                byte[] b=rs.getBytes("Img");
                String marca=rs.getString("Marca");
                String modelo=rs.getString("Modelo");
                String combustible=rs.getString("Combustible");
                String precio=rs.getString("Precio");
                int idsede=rs.getInt("Sede");
                String estado=rs.getString("Estado");
                vehiculo=new Vehiculo(id,b,marca,modelo,combustible,precio,idsede,estado);
            } 
            //closeConnection(conn);
        
        return vehiculo;
    }
    
    //esta funcion te busca la sede por el id de esta
    public Sede bucarSede(int id) throws SQLException{
        //Connection conn=openConnection();
        Sede sede=null;
        
            PreparedStatement statement = con.prepareStatement("SELECT * FROM sede WHERE id like ?");

            statement.setInt(1, id);
            

            ResultSet rs= statement.executeQuery();

            if (rs.next()) {
                //guarda los datos de la sede 
                int idsede=rs.getInt("id");
                String ciu=rs.getString("ciudad");
                double lat=rs.getDouble("lat");
                double lon=rs.getDouble("lon");
                sede =new Sede(id, ciu, lat, lon);
            }
            //closeConnection(conn);
        return sede;
    }
    public List<Sede> todasSedes() throws SQLException {
        //Connection conn=openConnection();
        List<Sede>Sede=new ArrayList<>();
        
        PreparedStatement statement = con.prepareStatement("SELECT * FROM sede");




        ResultSet rs= statement.executeQuery();

        while (rs.next()) {
            //JOptionPane.showMessageDialog(null, "busco una sede");
            int id=rs.getInt("id");
            String ciu=rs.getString("ciudad");
            double lat=rs.getDouble("lat");
            double lon=rs.getDouble("lon");
            Sede.add(new Sede(id, ciu, lat, lon));
        }
        //closeConnection(conn);
        return Sede;
    }
    
    private double distance(double lat1, double lat2, double lon1, double lon2,double el1, double el2) {

    final int R = 6371; // Radius of the earth

    Double latDistance = deg2rad(lat2 - lat1);
    Double lonDistance = deg2rad(lon2 - lon1);
    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c * 1000; // convert to meters

    double height = el1 - el2;
    distance = Math.pow(distance, 2) + Math.pow(height, 2);
    return Math.sqrt(distance);
    
    }

private double deg2rad(double deg) {
    return (deg * Math.PI / 180.0);
}

}
