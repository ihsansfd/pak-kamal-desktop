/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ihsan.ihsan_view;

import com.mysql.cj.xdevapi.Result;
import ihsan.ihsan_database.db.KonfigurasiDatabase;
import ihsan.ihsan_controller.ControllerPelanggan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class ViewPelangganInternal extends javax.swing.JInternalFrame  {

    private ControllerPelanggan cP;
    private DefaultTableModel model;

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public ViewPelangganInternal() {
        initComponents();
        cP = new ControllerPelanggan(this);
        model = new DefaultTableModel();
        tabelPelanggan.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("No HP");
        model.addColumn("JK");
        model.addColumn("Umur");
        model.addColumn("Alamat");
        
        tampilDataPelanggan();
        cP.kontrolButton();
   
    }
   
    
    public int getIdPelanggan() {
        return Integer.parseInt(idPelangganTF.getText());
    }
    public String getNamaPelanggan() {
        return namaPelangganTF.getText();
    }
    
    public String getNoHp() {
        return noHpTF.getText();
    }
    
    public boolean getPria() {
        return priaRB.isSelected();
    }
    
    public boolean getWanita() {
        return wanitaRB.isSelected();
    }
    
    public int getUsia() {
        return Integer.parseInt((usiaTF.getText()));
    }
    
    public String  getAlamat() {
        return alamatTF.getText();
    }
      public void setIdPelanggan(String id) {
        idPelangganTF.setText(id);
    }
    public void setNamaPelanggan(String nama) {
        namaPelangganTF.setText(nama);
    }
    
    public void setNoHp(String noHP) {
        noHpTF.setText(noHP);
    }
    
    public void setJenisKelamin(String kelamin) {
        if(kelamin.equals("Pria"))
            priaRB.setSelected(true);
        else
            wanitaRB.setSelected(true);
    }

    public JButton getBatalButton() {
        return batalButton;
    }

    public JButton getHapusButton() {
        return hapusButton;
    }

    public JButton getSimpanButton() {
        return simpanButton;
    }

    public JButton getUbahButton() {
        return ubahButton;
    }
    
    
    
    public void setUsia(int usia) {
        if(usia == 0) {
            usiaTF.setText("");
            return; }
        usiaTF.setText(String.valueOf(usia));
    }
    
    public void setAlamat(String alamat) {
        alamatTF.setText(alamat);
    }
    
    public void refreshTable() {
        tampilDataPelanggan();
    }
    
    private void tampilDataPelanggan() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * from pelanggan";
        
        try {
            Statement stat = (Statement) KonfigurasiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()) {
                Object[] hasil;
                hasil = new Object[7];
                hasil[0] = Integer.toString(res.getInt("id"));
                hasil[1] = res.getString("namaPelanggan");
                hasil[2] = res.getString("noHp");
                hasil[3] = res.getString("jenisKelamin");
                hasil[4] = Integer.toString(res.getInt("umur"));
                hasil[5] = res.getString("alamat");
                

                
                System.out.print("Print:" + hasil);

                model.addRow(hasil);
        }
        } catch (SQLException ex) {
            System.err.print("gagal eksekusi:" + ex);
        }
       
       
        
    }
        private void ambilDataTabel() {
        int index = tabelPelanggan.getSelectedRow();
        String id = String.valueOf(tabelPelanggan.getValueAt(index, 0));
        String nama = String.valueOf(tabelPelanggan.getValueAt(index, 1));
        String tlp = String.valueOf(tabelPelanggan.getValueAt(index, 2));
        String jk = String.valueOf(tabelPelanggan.getValueAt(index, 3));
        String umur = String.valueOf(tabelPelanggan.getValueAt(index, 4));
        String alamat = String.valueOf(tabelPelanggan.getValueAt(index, 5));
        
        idPelangganTF.setText(id);
        namaPelangganTF.setText(nama);
        noHpTF.setText(tlp);
        
        if(jk.equals("Wanita")) {
            wanitaRB.setSelected(true);
        } else {
            priaRB.setSelected(true);
        }
        usiaTF.setText(umur);
        alamatTF.setText(alamat);
        
        cP.kontrolButton2();
        
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        namaPelangganTxt = new javax.swing.JLabel();
        noHpTxt = new javax.swing.JLabel();
        jenisKelaminTxt = new javax.swing.JLabel();
        usiaTxt = new javax.swing.JLabel();
        alamatTxt = new javax.swing.JLabel();
        namaPelangganTF = new javax.swing.JTextField();
        noHpTF = new javax.swing.JTextField();
        priaRB = new javax.swing.JRadioButton();
        wanitaRB = new javax.swing.JRadioButton();
        usiaTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatTF = new javax.swing.JTextArea();
        simpanButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idPelangganTF = new javax.swing.JTextField();
        hapusButton = new javax.swing.JButton();
        ubahButton = new javax.swing.JButton();
        batalButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPelanggan = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);

        namaPelangganTxt.setText("Nama Pelanggan:");

        noHpTxt.setText("No. HP:");

        jenisKelaminTxt.setText("Jenis Kelamin:");

        usiaTxt.setText("Usia:");

        alamatTxt.setText("Alamat:");

        namaPelangganTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPelangganTFActionPerformed(evt);
            }
        });

        noHpTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noHpTFActionPerformed(evt);
            }
        });

        buttonGroup1.add(priaRB);
        priaRB.setText("Pria");

        buttonGroup1.add(wanitaRB);
        wanitaRB.setText("Wanita");

        alamatTF.setColumns(20);
        alamatTF.setRows(5);
        jScrollPane1.setViewportView(alamatTF);

        simpanButton.setText("SIMPAN");
        simpanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("ID Pelanggan:");

        idPelangganTF.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        idPelangganTF.setEnabled(false);
        idPelangganTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPelangganTFActionPerformed(evt);
            }
        });

        hapusButton.setText("HAPUS");
        hapusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusButtonMouseClicked(evt);
            }
        });

        ubahButton.setText("UBAH");
        ubahButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubahButtonMouseClicked(evt);
            }
        });
        ubahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahButtonActionPerformed(evt);
            }
        });

        batalButton.setText("BATAL");
        batalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batalButtonMouseClicked(evt);
            }
        });
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPelanggan.setFillsViewportHeight(true);
        tabelPelanggan.setRowHeight(50);
        tabelPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPelanggan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noHpTxt)
                            .addComponent(namaPelangganTxt)
                            .addComponent(jenisKelaminTxt)
                            .addComponent(usiaTxt)
                            .addComponent(alamatTxt)
                            .addComponent(jLabel1))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(priaRB)
                                .addGap(18, 18, 18)
                                .addComponent(wanitaRB))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(idPelangganTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(namaPelangganTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(noHpTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addComponent(usiaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(batalButton)
                        .addGap(18, 18, 18)
                        .addComponent(hapusButton)
                        .addGap(18, 18, 18)
                        .addComponent(ubahButton)
                        .addGap(14, 14, 14)
                        .addComponent(simpanButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idPelangganTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaPelangganTxt)
                    .addComponent(namaPelangganTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noHpTxt)
                    .addComponent(noHpTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jenisKelaminTxt)
                    .addComponent(priaRB)
                    .addComponent(wanitaRB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usiaTxt)
                    .addComponent(usiaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alamatTxt)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanButton)
                    .addComponent(hapusButton)
                    .addComponent(ubahButton)
                    .addComponent(batalButton))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noHpTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noHpTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noHpTFActionPerformed

    private void namaPelangganTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPelangganTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPelangganTFActionPerformed

    private void simpanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanButtonMouseClicked
        if(namaPelangganTF.getText().isBlank() || noHpTF.getText().isBlank() || usiaTF.getText().isBlank() || alamatTF.getText().isBlank() || (priaRB.isSelected() == false && wanitaRB.isSelected() == false)) {
            JOptionPane.showMessageDialog(this, "Semua kolom wajib diisi!");
            return;
        }

        cP.simpan(); 
    }//GEN-LAST:event_simpanButtonMouseClicked

    private void idPelangganTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPelangganTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPelangganTFActionPerformed

    private void hapusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusButtonMouseClicked
        cP.hapus();
    }//GEN-LAST:event_hapusButtonMouseClicked

    private void ubahButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubahButtonMouseClicked
        if(namaPelangganTF.getText().isBlank() || noHpTF.getText().isBlank() || usiaTF.getText().isBlank() || alamatTF.getText().isBlank() || (priaRB.isSelected() == false && wanitaRB.isSelected() == false)) {
            JOptionPane.showMessageDialog(this, "Semua kolom wajib diisi!");
            return;
        }

        cP.ubah();
    }//GEN-LAST:event_ubahButtonMouseClicked

    private void ubahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubahButtonActionPerformed

    private void batalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batalButtonMouseClicked
        cP.kontrolButton();
        cP.bersihkan();
    }//GEN-LAST:event_batalButtonMouseClicked

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batalButtonActionPerformed

    private void tabelPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPelangganMouseClicked
        ambilDataTabel();
    }//GEN-LAST:event_tabelPelangganMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewPelangganInternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewPelangganInternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewPelangganInternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewPelangganInternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewPelangganInternal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatTF;
    private javax.swing.JLabel alamatTxt;
    private javax.swing.JButton batalButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton hapusButton;
    private javax.swing.JTextField idPelangganTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jenisKelaminTxt;
    private javax.swing.JTextField namaPelangganTF;
    private javax.swing.JLabel namaPelangganTxt;
    private javax.swing.JTextField noHpTF;
    private javax.swing.JLabel noHpTxt;
    private javax.swing.JRadioButton priaRB;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTable tabelPelanggan;
    private javax.swing.JButton ubahButton;
    private javax.swing.JTextField usiaTF;
    private javax.swing.JLabel usiaTxt;
    private javax.swing.JRadioButton wanitaRB;
    // End of variables declaration//GEN-END:variables
}
