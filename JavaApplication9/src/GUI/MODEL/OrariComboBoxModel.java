/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MODEL;

import BLL.Orari;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class OrariComboBoxModel extends AbstractListModel<Orari> implements ComboBoxModel<Orari> {

    private List<Orari> data;
    private Orari selectedItem;
    
    public OrariComboBoxModel(){}
    
    public OrariComboBoxModel(List<Orari> data){
        this.data = data;
    }
    
    public void add(List<Orari> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Orari getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Orari)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}