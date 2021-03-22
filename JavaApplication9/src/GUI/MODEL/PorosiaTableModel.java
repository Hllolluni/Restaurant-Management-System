/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MODEL;

import BLL.Porosia;
import BLL.Ushqimi;
import BLL.Tavolina;
import DAL.CrudFormException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vesam
 */
public class PorosiaTableModel extends AbstractTableModel{
    
    List<Porosia> list;
    String [] cols = {"Nr.", "Sasia" , "Cmimi", "Ushqimi","Tavolina"};
    
    public PorosiaTableModel(){}
    
    public PorosiaTableModel(List<Porosia> list){
        this.list = list;
    }
    
    public void addList(List<Porosia> list){
        this.list = list;
    }
    
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Porosia getPorosia(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Porosia p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getId();
            case 1:
                return p.getSasia();
            case 2:
                return p.getCmimi();
            case 3:
                return p.getUshqimiID();
            case 4:
                return p.getTavolinaID();
            default:
                return null;
        }
    }    
}