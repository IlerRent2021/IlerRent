/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import AppPackage.AnimationClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import vistas.Usuario;
import vistas.login;
import vistas.registro;

/**
 *
 * @author alumno
 */
public class BBDD {
    
    private static Connection con;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="jFv2sfZniE";
    private static final String pass="RfAv4px0GL";
    private static final String url="jdbc:mysql://remotemysql.com:3306/jFv2sfZniE";
    
    static String entrada_nombre=""; 
    //funcion para loguearse
    
    static public boolean loguear(JTextField primero,JPasswordField password,JLabel jLabel1) throws SQLException{
    
        boolean comprobar = false;
        char[] arrayC = password.getPassword();
        String segundo = new String(arrayC); 
        con=null;
            try
            {
                Class.forName(driver);
                // Nos conectamos a la bd
                con= (Connection) DriverManager.getConnection(url, user, pass);
                // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
                if (con!=null){
                    
                }
                //creacion de consulta para base de datos
                Statement statement;
                //Connection conn = DriverManager.getConnection(url, user, pass);
                String selectTableSQL = "SELECT usuario,contraseña FROM ilerent";
                statement = con.createStatement();
                ResultSet rs = statement.executeQuery(selectTableSQL);
                //recorremos las filas de la tabla
                while (rs.next()) {
                    //guardamos en variables los usuarios registrados para compararlo
                    String usuario = rs.getString("usuario");
                    String contraseña = rs.getString("contraseña");
                     entrada_nombre = primero.getText();
                    String entrada_contraseña = segundo;

                    //si existe dejamos acceso si no damos un error de login
                    if( usuario.equals(entrada_nombre) && contraseña.equals(entrada_contraseña)) {
                        
                        System.out.println("logueado");
                        Usuario.usuario = usuario;
                        
                        comprobar=true;
                        return true;
                        
                    }

                }
                if(comprobar==false){

                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto.", "Error de login", JOptionPane.ERROR_MESSAGE);
                    AnimationClass mover = new AnimationClass();
                    mover.jLabelYUp(650, 290, 10, 5, jLabel1);
                }
                con.close();
            }
            // Si la conexion NO fue exitosa mostramos un mensaje de error
            catch (ClassNotFoundException | SQLException e)
            {
                System.out.println("Error de conexion" + e);
            }
    return false;
            
        
    }
     public  static void registrar(JTextField usuario,JTextField correo,JPasswordField contraseña,JPasswordField contraseña1) throws SQLException{
             
        char[] arrayC = contraseña.getPassword();
        String primero = new String(arrayC);
        char[] arrayC1 = contraseña1.getPassword();
        String segundo = new String(arrayC1); 
        String contraseñac = primero;
        String contraseñac1 = segundo;
        boolean comprobante = false;
        
        //comparamos que las dos contraseñas sean iguales a la hora de registrar
        if(contraseñac.equals(contraseñac1)&&!primero.equals("")&&!segundo.equals("")&& email(correo.getText())==true){
        //revisamos que el usuario escogido no haya ya uno en la base de datos
            Statement statement;
            con = DriverManager.getConnection(url, user, pass);
            String selectTableSQL = "SELECT usuario FROM ilerent";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {

                String usuario1 = rs.getString("usuario");

                String entrada_usuario = usuario.getText();

                if(usuario1.equals(entrada_usuario)) {

                    JOptionPane.showMessageDialog(null, "Error de registro", "Confirmación Registro", JOptionPane.ERROR_MESSAGE);
                    
                    comprobante = true;
                    
                    con.close();
                    
                    break;
                    
                } else{
                    
                comprobante = false;
                
                }
                
            }
            if(comprobante==false){
                    //si no hay ningun usuario igual creamos la consulta y insertamos los datos del usuario de los textfield a la base de datos
                    try
                    {
                        Statement st;
                        Class.forName(driver);
                        con = DriverManager.getConnection(url, user, pass);
                    st = con.createStatement();
                    String query = "INSERT INTO ilerent (usuario,Correo,contraseña) values ('"+usuario.getText()+"','"+correo.getText()+"','"+contraseñac+"');";
                    st.executeUpdate(query);
                    System.out.println("ingresado");
                    query = "INSERT INTO datos_user (Usuario,Nombre,Apellidos,Direccion,Fecha_Nacimiento,Movil,Correo) values ('"+usuario.getText()+"','"+""+"','"+""+"','"+""+"','"+""+"','"+""+"','"+correo.getText()+"');";
                    st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Registrado correctamente", "Confirmación Registro", JOptionPane.INFORMATION_MESSAGE);
                    
                    registro.comprobante = true;
                    con.close();
                    }
                    // Si la conexion NO fue exitosa mostramos un mensaje de error
                    catch (ClassNotFoundException | SQLException e)
                    {
                        System.out.println("Error de conexion" + e);
                    }

                }
        }else if((!contraseñac.equals(contraseñac1))||usuario.getText().equals("")||correo.getText().equals("")||primero.equals("")||segundo.equals("")||email(correo.getText())==false){
        
            
            JOptionPane.showMessageDialog(null, "Error de registro", "Confirmación Registro", JOptionPane.ERROR_MESSAGE);
        
        
        }       
    }
    
