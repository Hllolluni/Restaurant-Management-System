/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MODEL;

import BLL.Tavolina;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class TavolinaComboBoxModel extends AbstractListModel<Tavolina> implements ComboBoxModel<Tavolina> {

    private List<Tavolina> data;
    private Tavolina selectedItem;
    
    public TavolinaComboBoxModel(){}
    
    public TavolinaComboBoxModel(List<Tavolina> data){
        this.data = data;
    }
    
    public void add(List<Tavolina> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Tavolina getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Tavolina)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}