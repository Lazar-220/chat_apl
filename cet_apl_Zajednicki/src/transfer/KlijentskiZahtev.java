/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author milos
 */
public class KlijentskiZahtev implements Serializable {
    private int opeacija;
    private Object param;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int opeacija, Object param) {
        this.opeacija = opeacija;
        this.param = param;
    }

    public int getOpeacija() {
        return opeacija;
    }

    public void setOpeacija(int opeacija) {
        this.opeacija = opeacija;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }
    
}