    public static boolean email(String correo){
    
        if(correo.contains("@")){

            if(correo.contains(".es")||correo.contains(".com")){

                return true;

            }else{

                return false;

            }

        }else{

        return false;

        }
    
    }
    
    
    public static String recuperar(int codigo ,String usuario) throws SQLException{
        
        String dato="";
    
     con=null;
            try
            {
                Class.forName(driver);
                // Nos conectamos a la bd
                con= (Connection) DriverManager.getConnection(url, user, pass);
                // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
                if (con!=null){
                    
                }
                //creacion de consulta para base de datos
                Statement statement;
                //Connection conn = DriverManager.getConnection(url, user, pass);
                String selectTableSQL = "SELECT Usuario,Nombre,Apellidos,Direccion,Fecha_Nacimiento,Movil,Correo FROM datos_user";
                statement = con.createStatement();
                ResultSet rs = statement.executeQuery(selectTableSQL);
                //recorremos las filas de la tabla
                while (rs.next()) {
                    //guardamos en variables los usuarios registrados para compararlo
                    String Usuario = rs.getString("Usuario");
                    String Nombre = rs.getString("Nombre");
                    String Apellidos = rs.getString("Apellidos");
                    String Direccion = rs.getString("Direccion");
                    String Fecha_Nacimiento = rs.getString("Fecha_Nacimiento");
                    String Movil = rs.getString("Movil");
                    String Correo = rs.getString("Correo");
                    
                    if(Usuario.equals(usuario)){
                    
                        switch(codigo){

                            case 1:

                                return Usuario;

                            case 2:

                                return Nombre;

                            case 3:

                                return Apellidos;

                            case 4:

                                return Direccion;

                            case 5:

                                return Fecha_Nacimiento;

                            case 6:

                                return Movil;

                            case 7:

                                return Correo;

                        }
                    }
                }
                con.close();
                
            }
            // Si la conexion NO fue exitosa mostramos un mensaje de error
            catch (ClassNotFoundException | SQLException e)
            {
                System.out.println("Error de conexion" + e);
            }
    
    
    return dato;
    
    }
    
    public static void Actu_User(String nombre,String apellidos,String direccion,String fecha,String movil,String correo){
    
        try
        {
            Statement st;
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        st = con.createStatement();
        String query = "UPDATE datos_user SET Nombre='"+nombre+"',Apellidos='"+apellidos+"',Direccion='"+direccion+"',Fecha_Nacimiento='"+fecha+"',Movil='"+movil+"',Correo='"+correo+"' WHERE Usuario= '"+Usuario.usuario+"';";
        
        st.executeUpdate(query);
        System.out.println("actualizado");
        
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error de conexion" + e);
        }
    
    }
    
    public static boolean comp_contr(JPasswordField contraseña){
    
        boolean comprobar = false;
        char[] arrayC = contraseña.getPassword();
        String segundo = new String(arrayC); 
        con=null;
            try
            {
                Class.forName(driver);
                // Nos conectamos a la bd
                con= (Connection) DriverManager.getConnection(url, user, pass);
                // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
                if (con!=null){
                    
                }
                //creacion de consulta para base de datos
                Statement statement;
                //Connection conn = DriverManager.getConnection(url, user, pass);
                String selectTableSQL = "SELECT contraseña FROM ilerent WHERE Usuario= '"+Usuario.usuario+"';";
                statement = con.createStatement();
                ResultSet rs = statement.executeQuery(selectTableSQL);
                //recorremos las filas de la tabla
                while (rs.next()) {
                    
                    
                    String contraseña1 = rs.getString("contraseña");
                     
                    String entrada_contraseña = segundo;

                   
                    if(contraseña1.equals(entrada_contraseña)) {
                        
                        comprobar=true;
                        return true;
                        
                    }

                }
                if(comprobar==false){

                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
                con.close();
            }
            // Si la conexion NO fue exitosa mostramos un mensaje de error
            catch (ClassNotFoundException | SQLException e)
            {
                System.out.println("Error de conexion" + e);
            }
    return false;
    
    }
    
    public static void Actu_pass(JPasswordField contraseña){
        
        char[] arrayC = contraseña.getPassword();
        String segundo = new String(arrayC); 
        
        try
           {
               Statement st;
               Class.forName(driver);
               con = DriverManager.getConnection(url, user, pass);
           st = con.createStatement();
           String query = "UPDATE ilerent SET contraseña='"+segundo+"'WHERE Usuario= '"+Usuario.usuario+"';";

           st.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente", "Actualizado", JOptionPane.INFORMATION_MESSAGE);
           
           }
           // Si la conexion NO fue exitosa mostramos un mensaje de error
           catch (ClassNotFoundException | SQLException e)
           {
               System.out.println("Error de conexion" + e);
           }
    
    
    
    
    }
    
    public static void GDreserva(String lugar_Ini, String lugar_fin, String fecha_ini, String fecha_fin, String id_coche){
    
        try
                    {
                        Statement st;
                        Class.forName(driver);
                        con = DriverManager.getConnection(url, user, pass);
                    st = con.createStatement();
                    String query = "INSERT INTO Reservas values ('"+lugar_Ini+"','"+lugar_fin+"','"+fecha_ini+"','"+fecha_fin+"','"+Usuario.usuario+"');";
                    st.executeUpdate(query);
                    System.out.println("ingresado");
                    
                    st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Registrado correctamente", "Confirmación Registro", JOptionPane.INFORMATION_MESSAGE);
                    
                    registro.comprobante = true;
                    con.close();
                    }
                    // Si la conexion NO fue exitosa mostramos un mensaje de error
                    catch (ClassNotFoundException | SQLException e)
                    {
                        System.out.println("Error de conexion" + e);
                    }
    
    
    
    
    
    }
}
