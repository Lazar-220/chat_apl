/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Poruka;
import model.User;

/**
 *
 * @author milos
 */
public class Controller {

    private String kapacitet="10";
    private List<User>onlineUseri=new ArrayList<>();
    private static Controller instance;
    private DBBroker dbb;

    public String getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(String kapacitet) {
        this.kapacitet = kapacitet;
    }

    
    public List<User> getOnlineUseri() {
        return onlineUseri;
    }

    public void setOnlineUseri(List<User> onlineUseri) {
        this.onlineUseri = onlineUseri;
    }

    
    public static Controller getInstance() {
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }
    

    private Controller() {
        dbb=new DBBroker();
        
    }

    public List<User> vratiUsere() {
        return dbb.vratiUsere();
    }

    public void dodajOnlineUsera(User user) {
        onlineUseri.add(user);
    }

    public void ukloniOnlineUsera(User user) {
        onlineUseri.remove(user);
    }

    public void posaljiIzabranom(Poruka poruka) {
        dbb.posaljiIzabranom(poruka);
    }

    public List<Poruka> vratiPoslednjuPoruku(User user) {
        return dbb.vratiPoslednjuPoruku(user);
    }

    public List<Poruka> vratiPoruke(User user) {
        return dbb.vratiPoruke(user);
    }
    
}
