/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.Conexion;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;
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
    
    /*
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
    */
    
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
