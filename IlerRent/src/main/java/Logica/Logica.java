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
//        panelCoches.removeAll();
    
//        List<Vehiculo> vehiculos=conexion.damecoches();
//        for (Vehiculo vehiculo : vehiculos) {
//               
//               panelCoches pc=new panelCoches(panelCoches/*,vehiculo*/,this);
//               coches.add(pc);
//  
//            panelCoches.setPreferredSize(new Dimension(165,165));
//        }
//        
//        //para pintar en el panel
//        for(panelCoches pc:coches){
//                panelCoches.add(pc);
//        }
//        panelCoches.updateUI();
    }
}
