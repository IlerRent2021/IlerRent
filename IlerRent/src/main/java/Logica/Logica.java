/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.Conexion;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparingDouble;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vistas.panelCoches;

/**
 *
 * @author alumno
 */
public class Logica {
    private Conexion conexion;
    //private Usuario usuario;
    private List<panelCoches> coches;

    public Logica() {
        this.conexion=new Conexion();
        this.coches=new ArrayList<>();
    }
    
    public void añadirCoches(JPanel panelCoches) {
        panelCoches.removeAll();
    
        List<Vehiculo> vehiculos=conexion.MostrarVehiculo();
        for (Vehiculo vehiculo : vehiculos) {
               
            panelCoches pc=new panelCoches(panelCoches,vehiculo,this);
            coches.add(pc);
  
            pc.setPreferredSize(new Dimension(165,165));
        }
        
        //para pintar en el panel
        for(panelCoches pc:coches){
                panelCoches.add(pc);
        }
        panelCoches.updateUI();
    }
    
        public void filtrarCoches(JPanel panelCoches, String tipo) {
        panelCoches.removeAll();
        coches.removeAll(coches);
    
        List<Vehiculo> vehiculos=conexion.MostrarVehiculoSeleccionado(tipo);
        for (Vehiculo vehiculo : vehiculos) {
               
            panelCoches pc=new panelCoches(panelCoches,vehiculo,this);
            coches.add(pc);
  
            pc.setPreferredSize(new Dimension(165,165));
        }
        
        //para pintar en el panel
        for(panelCoches pc:coches){
                panelCoches.add(pc);
        }
        panelCoches.updateUI();
    }
    
    //Cronometro para resetear los datos metidos al pasar cierto tiempo
        public void timer(){
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            int countdownStarter = 10;
            
            @Override
            public void run(){
                countdownStarter--;
                
                if (countdownStarter < 0){
            
                System.exit(0);
            
                }
            }
         
        };
         scheduler.scheduleAtFixedRate(runnable, 0, 5, SECONDS);
    }
    //metodo que buscar la sede que haya en la ciudad
    //si no hay te mostrará la sede más cercana
    public Sede buscarsede(String sede){
        try {
            Sede s=conexion.buscarSede(sede);
            
            //comprueba si hay sede
            if(s==null){
                JOptionPane.showMessageDialog(null, "No hay sede en la ubicacion escrita, se mostrara la sede mas cercana");
                //esto es para geocodificar la ubicacion escrita
                geocodificacion ub=new geocodificacion(sede);
                //diccionario con las sedes y la distancias a la ubicacion escrita
                HashMap<Sede, Double> distancias=new HashMap();
                //busca a todas las sedes
                List<Sede> sedes=conexion.todasSedes();
                //pone en el diccionario las sedes junto a la distancia a la ubicacion
                for(Sede sed:sedes){
                    distancias.put(sed, distanciaCoord(sed.getLat(),sed.getLon(),ub.getLat(),ub.getLon()));
                }
                //la sede más cercana
                s=getdistanciaMinima(distancias);
                
                
                
            }
            
            return s;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    //metodo que te devuelve la sede más cercana
    public Sede getdistanciaMinima(HashMap<Sede, Double> map){        
    Sede min = Collections.min(map.entrySet(), comparingDouble(Entry::getValue)).getKey() ; 
    return min;
    }
    
    //metodo que te calcula la distancia de dos coordenadas
    public double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
        
        double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(lat2 - lat1);  
        double dLng = Math.toRadians(lng2 - lng1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);
        
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
    }
    //Posible solucion a mis errores no borrar porfa
//    public void CargarImagen(){
//        Blob blob = resultset.getBlob(3);
//        //primero me aseguro que no este vacío.
//        if(blob != null){
//        try{
//            byte[] data = blob.getBytes(1, (int)blob.length());
//            BufferedImage img = null;
//
//        try{
//            img = ImageIO.read(new ByteArrayInputStream(data));
//        }
//        catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//
//        ImageIcon icono = new ImageIcon(img);
//        JOptionPane.showMessageDialog(null, "Imagenes", "Imagen", JOptionPane.INFORMATION_MESSAGE, icono);
//
//        }catch(Exception ex){
//        //No hay imagen
//        }
//    }else{
//        //No hay imagen
//    }
//   }
}
