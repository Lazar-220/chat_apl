/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author milos
 */
public class Poruka implements Serializable {
    private int id;
    private User posiljalac;
    private User primalac;
    private String sadrzaj;
    private Date datumVreme;

    public Poruka() {
    }

    public Poruka(int id, User posiljalac, User primalac, String sadrzaj, Date datumVreme) {
        this.id = id;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.sadrzaj = sadrzaj;
        this.datumVreme = datumVreme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(User posiljalac) {
        this.posiljalac = posiljalac;
    }

    public User getPrimalac() {
        return primalac;
    }

    public void setPrimalac(User primalac) {
        this.primalac = primalac;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    @Override
    public String toString() {
        return posiljalac + ": " + sadrzaj;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poruka other = (Poruka) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.sadrzaj, other.sadrzaj)) {
            return false;
        }
        if (!Objects.equals(this.posiljalac, other.posiljalac)) {
            return false;
        }
        if (!Objects.equals(this.primalac, other.primalac)) {
            return false;
        }
        return Objects.equals(this.datumVreme, other.datumVreme);
    }
    
}
