/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class geocodificacion {
//    String sURL="https://nominatim.openstreetmap.org/search/";
//    double lat;
//    double lon;
//    int zoom;
//    int nPalabras;
//    String direccion;
//
//    public geocodificacion(String buscar) {
//        try {
//            nPalabras=calcularNPalabras(buscar);
//            sURL+=buscar+"?format=json&addressdetails=1&limit="+nPalabras;
//            // Connectar la url a java
//            URL url = new URL(sURL);
//
//            URLConnection request = url.openConnection();
//            request.connect();
//            
//            //Parsear JSON
//            JsonParser jp = new JsonParser(); 
//            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
//            JsonArray rootarr = root.getAsJsonArray(); //Para convertirlo en array
//            JsonObject rootobj=(JsonObject) rootarr.get(0); //para sacar el objeto
//            //para sacar los datos
//            lat = rootobj.get("lat").getAsDouble(); 
//            lon = rootobj.get("lon").getAsDouble();
//            zoom=calculaZoom(rootobj);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(geocodificacion.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(geocodificacion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public geocodificacion( double lat,double lon) {
//        try{
//
//            sURL="https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat="+lat+"&lon="+lon;
//            // Connectar la url a java
//            URL url = new URL(sURL);
//
//            URLConnection request = url.openConnection();
//            request.connect();
//            this.lat=lat;
//            this.lon=lon;
//            //Parsear JSON
//            JsonParser jp = new JsonParser(); 
//            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
//            JsonObject rootobj = root.getAsJsonObject(); //Para convertirlo en array
//            ///JsonObject rootobj=(JsonObject) rootarr.get(0); //para sacar el objeto
//            //para sacar los datos
//            this.direccion=rootobj.get("name").getAsString();
//            zoom=calculaZoom(rootobj);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(geocodificacion.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(geocodificacion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public double getLat() {
//        return lat;
//    }
//
//    public void setLat(double lat) {
//        this.lat = lat;
//    }
//
//    public double getLon() {
//        return lon;
//    }
//
//    public void setLon(double lon) {
//        this.lon = lon;
//    }
//
//    public int getZoom() {
//        return zoom;
//    }
//
//    public void setZoom(int zoom) {
//        this.zoom = zoom;
//    }
//
//    public String getDireccion() {
//        return direccion;
//    }
//
//    public void setDireccion(String direccion) {
//        this.direccion = direccion;
//    }
//    
//    
//    private int calculaZoom(JsonObject rootobj){
//        int zoomLevel;
//        JsonArray boundingbox = rootobj.get("boundingbox").getAsJsonArray();
//            List listbb = new ArrayList();
//            for (JsonElement bb : boundingbox) {
//                listbb.add(bb.getAsString());
//            }
//        double latMin  =Double.parseDouble(listbb.get(0).toString());
//        double latMax  =Double.parseDouble(listbb.get(1).toString());
//        double lngMin  =Double.parseDouble(listbb.get(2).toString());
//        double lngMax  =Double.parseDouble(listbb.get(3).toString());
//        
//        double latDiff = latMax - latMin;
//        double lngDiff = lngMax - lngMin;
//
//        double maxDiff = (lngDiff > latDiff) ? lngDiff : latDiff;
//        if (maxDiff < 360 / Math.pow(2, 20)) {
//            zoomLevel = 21;
//        } else {
//            zoomLevel = (int) (-1*( (Math.log(maxDiff)/Math.log(2)) - (Math.log(360)/Math.log(2))));
//            if (zoomLevel < 1)
//                zoomLevel = 1;
//
//            }
//        return zoomLevel;
//    }
//
//    private int calcularNPalabras(String buscar) {
//        int num=1;
//        for(Character c:buscar.toCharArray()){
//            if(Character.isWhitespace(c)){
//                num++;
//            }
//        }
//        return num;
//    }
}

