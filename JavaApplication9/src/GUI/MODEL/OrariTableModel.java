/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MODEL;


import BLL.Orari;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class OrariTableModel extends AbstractTableModel {
    
    List <Orari> list;
    String [] cols = {"Nr." , "fillimi", "mbarimi"};
    
    public OrariTableModel(){}
    
    public OrariTableModel(List<Orari> list){
        this.list = list;
    }
    
    public void addList(List<Orari> list){
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
    
    public Orari getOrari(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Orari o = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return o.getId();
            case 1:
                return o.getFillimi();
            case 2:
                return o.getMbarimi();
            default:
                return null;
        }
    }
}