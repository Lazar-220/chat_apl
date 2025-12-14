/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.ServerskaForma;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milos
 */
public class OsveziTabelu extends Thread {
    private boolean kraj=false;
    private ServerskaForma sf;

    public OsveziTabelu(ServerskaForma sf) {
        this.sf = sf;
    }

    
    @Override
    public void run() {
        while(!kraj){
            try {
                sf.popuniTabelu();
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OsveziTabelu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
