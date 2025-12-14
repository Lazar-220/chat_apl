/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milos
 */
public class Konfiguracija {
    private static Konfiguracija instance;
    private Properties konfiguracija;
    String putanja="C:\\PS_nakonBlokade\\88_Cet_Jan_2024_Server\\config\\app.config";

    public static Konfiguracija getInstance() {
        if(instance==null){
            instance=new konfiguracija.Konfiguracija();
        }
        return instance;
    }

    private Konfiguracija() {
        konfiguracija=new Properties();
        File configFile=new File(putanja);
        
        if(!configFile.exists()){
            configFile.getParentFile().mkdirs();
            konfiguracija.setProperty("maks_br_kl", "5");
            sacuvajIzmene();
        }else{
            try {
                FileInputStream fis=new FileInputStream(configFile);
                konfiguracija.load(fis);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public String getProperty(String key){
        return konfiguracija.getProperty(key, "n/a");
    }
    public void setProperty(String key,String value){
        konfiguracija.setProperty(key, value);
    }

    private void sacuvajIzmene() {
        try {
            konfiguracija.store(new FileOutputStream(putanja), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
