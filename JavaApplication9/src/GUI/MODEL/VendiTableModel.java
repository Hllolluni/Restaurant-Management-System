/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MODEL;


import BLL.Vendi;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendiTableModel extends AbstractTableModel {
    
    List <Vendi> list;
    String [] cols = {"Nr." , "Emertimi"};
    
    public VendiTableModel(){}
    
    public VendiTableModel(List<Vendi> list){
        this.list = list;
    }
    
    public void addList(List<Vendi> list){
        this.list = list;
    }
    
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Vendi getVendi(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vendi v = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return v.getId();
            case 1:
                return v.getEmertimi();
            default:
                return null;
        }
    }
}