/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.VIEW;

import BLL.Porosia;
import BLL.Tavolina;
import BLL.Ushqimi;
import DAL.CrudFormException;
import DAL.PorosiaRepository;
import DAL.TavolinaRepository;
import DAL.UshqimiRepository;
import GUI.MODEL.PorosiaTableModel;
import GUI.MODEL.TavolinaComboBoxModel;
import GUI.MODEL.UshqimiComboBoxModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Admin
 */
public class PorosiaForm extends javax.swing.JInternalFrame {
    
    PorosiaRepository pr = new PorosiaRepository();
    UshqimiRepository ur = new UshqimiRepository();
    TavolinaRepository tr = new TavolinaRepository();
    PorosiaTableModel ptm = new PorosiaTableModel();
    UshqimiComboBoxModel ucmb = new UshqimiComboBoxModel();
    TavolinaComboBoxModel tcmb = new TavolinaComboBoxModel();
    
    /**
     * Creates new form PorosiaForm
     */
    public PorosiaForm() {
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
        loadComboBox();

    }
    
    public void loadTable(){
        try{
            List<Porosia> lista = pr.findAll();
            ptm.addList(lista);
            table.setModel(ptm);
            ptm.fireTableDataChanged();
        }catch(CrudFormException ex){
            Logger.getLogger(UshqimiForm.class.getName()).log(Level.SEVERE,null,ex);
            Logger.getLogger(TavolinaForm.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    Porosia p = ptm.getPorosia(selectedIndex);
                    IDField.setText(p.getId().toString());
                    sasiaField.setText(p.getSasia()+"");
                    ucmb.setSelectedItem(p.getUshqimiID());
                    ushqimiCMB.repaint();
                    tcmb.setSelectedItem(p.getTavolinaID());
                    tavolinaCMB.repaint();
                }
            }
        });
    }
    public void loadComboBox(){
        try{
            List<Ushqimi> lista = ur.findAll();
            ucmb.add(lista);
            ushqimiCMB.setModel(ucmb);
            ushqimiCMB.repaint();
            List<Tavolina> lista1 = tr.findAll();
            tcmb.add(lista1);
            tavolinaCMB.setModel(tcmb);
            tavolinaCMB.repaint();
            
        }catch(CrudFormException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        IDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sasiaField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ushqimiCMB = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tavolinaCMB = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        IDField.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Sasia:");

        sasiaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sasiaFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cmimi:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ushqimi:");

        ushqimiCMB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tavolina:");

        tavolinaCMB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Blej");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sasiaField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ushqimiCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tavolinaCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(sasiaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ushqimiCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tavolinaCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        saveButton.setText("Ruaj");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Fshij");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Anulo");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(cancelButton)
                .addGap(106, 106, 106))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton)
                    .addComponent(cancelButton))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
       try{
            int row = table.getSelectedRow();
            if(row == -1){
                Porosia p = new Porosia();
                //u.setId()
                p.setSasia(Integer.parseInt(sasiaField.getText()));
                p.setUshqimiID((Ushqimi)ucmb.getSelectedItem());
                p.setCmimi(p.getSasia()*p.getUshqimiID().getCmimiper1());
                Ushqimi u = p.getUshqimiID();
                u.setSasia(u.getSasia() - p.getSasia());
                Tavolina t = p.getTavolinaID();
                pr.create(p);
                ur.edit(u);
                tr.edit(t);
                
            }else{
                Porosia p = ptm.getPorosia(row);
                //Id nuk e lejojm me ndryshu vetem emertimin ose fielda tjere qe mundeni me pas
                
                p.setSasia(Integer.parseInt(sasiaField.getText()));
                p.setUshqimiID((Ushqimi)ucmb.getSelectedItem());
                p.setCmimi(p.getSasia()*p.getUshqimiID().getCmimiper1());
                Ushqimi u = p.getUshqimiID();
                u.setSasia(u.getSasia() - p.getSasia());
                Tavolina t = p.getTavolinaID();
                pr.edit(p);
                ur.edit(u);
                tr.edit(t);
            }
            //E krijojm ni metode per me i clear fieldat mbasi ti shtojme
            clear();
            loadTable();
        }catch(CrudFormException ex){
            JOptionPane.showMessageDialog(this, "E dhena ekziston!");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if(row != -1){
            Object[] ob = {"Po","Jo"};
            int i = JOptionPane.showOptionDialog(this,"A deshironi ta fshini?","Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if(i == 0){
                Porosia p = ptm.getPorosia(row);
                try{
                    pr.delete(p);
                }catch(CrudFormException ex){
                    JOptionPane.showMessageDialog(this,ex.getMessage());
                }
                clear();
                loadTable();
            }else{
                clear();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_cancelButtonActionPerformed

    public void clear(){
        table.clearSelection();
        IDField.setText("");
        sasiaField.setText("");
        ushqimiCMB.setSelectedIndex(-1);
        ushqimiCMB.repaint();
    }
    
    PorosiaTableModel getTable() {
        return ptm;
    }
    
    private void sasiaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sasiaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sasiaFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new FaturaForm().setVisible(true);
        for(int row = 0; row < table.getRowCount(); row=0){
            Porosia p = ptm.getPorosia(row);
            try{
                    pr.delete(p);
            }catch(CrudFormException ex){
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
            //clear();
            loadTable();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PorosiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PorosiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PorosiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PorosiaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PorosiaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sasiaField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table;
    private javax.swing.JComboBox tavolinaCMB;
    private javax.swing.JComboBox ushqimiCMB;
    // End of variables declaration//GEN-END:variables

}
