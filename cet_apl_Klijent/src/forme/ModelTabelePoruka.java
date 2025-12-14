/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Poruka;

/**
 *
 * @author milos
 */
public class ModelTabelePoruka extends AbstractTableModel {

    private List<Poruka>lista;
    private static String[]kolone={"Posiljalac","Datum i vreme","Sadrzaj"};

    public ModelTabelePoruka(List<Poruka> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Poruka p=lista.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");
        switch (columnIndex) {
            case 0:
                return p.getPosiljalac();
            case 1:
                return sdf.format(p.getDatumVreme());
            case 2:
                return p.getSadrzaj();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
