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
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import vistas.Usuario;
import vistas.login;
import vistas.principal;
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
    //Variables para recuperar la fecha actual.
    public static Calendar c2 = new GregorianCalendar();
    public static String dia = Integer.toString(c2.get(Calendar.DATE));
    public static String mes = Integer.toString(c2.get(Calendar.MONTH)+1);
    public static String ano = Integer.toString(c2.get(Calendar.YEAR));

    //funcion para loguearse
    
    static public boolean loguear(JTextField primero,JPasswordField password,JLabel jLabel1) throws SQLException{
        
        boolean comprobar = false;
        char[] arrayC = password.getPassword();
        String segundo = new String(arrayC); 
        con=null;
        if(!Usuario.usuario.equals("")){
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
                String selectTableSQL = "SELECT usuario,contrase??a FROM ilerent";
                statement = con.createStatement();
                ResultSet rs = statement.executeQuery(selectTableSQL);
                //recorremos las filas de la tabla
                while (rs.next()) {
                    //guardamos en variables los usuarios registrados para compararlo
                    String usuario = rs.getString("usuario");
                    String contrase??a = rs.getString("contrase??a");
                     entrada_nombre = primero.getText();
                    String entrada_contrase??a = segundo;

                    //si existe dejamos acceso si no damos un error de login
                    if( usuario.equals(entrada_nombre) && contrase??a.equals(entrada_contrase??a)) {
                        
                        //System.out.println("logueado");
                        Usuario.usuario = usuario;
                        
                        
                        comprobar=true;
                        return true;
                        
                    }

                }
                if(comprobar==false){
                    //Muestra un mensaje de error de login
                    JOptionPane.showMessageDialog(null, "Usuario o contrase??a incorrecto.", "Error de login", JOptionPane.ERROR_MESSAGE);
                    AnimationClass mover = new AnimationClass();
                    mover.jLabelYUp(650, 290, 10, 5, jLabel1);
                }
                //Cerramos conexi??n.
                con.close();
            }
            // Si la conexion NO fue exitosa mostramos un mensaje de error
            catch (ClassNotFoundException | SQLException e)
            {
                System.out.println("Error de conexion" + e);
            }
        }else{
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
                String selectTableSQL = "SELECT usuario,contrase??a FROM ilerent";
                statement = con.createStatement();
                ResultSet rs = statement.executeQuery(selectTableSQL);
                //recorremos las filas de la tabla
                while (rs.next()) {
                    //guardamos en variables los usuarios registrados para compararlo
                    String usuario = rs.getString("usuario");
                    String contrase??a = rs.getString("contrase??a");
                     entrada_nombre = primero.getText();
                    String entrada_contrase??a = segundo;

                    //si existe dejamos acceso si no damos un error de login
                    if( usuario.equals(entrada_nombre) && contrase??a.equals(entrada_contrase??a)) {
                        
                        //System.out.println("logueado");
                        Usuario.usuario = usuario;
                        new principal().setVisible(true);
                        comprobar=true;
                        return true;
                        
                    }

                }
                if(comprobar==false){
                    //Muestra un mensaje de error de login
                    JOptionPane.showMessageDialog(null, "Usuario o contrase??a incorrecto.", "Error de login", JOptionPane.ERROR_MESSAGE);
                    AnimationClass mover = new AnimationClass();
                    mover.jLabelYUp(650, 290, 10, 5, jLabel1);
                }
                //Cerramos conexi??n.
                con.close();
            }
            // Si la conexion NO fue exitosa mostramos un mensaje de error
            catch (ClassNotFoundException | SQLException e)
            {
                System.out.println("Error de conexion" + e);
            }
        }
    return false;
            
            
    }
     public  static void registrar(JTextField usuario,JTextField correo,JPasswordField contrase??a,JPasswordField contrase??a1) throws SQLException{
        //Recuperamos la contrase??a     
        char[] arrayC = contrase??a.getPassword();
        String primero = new String(arrayC);
        char[] arrayC1 = contrase??a1.getPassword();
        String segundo = new String(arrayC1); 
        String contrase??ac = primero;
        String contrase??ac1 = segundo;
        boolean comprobante = false;
        
        //comparamos que las dos contrase??as sean iguales a la hora de registrar
        if(contrase??ac.equals(contrase??ac1)&&!primero.equals("")&&!segundo.equals("")&& email(correo.getText())==true){
        //revisamos que el usuario escogido no haya ya uno en la base de datos
            Statement statement;
            con = DriverManager.getConnection(url, user, pass);
            String selectTableSQL = "SELECT usuario FROM ilerent";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                //Recuperamos datos de la base de datos sobre comprobar que el nombre del usuario no esta repetido.
                String usuario1 = rs.getString("usuario");

                String entrada_usuario = usuario.getText();

                if(usuario1.equals(entrada_usuario)) {
                    //Si es igual saldr?? un error de registro.
                    JOptionPane.showMessageDialog(null, "Error de registro", "Confirmaci??n Registro", JOptionPane.ERROR_MESSAGE);
                    
                    comprobante = true;
                    //Cerramos conexi??n
                    con.close();
                    
                    break;
                    
                } else{
                //Si es falso hariamos el registro.    
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
                    //Insertamos datos en la base de datos 
                    String query = "INSERT INTO ilerent (usuario,Correo,contrase??a) values ('"+usuario.getText()+"','"+correo.getText()+"','"+contrase??ac+"');";
                    st.executeUpdate(query);
                    System.out.println("ingresado");
                    query = "INSERT INTO datos_user (Usuario,Nombre,Apellidos,Direccion,Fecha_Nacimiento,Movil,Correo) values ('"+usuario.getText()+"','"+""+"','"+""+"','"+""+"','"+""+"','"+""+"','"+correo.getText()+"');";
                    st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Registrado correctamente", "Confirmaci??n Registro", JOptionPane.INFORMATION_MESSAGE);
                    
                    registro.comprobante = true;
                    //Cerramos conexi??n
                    con.close();
                    }
                    // Si la conexion NO fue exitosa mostramos un mensaje de error
                    catch (ClassNotFoundException | SQLException e)
                    {
                        System.out.println("Error de conexion" + e);
                    }

                }
        }else if((!contrase??ac.equals(contrase??ac1))||usuario.getText().equals("")||correo.getText().equals("")||primero.equals("")||segundo.equals("")||email(correo.getText())==false){
        
            //Filtro para el registro.
            JOptionPane.showMessageDialog(null, "Error de registro", "Confirmaci??n Registro", JOptionPane.ERROR_MESSAGE);
        
        
        }       
    }
    
    //Filtro de email para el registro.
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
    
    //En esta funci??n recuperamos los datos del usuario para mostrarlo en la ventana del usuario.
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
                    //Devolvemos los datos segun el codigo introducido.
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
    //En esta funci??n actualizamos los datos de la ventana del usuario que introducimos.
    public static void Actu_User(String nombre,String apellidos,String direccion,String fecha,String movil,String correo){
        
        try
        {
            Statement st;
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        st = con.createStatement();
        //Sentencia para actualizar los datos.
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
    
    public static boolean comp_contr(JPasswordField contrase??a){
    
        boolean comprobar = false;
        //Recuperamos la contrase??a.
        char[] arrayC = contrase??a.getPassword();
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
                String selectTableSQL = "SELECT contrase??a FROM ilerent WHERE Usuario= '"+Usuario.usuario+"';";
                statement = con.createStatement();
                ResultSet rs = statement.executeQuery(selectTableSQL);
                //recorremos las filas de la tabla
                while (rs.next()) {
                    
                    //Recogemos la contrase??a en una variable.
                    String contrase??a1 = rs.getString("contrase??a");
                     
                    String entrada_contrase??a = segundo;

                   
                    if(contrase??a1.equals(entrada_contrase??a)) {
                        //Si son iguales las contrase??as devolvemos true para poder cambiarla.
                        comprobar=true;
                        return true;
                        
                    }

                }
                if(comprobar==false){

                    JOptionPane.showMessageDialog(null, "Contrase??a incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
                //Cerramos la conexi??n.
                con.close();
            }
            
            // Si la conexion NO fue exitosa mostramos un mensaje de error
            catch (ClassNotFoundException | SQLException e)
            {
                System.out.println("Error de conexion" + e);
            }
            
    return false;
    
    }
    //Funci??n para actualizar la contrase??a en la ventana del usuario.
    public static void Actu_pass(JPasswordField contrase??a){
        
        char[] arrayC = contrase??a.getPassword();
        String segundo = new String(arrayC); 
        
        try
           {
               Statement st;
               Class.forName(driver);
               con = DriverManager.getConnection(url, user, pass);
           st = con.createStatement();
           String query = "UPDATE ilerent SET contrase??a='"+segundo+"'WHERE Usuario= '"+Usuario.usuario+"';";

           st.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Contrase??a actualizada correctamente", "Actualizado", JOptionPane.INFORMATION_MESSAGE);
           con.close();
           }
           // Si la conexion NO fue exitosa mostramos un mensaje de error
           catch (ClassNotFoundException | SQLException e)
           {
               System.out.println("Error de conexion" + e);
           }
    
    
    
    
    }
    
    public static void GDreserva(int lugar_Ini, int lugar_fin, String fecha_ini, String fecha_fin, int id_coche, String precio){
        //Organizamos los valores de la fecha para poder compararlos posteriormente.
        
        String dia1 =""+fecha_ini.charAt(8)+fecha_ini.charAt(9);
        int dia2 = Integer.parseInt(dia1);
        dia1 = dia2+"";
        String mes1 =""+fecha_ini.charAt(5)+fecha_ini.charAt(6);
        int mes2 = Integer.parseInt(mes1);
        mes1 = mes2+"";
        try
        {
            //Guardamos la reserva.
            Statement st;
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            String query = "INSERT INTO Reservas (lugar_inicio,lugar_destino,fecha_inicio,fecha_fin,id_coche_fk,id_user_fk,precio)values ('"+lugar_Ini+"','"+lugar_fin+"','"+fecha_ini+"','"+fecha_fin+"','"+id_coche+"','"+Usuario.usuario+"','"+precio+"');";
            st.executeUpdate(query);
            System.out.println("ingresado");

            JOptionPane.showMessageDialog(null, "Registrado correctamente", "Confirmaci??n Registro", JOptionPane.INFORMATION_MESSAGE);
            
            //Comparamos las fechas la actual con la que acabamos de meter y mediante el id del vehiculo lo cambiamos a no disponible.
            if(dia.equals(dia1) && mes.equals(mes1)){

                String query2 ="UPDATE Vehiculos SET Estado='Ndisponible' WHERE ID= '"+id_coche+"';";
                st.executeUpdate(query2);
            }

        //Cerramos conexi??n.
        con.close();
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error.
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error de conexion" + e);
        }
    
    }

    public static void revision_fecha() throws SQLException{
        //Revisamos y comparamos las fechas la actual con la de las reservas activas 
        Statement statement;
        con = DriverManager.getConnection(url, user, pass);
        String selectTableSQL = "SELECT id_coche_fk,fecha_fin FROM Reservas";
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        
        
        while (rs.next()) {

            String fecha = rs.getString("fecha_fin");
            int IdCoche = rs.getInt("id_coche_fk");
            String dia1 =""+fecha.charAt(8)+fecha.charAt(9);
            int dia2 = Integer.parseInt(dia1);
            int dia_1 = Integer.parseInt(dia);
            
            String mes1 =""+fecha.charAt(5)+fecha.charAt(6);
            int mes2 = Integer.parseInt(mes1);
            int mes_1 = Integer.parseInt(mes);
            
            //Si las fechas de las reservas son inferior a la fecha actual llamamos a la funcion de ress_disp para restablecer la disponibilidad del vehiculo.
            
            if(mes2 < mes_1){
            
                ress_disp(IdCoche);
            
            }
            
            if(mes2 == mes_1 && dia2 < dia_1){
            
                ress_disp(IdCoche);
            
            }
            
        }
        //Cerramos conexi??n
        con.close();
    }
    
    public static void ress_disp(int id_coche){
        //En esta funci??n restablecemos la disponibilidad del veh??culo a disponible del id que pasamos por argumento.
        try
        {
            Statement st;
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        st = con.createStatement();
        String query ="UPDATE Vehiculos SET Estado='Ndisponible' WHERE ID= '"+id_coche+"';";                    
        st.executeUpdate(query);

        con.close();
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error de conexion" + e);
        }
        
    }
}
