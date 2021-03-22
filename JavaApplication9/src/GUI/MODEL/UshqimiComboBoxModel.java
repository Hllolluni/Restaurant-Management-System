/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MODEL;

import BLL.Ushqimi;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class UshqimiComboBoxModel extends AbstractListModel<Ushqimi> implements ComboBoxModel<Ushqimi> {

    private List<Ushqimi> data;
    private Ushqimi selectedItem;
    
    public UshqimiComboBoxModel(){}
    
    public UshqimiComboBoxModel(List<Ushqimi> data){
        this.data = data;
    }
    
    public void add(List<Ushqimi> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Ushqimi getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Ushqimi)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}