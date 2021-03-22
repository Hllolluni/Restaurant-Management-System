/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MODEL;


import BLL.Ushqimi;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UshqimiTableModel extends AbstractTableModel {
    
    List <Ushqimi> list;
    String [] cols = {"Nr." , "Emertimi", "cmimiPer1" ,"sasia"};
    
    public UshqimiTableModel(){}
    
    public UshqimiTableModel(List<Ushqimi> list){
        this.list = list;
    }
    
    public void addList(List<Ushqimi> list){
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
    
    public Ushqimi getUshqimi(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ushqimi u = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return u.getId();
            case 1:
                return u.getEmertimi();
            case 2:
                return u.getCmimiper1();
            case 3:
                return u.getSasia();
            default:
                return null;
        }
    }
}