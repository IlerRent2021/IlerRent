/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *
 * @author alumno
 */
public class Logica {
   
    public void timer(){
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            int countdownStarter = 10;
            
            @Override
            public void run(){
                countdownStarter--;
                
                if (countdownStarter < 0){
            
                //System.exit(0);
            
                }
            }
         
        };
         scheduler.scheduleAtFixedRate(runnable, 0, 5, SECONDS);
    }
    
    
}
