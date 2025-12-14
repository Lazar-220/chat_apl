/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.KlijentskaForma;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milos
 */
public class Nit extends Thread {
    private KlijentskaForma kf;
    private boolean kraj=false;

    public Nit(KlijentskaForma kf) {
        this.kf = kf;
    }

    
    @Override
    public void run() {
        while(!kraj){
            try {
                kf.osvezi();
                kf.popuniTextField();
                kf.popuniTabelu();
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Nit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
