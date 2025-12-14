/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Poruka;
import model.User;

/**
 *
 * @author milos
 */
public class DBBroker {

    public List<User> vratiUsere() {
        List<User>lista=new ArrayList<>();
        try {
            String upit="SELECT * FROM USER";
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs=st.executeQuery(upit);
            while(rs.next()){
                int id=rs.getInt(1);
                String username=rs.getString(2);
                String password=rs.getString(3);
                User u=new User(id, username, password);
                lista.add(u);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void posaljiIzabranom(Poruka poruka) {
        try {
            String upit="INSERT INTO poruka(posiljalac_id,primalac_id,sadrzaj,datumVreme) VALUES (?,?,?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, poruka.getPosiljalac().getId());
            ps.setInt(2, poruka.getPrimalac().getId());
            ps.setString(3, poruka.getSadrzaj());
            Timestamp datumSql=new Timestamp(poruka.getDatumVreme().getTime());
            ps.setTimestamp(4, datumSql);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Poruka> vratiPoslednjuPoruku(User user) {
        List<Poruka>lista=new ArrayList<>();
        try {
            String upit="SELECT * FROM poruka p JOIN USER pos ON p.posiljalac_id=pos.id JOIN USER pr ON p.primalac_id=pr.id WHERE primalac_id=? ORDER BY datumVreme ASC";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, user.getId());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("p.id");
                User posiljalac=new User(rs.getInt("pos.id"), rs.getString("pos.username"), rs.getString("pos.password"));
               User primalac=new User(rs.getInt("pr.id"), rs.getString("pr.username"), rs.getString("pr.password"));
               String sadrzaj=rs.getString("p.sadrzaj");
               Timestamp datumSql=rs.getTimestamp("p.datumVreme");
               Date datum=new Date(datumSql.getTime());
               Poruka p=new Poruka(id, posiljalac, primalac, sadrzaj, datum);
               lista.add(p);
            }
            } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Poruka> vratiPoruke(User user) {
        List<Poruka>lista=new ArrayList<>();
        try {
            String upit="SELECT * FROM poruka p JOIN USER pos ON p.posiljalac_id=pos.id JOIN USER pr ON p.primalac_id=pr.id WHERE primalac_id=? ORDER BY datumVreme DESC";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, user.getId());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("p.id");
                User posiljalac=new User(rs.getInt("pos.id"), rs.getString("pos.username"), rs.getString("pos.password"));
                User primalac=new User(rs.getInt("pr.id"), rs.getString("pr.username"), rs.getString("pr.password"));
                String sadrzaj=rs.getString("p.sadrzaj");
                Timestamp datumSql=rs.getTimestamp("p.datumVreme");
                Date datum=new Date(datumSql.getTime());
                Poruka p=new Poruka(id, posiljalac, primalac, sadrzaj, datum);
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
