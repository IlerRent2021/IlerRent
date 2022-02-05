/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.BBDD;
import Conexion.Conexion;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparingDouble;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vistas.ReservaVista;
import vistas.login;
import vistas.panelCoches;

/**
 *
 * @author alumno
 */
public class Logica {
    private Conexion conexion;
    //private Usuario usuario;
    private List<panelCoches> coches;
    List<ReservaVista> reservasActivasVista;
    private Reserva reservaActual;
    private HashMap<String,String> filtros;
    private static boolean cerrar=false;
    public Logica() {
        this.conexion=new Conexion();
        this.coches=new ArrayList<>();
        filtros=new HashMap();
        reservaActual=new Reserva();
        this.reservasActivasVista=new ArrayList<>();
        
        
        
    }

    public static boolean isCerrar() {
        return cerrar;
    }

    public static void setCerrar(boolean cerrar) {
        Logica.cerrar = cerrar;
    }

    //Añade todos los coches al panel coches para luego mostrarlos
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
    //seter y getter de reserva
    public Reserva getReservaActual() {
        return reservaActual;
    }

    public void setReservaActual(Reserva reservaActual) {
        this.reservaActual = reservaActual;
    }
    
    //metodo que te filtrara la lista de los coches segun los parametros tipo y valor
    public void filtrarCoches(JPanel panelCoches, String tipo, String valor, boolean flag ) {
        panelCoches.removeAll();
        //coches.removeAll(coches);

        
        
        //recorrela lista de los coches
        for(int i=0;i<coches.size();i++){
            int cuentafiltros=0;
            //switch que te filtrará los coches segun el filtro que te pase la funcion
            switch(tipo){
                case "precio":
                    filtros.put(tipo, valor);
                    //este if es para saber si es para poner o quitar el filtro pasado
                    if(flag){
                        cuentafiltros++;
                        double preciocoche=Double.parseDouble(coches.get(i).getVehiculo().getPrecio().replace(",", "."));
                        double preciofiltro=Double.parseDouble(valor);
                        if(preciocoche<preciofiltro)
                        {   
                            //estos if es para comprobar tambien los otros filtros
                            if((filtros.get("modelo")!=null)&&(filtros.get("modelo").equals(coches.get(i).getVehiculo().getMarca()))){
                                cuentafiltros++;
                            }
                            if((filtros.get("motor")!=null)&&(filtros.get("motor").equals(coches.get(i).getVehiculo().getCombustible()))){
                                cuentafiltros++;
                            }
                            if((filtros.get("sede")!=null)&&(Integer.parseInt(filtros.get("sede"))==(coches.get(i).getVehiculo().getSede()))){
                                cuentafiltros++;
                            }
                            //si se cumplen se vuelve el panel visible si no, invisibles
                            if(filtros.size()==cuentafiltros){
                                coches.get(i).setVisible(true);
                            }else{
                                coches.get(i).setVisible(false);
                            }
 
                            
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
                        //si la booleana es para saber si es para restringir la lista o no
                        //si es asi sumamen el contador y añadimos el filtro en la lista con los filtros usados
                        if(flag){
                            cuentafiltros++;
                            
                            filtros.put(tipo, valor);
                            if(coches.get(i).getVehiculo().getMarca().equals(valor))
                            {    //si se cumple se comprueban los otros filtros que hay en la lista de filtros
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
                            
                            }else{
                                coches.get(i).setVisible(false);
                            }
                        }
                        //esto es para quitar el filtro indicado
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
                    //este case funciona igual que el anterior
                    //se comprueba si es para poner o quitar el filtro y se comprueban 
                    //los filtros que ya tenemos guardado
                    //si es para quitarlo, se quita el filtro de nuestra lista y se ponen visibles los que cumplan los otros filtros.
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
                    //este funciona igual que el anterior
                    //se comprueba si es para poner o quitar el filtro y se comprueban 
                    //los filtros que ya tenemos guardado
                    //si es para quitarlo, se quita el filtro de nuestra lista y se ponen visibles los que cumplan los otros filtros.
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

        //se pintan en el panel solo los paneles visibles
         for(int i=0;i<coches.size();i++){
            if(coches.get(i).isVisible())
                panelCoches.add(coches.get(i));
        }
        panelCoches.updateUI();
    }
    

    //Cronometro para resetear los datos metidos al pasar cierto tiempo
        public void timer(JFrame panel){
            
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            
            int countdownStarter = 180;
            int x_antiguo = 0;
            int y_antiguo = 0;
            @Override
            public void run(){
                if(cerrar==true){
                    panel.setVisible(false);
                    cerrar=false;
                }
                countdownStarter--;
                
                Point punto=MouseInfo.getPointerInfo().getLocation();
                int x=punto.x;
                int y=punto.y;
                
                if(x != x_antiguo && y != y_antiguo){
                    countdownStarter = 180;
                }
                
                x_antiguo = x;
                y_antiguo = y;
                
                if (countdownStarter < 0){
            
                    System.out.println("parado");
                    
                    //panel.dispose();
                    new login().setVisible(true);
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

    //funcion que te habilita o desabilita los paneles para seleccionar el coche
    public void habilita(JPanel jPanel1) {
       Component[]components=jPanel1.getComponents();
       //recorre los paneles
        for (Component component : components) {
            if (component instanceof panelCoches) {
                //si esta el booleano de habilitar todos en true se pone el checkbox 
                //habilitado
                if(((panelCoches)component).isFlagHabilitatodos()){

                    ((panelCoches) component).getjCheckBox1().setEnabled(true);
                //si no esta en true pero la booleana de habilitar  solo ese 
                //tambien, se habilita el checkbox
                }else if(((panelCoches)component).isFlagHabilita()){

                    ((panelCoches) component).getjCheckBox1().setEnabled(true);
                    //en caso contrario de deshabilita
                }else{
                    
                     ((panelCoches) component).getjCheckBox1().setEnabled(false);
                }
            }
        }
        jPanel1.updateUI();
    }

    //metodo que te devuelve el vehiculo del coche seleccionado
    //si esta seleccionado se devuelve el vehiculo en caso contrario, se devolverá null
    public Vehiculo cocheSeleccionado(JPanel jPanelListadoCoches) {
       Component[]components=jPanelListadoCoches.getComponents();
       
        for (Component component : components) {
            if (component instanceof panelCoches) {
                if(((panelCoches)component).getjCheckBox1().isSelected()){
                    return((panelCoches) component).getVehiculo();
                }
            }
        }
        return null;
    }

    //metodo que conectara con la clase de conexion para añadir la reserva
    public void añadirReserva() {
        BBDD.GDreserva(reservaActual.getLugar_inicio().getId(), reservaActual.getLugar_destino().getId(), FormatearFecha(reservaActual.getFecha_inicio()), FormatearFecha(reservaActual.getFecha_destino()), reservaActual.getVehiculo().getID(), reservaActual.getPrecio_total());
    }
    
    public String FormatearFecha(Date date){
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    //metodo que agregara en nuestra lista de reservas, las reservas de un usuario
    public void añadirreservas(String usuario){
        try {
            //conecta con la clase que conecta con la BBDD
            List<Reserva> reservasActivas=conexion.todasreservas(usuario);
            //agrega las reservas 
            if(reservasActivas!=null){
                for (Reserva reserva : reservasActivas) {
                    
                    ReservaVista rv=new ReservaVista(this,reserva);
                   
                    reservasActivasVista.add(rv);
                    
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //agrega las reservas segun la booleana en el panel correspondiente siendo true las activas y false las pasadas
    public void añadirReservasActivas(JPanel jPanelReservasActivasPaneles,boolean flag) {

            jPanelReservasActivasPaneles.removeAll();
            
            for (ReservaVista rv : reservasActivasVista) {
                    
                    //si es true pone visibles las reservas que terminan despues de hoy
                    if(flag){
                        if(rv.getReserva().getFecha_destino().after(new Date())){
                            rv.setVisible(true);
                        }else{
                            rv.setVisible(false);
                        }
                        //si es false pone visibles las anteriores a hoy(Hoy incluido)
                    }else{
                        if(rv.getReserva().getFecha_destino().after(new Date())){
                            rv.setVisible(false);
                        }else{
                            rv.setVisible(true);
                        }
                    }
                    
                    
                    
                }

                
                //para pintar en el panel los paneles visibles
                for(int i=0;i<reservasActivasVista.size();i++){
                    if(reservasActivasVista.get(i).isVisible())
                        jPanelReservasActivasPaneles.add(reservasActivasVista.get(i));
                }
                jPanelReservasActivasPaneles.updateUI();
                //JOptionPane.showMessageDialog(null, "tremendas reservas");
    
       
    }
    //metodo que te calcula el numero de reservas
    public String calculaNreservas(){
        String num= Integer.toString(reservasActivasVista.size());
        return num;
    }
    //metodo que te calcula el precio total invertido en las reservas
    public String calculapreciototalreservas(){
        String num;
        Double precio=0.0;
            for(ReservaVista rv: reservasActivasVista){
                precio+=Double.valueOf(rv.getReserva().getPrecio_total());
            }
            num=Double.toString(precio);
            return num;
    }
    //metodo que te devuelve la marca mas pedida por el usuario
    public String calculamarcafavorita(){
        String marcafav;
        //variable que te guardara el nombre de la marca y las veces que se repite
        HashMap<String, Integer> marcas=new HashMap();
        //recorre todas las revervas    
        for (ReservaVista rv : reservasActivasVista) {
            String marca=rv.getReserva().getVehiculo().getMarca();
            //si la marca ya esta en el diccionario te suma uno en la veces que se repite
            if (marcas.containsKey(marca)) {
              marcas.put(marca, marcas.get(marca) + 1);
              //si no significa que es la primera vez que encuentras esa marca
            } else {
              marcas.put(marca, 1);
            }
        }
        //te devuelve la marca que mas has reservado
        marcafav=Collections.max(marcas.entrySet(), Map.Entry.comparingByValue()).getKey();
            return marcafav;
    }
    
    //este metodo usa la misma logica que el metodo anterior pero con la sede que 
    //mas se repite y comprueba la sede de inicio y la final
    public String calculasedefavorita(){
        String sedefav;
        HashMap<String, Integer> sedes=new HashMap();
            
        for (ReservaVista rv : reservasActivasVista) {
            String sede=rv.getReserva().getLugar_inicio().getCiudad();
            if (sedes.containsKey(sede)) {
              sedes.put(sede, sedes.get(sede) + 1);
            } else {
              sedes.put(sede, 1);
            }
            sede=rv.getReserva().getLugar_destino().getCiudad();
            if (sedes.containsKey(sede)) {
              sedes.put(sede, sedes.get(sede) + 1);
            } else {
              sedes.put(sede, 1);
            }
          }
        sedefav=Collections.max(sedes.entrySet(), Map.Entry.comparingByValue()).getKey();
            return sedefav;
    }
    //este metodo usa la misma logica que el metodo anterior pero con el precio de los coches
    public int calculapreciomaximocoche(){
        int preciomax;
        List<Vehiculo> vehiculos=conexion.MostrarVehiculo();
        HashMap<Vehiculo, Double> sedes=new HashMap();
            
        for (Vehiculo pc : vehiculos) {
            
            
              sedes.put(pc, Double.parseDouble(pc.getPrecio()));
            
            
          }
        preciomax=(int)Collections.max(sedes.entrySet(), Map.Entry.comparingByValue()).getValue().doubleValue();
            return preciomax;
    }
    

    


    
}
