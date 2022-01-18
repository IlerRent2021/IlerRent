package Conexion;

import Logica.Sede;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
  
    //ESTA FUNCION SOBRA
    public Sede buscador(String ciudad) throws SQLException, ClassNotFoundException{
        if(buscarSede(ciudad).equals(null)){
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
                JOptionPane.showMessageDialog(null, "busco una sede");
                int id=rs.getInt("id");
                String ciu=rs.getString("ciudad");
                double lat=rs.getDouble("lat");
                double lon=rs.getDouble("lon");
                sede =new Sede(id, ciu, lat, lon);
            }
        return sede;

    }

//        
//    public int comprueba_existencia(String usuario,String contraseña,String email) throws SQLException, ClassNotFoundException{
//        int cod=-1;
//        
//        Connection conn=openConnection();
//        Usuario flag=comprueba_existencia(usuario, contraseña);
//        if(flag==null){
//            PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuario WHERE email like ?");
//            //statement.setString(1, usuario);
//            //statement.setString(2, contraseña);
//            statement.setString(1, email);
//            
//
//            ResultSet rs= statement.executeQuery();
//
//            //cod = rs.getInt();
//            if (rs.next()) {
//                cod = rs.getInt("id");
//            }
//        }
//        else{
//            cod=flag.getId();
//        }
//        return cod;
//
//    }
//    public Usuario comprueba_existencia(String usuario,String contraseña) throws SQLException, ClassNotFoundException{
//       
//        
//        Usuario us = null;
//        Connection conn=openConnection();
//        PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuario WHERE usuario = ? and contraseña = ?");
//        statement.setString(1, usuario);
//        statement.setString(2, contraseña);
//        ResultSet rs = statement.executeQuery();
//
//        if (rs.next()) {
//            us=new Usuario(rs.getInt(1),rs.getString("usuario"), rs.getString("contraseña"), rs.getString("email"));
//        }
//
//        
//        return us;
//    }
//    public int compruebaUbicacion(String lugar, String ciudad) throws SQLException{
//        int cod=-1;
//
//        Connection conn=openConnection();
//        PreparedStatement statement = conn.prepareStatement("SELECT * FROM ubicacion WHERE lugar = ? and ciudad = ?");
//        statement.setString(1, lugar);
//        statement.setString(2, ciudad);
//        statement.executeQuery();
//
//        ResultSet rs= statement.executeQuery();
//            
//        while (rs.next()) {
//                cod = rs.getInt(1);
//        }
//        return cod;
//    }
//    public int crearRuta(Ruta ruta){
//       int cod=0;
//        try {
//            Connection conn=openConnection();
//            PreparedStatement stmt=openConnection().prepareStatement("insert into ruta(nombre,idUsuario) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
//            
//            
//            stmt.setString(1, ruta.getNombre());
//            stmt.setDouble(2, ruta.getId_usuario());
//
//
//
//            stmt.executeUpdate();
//            
//            ResultSet rs= stmt.getGeneratedKeys();
//            
//            while (rs.next()) {
//                    cod = rs.getInt(1);
//            }
//            
//            PreparedStatement stmt2=openConnection().prepareStatement("insert into ubicacion(lugar,ciudad,valoracion) values (?,?,0)",PreparedStatement.RETURN_GENERATED_KEYS);
//            PreparedStatement stmt3=openConnection().prepareStatement("insert into ubicacionRuta(idRuta,idUbicacion,posicion) values (?,?,?)");
//            
//            
//            HashMap<Ubicacion,Integer> ubi=ruta.getUbicaciones();
//            for (Map.Entry<Ubicacion, Integer> entry : ubi.entrySet()) {
//               Ubicacion key = entry.getKey(); //cada ubicacion
//               int codigoUbicacion=compruebaUbicacion(key.getNombre(),key.getCiudad());
//               if(codigoUbicacion==-1){
//                   stmt2.setString(1, key.getNombre());
//                   stmt2.setString(2, key.getCiudad());
//                   stmt2.executeUpdate();
//
//                   ResultSet rs2= stmt2.getGeneratedKeys();
//
//                   while (rs2.next()) {
//                           codigoUbicacion = rs2.getInt(1);
//                   }
//               }
//               Integer posicion=entry.getValue();
//
//               stmt3.setInt(1, cod);
//               stmt3.setInt(2, codigoUbicacion);
//               stmt3.setInt(3, posicion);
//               stmt3.executeUpdate();
//            }
//
//           
//            
//
//             
//            closeConnection(conn);
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return cod;
//    }
//    //metodo que te devuelve una lista de rutas segun la ubicacion que le pasas
//    public List<Ruta> damerutas(String ciudad) throws SQLException {
//        List<Ruta> rutas=new ArrayList<>();
//        List<Integer> cod=new ArrayList<>();
//        Connection conn=openConnection();
//        PreparedStatement statementubi = conn.prepareStatement  
//        ("SELECT r.id, r.nombre, r.idUsuario FROM ubicacion u "
//        + "inner join ubicacionRuta ur on u.id=ur.idUbicacion "
//        + "inner join ruta r on r.id=ur.idRuta WHERE u.ciudad = ?");
//        PreparedStatement statementuR = conn.prepareStatement
//        ("SELECT ur.idUbicacion, u.lugar, ur.posicion, u.valoracion FROM ubicacionRuta ur "
//        + "inner join ubicacion u on u.id=ur.idUbicacion WHERE idRuta = ?");
//        statementubi.setString(1, ciudad);
//        statementubi.executeQuery();
//
//        ResultSet rs= statementubi.executeQuery();
//            
//        while (rs.next()) {
//            Ruta ruta=new Ruta();
//            cod.add(rs.getInt(1));
//            ruta.setId(rs.getInt(1));
//            ruta.setNombre(rs.getString(2));
//            
//            ruta.setId_usuario(rs.getInt(3));
//            System.out.println(cod.toString());
//            statementuR.setInt(1, rs.getInt(1));
//            HashMap<Ubicacion,Integer> ubi=new HashMap<>();
//            ResultSet ubicacion=statementuR.executeQuery();
//            while(ubicacion.next()){
//                Ubicacion u=new Ubicacion(new Geocodificacion(ubicacion.getString(2)), ciudad);
//                u.setId(ubicacion.getInt(1));
//                u.setValoracion(ubicacion.getInt(4));
//                ubi.put(u, ubicacion.getInt(3));
//            }
//            ruta.setUbicaciones(ubi);
//            rutas.add(ruta);
//        }
//        return rutas;
//    }
//    public void actualizaValoracion(int idUbi, int valoracion) throws SQLException {
//        
//        Connection conn=openConnection();
//        PreparedStatement stmt = conn.prepareStatement("UPDATE ubicacion SET valoracion=? WHERE id=?");
//        stmt.setInt(1, valoracion);
//        stmt.setInt(2, idUbi);
//        stmt.executeUpdate();
//        closeConnection(conn);
//    }
}
