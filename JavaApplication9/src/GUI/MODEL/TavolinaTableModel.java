/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MODEL;


import BLL.Tavolina;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TavolinaTableModel extends AbstractTableModel {
    
    List <Tavolina> list;
    String [] cols = {"Nr." , "nr_Personave", "Orari" ,"Vendi"};
    
    public TavolinaTableModel(){}
    
    public TavolinaTableModel(List<Tavolina> list){
        this.list = list;
    }
    
    public void addList(List<Tavolina> list){
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
    
    public Tavolina getTavolina(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tavolina t = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return t.getId();
            case 1:
                return t.getNrPersonave();
            case 2:
                return t.getOrariID();
            case 3:
                return t.getVendiID();
            default:
                return null;
        }
    }
}