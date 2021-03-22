/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MODEL;

import BLL.Vendi;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class VendiComboBoxModel extends AbstractListModel<Vendi> implements ComboBoxModel<Vendi> {

    private List<Vendi> data;
    private Vendi selectedItem;
    
    public VendiComboBoxModel(){}
    
    public VendiComboBoxModel(List<Vendi> data){
        this.data = data;
    }
    
    public void add(List<Vendi> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Vendi getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Vendi)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}