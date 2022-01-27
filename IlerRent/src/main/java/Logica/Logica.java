/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.Conexion;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparingDouble;
import java.util.HashMap;
import java.util.Iterator;
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

    private HashMap<String,String> filtros;

    public Logica() {
        this.conexion=new Conexion();
        this.coches=new ArrayList<>();
        filtros=new HashMap();
    }

    
    public void añadirCoches(JPanel panelCoches) {
        panelCoches.removeAll();
    

        List<Vehiculo> vehiculos=conexion.MostrarVehiculo();
        
        if(vehiculos!=null){
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
    }
    public panelCoches CompruebaModelo(panelCoches coche){
        if((filtros.get("modelo").equals(coche.getVehiculo().getMarca()))){
                                coche.setVisible(true);
        }
        return coche;
        
    }
    public void filtrarCoches(JPanel panelCoches, String tipo, String valor, boolean flag ) {
        panelCoches.removeAll();
        //coches.removeAll(coches);

        
        
        
        for(int i=0;i<coches.size();i++){
            int cuentafiltros=0;
            switch(tipo){
                case "precio":
                    filtros.put(tipo, valor);
                    
                    if(flag){
                        cuentafiltros++;
                        double preciocoche=Double.parseDouble(coches.get(i).getVehiculo().getPrecio().replace(",", "."));
                        double preciofiltro=Double.parseDouble(valor);
                        if(preciocoche<preciofiltro)
                        {   
                            
                            if((filtros.get("modelo")!=null)&&(filtros.get("modelo").equals(coches.get(i).getVehiculo().getMarca()))){
                                cuentafiltros++;
                            }
                            if((filtros.get("motor")!=null)&&(filtros.get("motor").equals(coches.get(i).getVehiculo().getCombustible()))){
                                cuentafiltros++;
                            }
                            if((filtros.get("sede")!=null)&&(Integer.parseInt(filtros.get("sede"))==(coches.get(i).getVehiculo().getSede()))){
                                cuentafiltros++;
                            }
                            if(filtros.size()==cuentafiltros){
                                coches.get(i).setVisible(true);
                            }else{
                                coches.get(i).setVisible(false);
                            }
 
                            
////////                            
////////                            if((filtros.get("modelo")!=null)&&(filtros.get("modelo").equals(coches.get(i).getVehiculo().getMarca()))){
////////                                coches.get(i).setVisible(true);
////////                            }
////////                            if((filtros.get("motor")!=null)&&(filtros.get("motor").equals(coches.get(i).getVehiculo().getCombustible()))){
////////                                coches.get(i).setVisible(true);
////////                            }
////////                            if((filtros.get("sede")!=null)&&(Integer.parseInt(filtros.get("sede"))==(coches.get(i).getVehiculo().getSede()))){
////////                                coches.get(i).setVisible(true);
////////                            }
                        }else{
                            coches.get(i).setVisible(false);
                        }
                    }
                    else{
                        if(Double.parseDouble(coches.get(i).getVehiculo().getPrecio())>Double.parseDouble(valor))
                        {    
                        coches.get(i).setVisible(true);
                        }
                    }
                    break;
                    
                    case "modelo":
                        if(flag){
                            cuentafiltros++;
                            
                            filtros.put(tipo, valor);
                            if(coches.get(i).getVehiculo().getMarca().equals(valor))
                            {    
                                if((filtros.get("motor")!=null)&&(filtros.get("motor").equals(coches.get(i).getVehiculo().getCombustible()))){
                                    cuentafiltros++;
                                }
                                if((filtros.get("precio")!=null)&&(Double.parseDouble(filtros.get("precio"))>Double.parseDouble((coches.get(i).getVehiculo().getPrecio())))){
                                    cuentafiltros++;
                                }
                                if((filtros.get("sede")!=null)&&(Integer.parseInt(filtros.get("sede"))==(coches.get(i).getVehiculo().getSede()))){
                                    cuentafiltros++;
                                }
                                if(filtros.size()==cuentafiltros){
                                    coches.get(i).setVisible(true);
                                }else{
                                    coches.get(i).setVisible(false);
                                }
////                                if((filtros.get("motor")!=null)&&(filtros.get("motor").equals(coches.get(i).getVehiculo().getCombustible()))){
////                                    coches.get(i).setVisible(true);
////                                }
////                                if((filtros.get("precio")!=null)&&(Double.parseDouble(filtros.get("precio"))>Double.parseDouble((coches.get(i).getVehiculo().getPrecio())))){
////                                    coches.get(i).setVisible(true);
////                                }
////                                if((filtros.get("sede")!=null)&&(Integer.parseInt(filtros.get("sede"))==(coches.get(i).getVehiculo().getSede()))){
////                                    coches.get(i).setVisible(true);
////                                }
                            
                            }else{
                                        coches.get(i).setVisible(false);
                            }
                        }
                        else if(!coches.get(i).getVehiculo().getMarca().equals(valor)){
                            filtros.remove(tipo);    

                            if((filtros.get("motor")!=null)&&(filtros.get("motor").equals(coches.get(i).getVehiculo().getCombustible()))){
                                    cuentafiltros++;
                                }
                                if((filtros.get("precio")!=null)&&(Double.parseDouble(filtros.get("precio"))>Double.parseDouble((coches.get(i).getVehiculo().getPrecio())))){
                                    cuentafiltros++;
                                }
                                if((filtros.get("sede")!=null)&&(Integer.parseInt(filtros.get("sede"))==(coches.get(i).getVehiculo().getSede()))){
                                    cuentafiltros++;
                                }
                                if(filtros.size()==cuentafiltros){
                                    coches.get(i).setVisible(true);
                                }


                        }
                        
                    
                    break;
                    case "motor":
                    if(flag){
                        filtros.put(tipo, valor);
                        cuentafiltros++;
                        
                        if(coches.get(i).getVehiculo().getCombustible().equals(valor))
                        {    
                            if((filtros.get("modelo")!=null)&&(filtros.get("modelo").equals(coches.get(i).getVehiculo().getMarca()))){
                                cuentafiltros++;
                            }
                            if((filtros.get("precio")!=null)&&(Double.parseDouble(filtros.get("precio"))>Double.parseDouble((coches.get(i).getVehiculo().getPrecio())))){
                                cuentafiltros++;
                            }
                            if((filtros.get("sede")!=null)&&(Integer.parseInt(filtros.get("sede"))==(coches.get(i).getVehiculo().getSede()))){
                                cuentafiltros++;;
                            }
                            if(filtros.size()==cuentafiltros){
                                coches.get(i).setVisible(true);
                            }else{
                                    coches.get(i).setVisible(false);
                                }
////                            if((filtros.get("modelo")!=null)&&(filtros.get("modelo").equals(coches.get(i).getVehiculo().getMarca()))){
////                                coches.get(i).setVisible(true);
////                            }
////                            if((filtros.get("precio")!=null)&&(Double.parseDouble(filtros.get("precio"))>Double.parseDouble((coches.get(i).getVehiculo().getPrecio())))){
////                                    coches.get(i).setVisible(true);
////                            }
////                            if((filtros.get("sede")!=null)&&(Integer.parseInt(filtros.get("sede"))==(coches.get(i).getVehiculo().getSede()))){
////                                coches.get(i).setVisible(true);
////                            }
                        }else{
                            coches.get(i).setVisible(false);
                        }
                    }
                    else if(!coches.get(i).getVehiculo().getCombustible().equals(valor)){
                           filtros.remove(tipo);
                            
                        if((filtros.get("modelo")!=null)&&(filtros.get("modelo").equals(coches.get(i).getVehiculo().getMarca()))){
                                cuentafiltros++;
                            }
                            if((filtros.get("precio")!=null)&&(Double.parseDouble(filtros.get("precio"))>Double.parseDouble((coches.get(i).getVehiculo().getPrecio())))){
                                cuentafiltros++;
                            }
                            if((filtros.get("sede")!=null)&&(Integer.parseInt(filtros.get("sede"))==(coches.get(i).getVehiculo().getSede()))){
                                cuentafiltros++;;
                            }
                            if(filtros.size()==cuentafiltros){
                                coches.get(i).setVisible(true);
                            }
                        
                        
                    }
                    break;
                    case "sede":
                        int idsede = buscarsede(valor).getId();
                        if(flag){
                            filtros.put(tipo, Integer.toString(idsede));
                            cuentafiltros++;
                            if(coches.get(i).getVehiculo().getSede()==(idsede))
                            {
                                if((filtros.get("modelo")!=null)&&(filtros.get("modelo").equals(coches.get(i).getVehiculo().getMarca()))){
                                    cuentafiltros++;
                                }
                                if((filtros.get("precio")!=null)&&(Double.parseDouble(filtros.get("precio"))>Double.parseDouble((coches.get(i).getVehiculo().getPrecio())))){
                                    cuentafiltros++;
                                }
                                if((filtros.get("motor")!=null)&&(filtros.get("motor").equals(coches.get(i).getVehiculo().getCombustible()))){
                                    cuentafiltros++;
                                }
                                if(filtros.size()==cuentafiltros){
                                    coches.get(i).setVisible(true);
                                }else{
                                    coches.get(i).setVisible(false);
                                }
////                                if((filtros.get("modelo")!=null)&&(filtros.get("modelo").equals(coches.get(i).getVehiculo().getMarca()))){
////                                coches.get(i).setVisible(true);
////                                }
////                                if((filtros.get("precio")!=null)&&(Double.parseDouble(filtros.get("precio"))>Double.parseDouble((coches.get(i).getVehiculo().getPrecio())))){
////                                    coches.get(i).setVisible(true);
////                                }
////                                if((filtros.get("motor")!=null)&&(filtros.get("motor").equals(coches.get(i).getVehiculo().getCombustible()))){
////                                    coches.get(i).setVisible(true);
////                                }
                            
                            }else{
                                    coches.get(i).setVisible(false);
                                }
                        }
                        else if(coches.get(i).getVehiculo().getSede()!=(idsede)){
                            filtros.remove(Integer.toString(idsede));
                            
                                if((filtros.get("modelo")!=null)&&(filtros.get("modelo").equals(coches.get(i).getVehiculo().getMarca()))){
                                    cuentafiltros++;
                                }
                                if((filtros.get("precio")!=null)&&(Double.parseDouble(filtros.get("precio"))>Double.parseDouble((coches.get(i).getVehiculo().getPrecio())))){
                                    cuentafiltros++;
                                }
                                if((filtros.get("motor")!=null)&&(filtros.get("motor").equals(coches.get(i).getVehiculo().getCombustible()))){
                                    cuentafiltros++;
                                }
                                if(filtros.size()==cuentafiltros){
                                    coches.get(i).setVisible(true);
                                }
                            

                            

                        }
                    break;

                    
            }
        }

        //para pintar en el panel
         for(int i=0;i<coches.size();i++){
            if(coches.get(i).isVisible())
                panelCoches.add(coches.get(i));
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

    public void deshabilitarElementoPanel(JPanel panelLista) {
        
    }

    public void deshabilitarElementoPanel(JPanel panelLista, boolean selected) {
        Component[] components=panelLista.getComponents();
        for(Component c:components){
            if(c instanceof panelCoches){
                    if(((panelCoches) c).getjCheckBox1().isSelected())
                    c.setEnabled(false);
                
            }
        }
    }

    

    public void añadirReservasActivas(JPanel jPanelReservasActivasPaneles) {
        
    }

    
}
