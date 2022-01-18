/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ilerrent;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Logica {
    Conexion conexion;
    
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
