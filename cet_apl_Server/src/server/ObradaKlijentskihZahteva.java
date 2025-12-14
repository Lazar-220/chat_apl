/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Poruka;
import model.User;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author milos
 */
public class ObradaKlijentskihZahteva extends Thread {
    private Socket s;

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while(true){
            KlijentskiZahtev kz=primiZahtev();
            ServerskiOdgovor so=new ServerskiOdgovor();
            switch (kz.getOpeacija()) {
                case operacije.Operacije.login:
                    List<User>lista=controller.Controller.getInstance().vratiUsere();
                    User user=(User) kz.getParam();
                    if(controller.Controller.getInstance().getOnlineUseri().contains(user)){
                        user=null;
                    }
                    if(controller.Controller.getInstance().getOnlineUseri().size()>=Integer.parseInt(controller.Controller.getInstance().getKapacitet())){
                        System.out.println(controller.Controller.getInstance().getKapacitet());
                        user=new User(-3,"","");
                    }
                    for(User u:lista){
                        if(u.equals(user)){
                            user.setId(u.getId());
                            controller.Controller.getInstance().dodajOnlineUsera(user);
                            break;
                        }
                    }
                    so.setOdgovor(user);
                    break;
                case operacije.Operacije.logout:
                    controller.Controller.getInstance().ukloniOnlineUsera((User)kz.getParam());
                    break;
                case operacije.Operacije.vratiOnlineUsere:
                    so.setOdgovor(controller.Controller.getInstance().getOnlineUseri());
                    break;
                case operacije.Operacije.posaljiIzabranom:
                    controller.Controller.getInstance().posaljiIzabranom((Poruka)kz.getParam());
                    so.setOdgovor("Uspeh");
                    break;
                case operacije.Operacije.vratiPoslednjuPoruku:
                    List<Poruka> poruke=controller.Controller.getInstance().vratiPoslednjuPoruku((User)kz.getParam());
                    if(poruke.isEmpty()){
                        so.setOdgovor("");
                    }else{
                        Poruka p=poruke.get(poruke.size()-1);
                        System.out.println(p);
                        so.setOdgovor(p.toString());
                    }
                    break;
                case operacije.Operacije.vratiPoruke:
                    List<Poruka> svePoruke=controller.Controller.getInstance().vratiPoruke((User)kz.getParam());
                    so.setOdgovor(svePoruke);
                    break;
                default:
                    System.out.println("greska");
            }
            posaljiOdgovor(so);
        }
    }

    public KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
