/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ihsan.ihsan_view;

import com.mysql.cj.xdevapi.Result;
import ihsan.ihsan_database.db.KonfigurasiDatabase;
import ihsan.ihsan_controller.ControllerBarang;
import ihsan.ihsan_controller.ControllerPelanggan;
import java.awt.Color;
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
public class ViewBarangInternal extends javax.swing.JInternalFrame  {

    private ControllerBarang cB;
    private DefaultTableModel model;

    public ViewBarangInternal() {
        initComponents();
        cB = new ControllerBarang(this);
        model = new DefaultTableModel();
        tabelBarang.setModel(model);
        model.addColumn("Nama");
        model.addColumn("Jenis");
        model.addColumn("Satuan");
        model.addColumn("Ukuran");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("ID");

        
        tampilDataBarang();
        cB.kontrolButton();
   
    }

    public String getHargaBeliBarangTF() {
        return hargaBeliBarangTF.getText();
    }
    public void setHargaBeliBarangTF(String harga) {
        hargaBeliBarangTF.setText(harga);
    }

    public String getHargaBarangTF() {
        return hargaBarangTF.getText();
    }

    public void setHargaBarangTF(String harga) {
        hargaBarangTF.setText(harga);
    }


    public String getIdBarangTF() {
        return idBarangTF.getText();
    }

    public void setIdBarangTF(String id) {
        idBarangTF.setText(id);
    }

    public String getJenisBarangTF() {
        return jenisBarangTF.getText();
    }

    public void setJenisBarangTF(String jenisBarang) {
         jenisBarangTF.setText(jenisBarang);
    }

    public String getNamaBarangTF() {
        return namaBarangTF.getText();
    }

    public void setNamaBarangTF(String namaBarang) {
        namaBarangTF.setText(namaBarang);
    }

    public String getSatuanBarangTF() {
        return satuanBarangTF.getText();
    }
    
    public JTextField getIdBarangField() {
        return idBarangTF;
    }


    public void setSatuanBarangTF(String satuan) {
        satuanBarangTF.setText(satuan);
    }

    public String getUkuranBarangTF() {
        return ukuranBarangTF.getText();
    }

    public void setUkuranBarangTF(String ukuran) {
        ukuranBarangTF.setText(ukuran);
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
   
    
  
    
    public void refreshTable() {
        tampilDataBarang();
    }
    
    private void tampilDataBarang() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * from barang";
        
        try {
            Statement stat = (Statement) KonfigurasiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()) {
                Object[] hasil;
                hasil = new Object[7];
                hasil[0] = res.getString("namaBarang");
                hasil[1] = res.getString("jenisBarang");
                hasil[2] = res.getString("satuan");
                hasil[3] = res.getString("ukuran");
                hasil[4] = Integer.toString(res.getInt("hargaBeli"));
                hasil[5] = Integer.toString(res.getInt("harga"));
                hasil[6] = res.getString("idBarang");

                

                
                System.out.print("Print:" + hasil);

                model.addRow(hasil);
        }
        } catch (SQLException ex) {
            System.err.print("gagal eksekusi:" + ex);
        }
       
       
        
    }
        private void ambilDataTabel() {
        int index = tabelBarang.getSelectedRow();
        String namaBarang = String.valueOf(tabelBarang.getValueAt(index, 0));
        String jenisBarang = String.valueOf(tabelBarang.getValueAt(index, 1));
        String satuan = String.valueOf(tabelBarang.getValueAt(index, 2));
        String ukuran = String.valueOf(tabelBarang.getValueAt(index, 3));
        String hargaBeli = String.valueOf(tabelBarang.getValueAt(index, 4));
        String harga = String.valueOf(tabelBarang.getValueAt(index, 5));
        String idBarang = String.valueOf(tabelBarang.getValueAt(index, 6));
        
        idBarangTF.setText(idBarang);
        namaBarangTF.setText(namaBarang);
        jenisBarangTF.setText(jenisBarang);
        satuanBarangTF.setText(satuan);
        ukuranBarangTF.setText(ukuran);
        hargaBeliBarangTF.setText(hargaBeli);        
        hargaBarangTF.setText(harga);
        
       cB.kontrolButton2();
        
        
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
        namaBarangTF = new javax.swing.JTextField();
        jenisBarangTF = new javax.swing.JTextField();
        ukuranBarangTF = new javax.swing.JTextField();
        simpanButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idBarangTF = new javax.swing.JTextField();
        hapusButton = new javax.swing.JButton();
        ubahButton = new javax.swing.JButton();
        batalButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        satuanBarangTF = new javax.swing.JTextField();
        hargaBeliBarangTF = new javax.swing.JTextField();
        alamatTxt1 = new javax.swing.JLabel();
        hargaBarangTF = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);

        namaPelangganTxt.setText("Nama Barang:");

        noHpTxt.setText("Jenis Barang:");

        jenisKelaminTxt.setText("Satuan:");

        usiaTxt.setText("Ukuran:");

        alamatTxt.setText("Harga Beli:");

        namaBarangTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaBarangTFActionPerformed(evt);
            }
        });

        jenisBarangTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisBarangTFActionPerformed(evt);
            }
        });

        simpanButton.setText("SIMPAN");
        simpanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("ID Barang:");

        idBarangTF.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        idBarangTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBarangTFActionPerformed(evt);
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

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBarang.setFillsViewportHeight(true);
        tabelBarang.setRowHeight(50);
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

        alamatTxt1.setText("Harga Jual:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(batalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapusButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ubahButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(simpanButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noHpTxt)
                            .addComponent(namaPelangganTxt)
                            .addComponent(jenisKelaminTxt)
                            .addComponent(usiaTxt)
                            .addComponent(alamatTxt)
                            .addComponent(jLabel1)
                            .addComponent(alamatTxt1))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(idBarangTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(namaBarangTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jenisBarangTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(satuanBarangTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ukuranBarangTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hargaBeliBarangTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaPelangganTxt)
                    .addComponent(namaBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noHpTxt)
                    .addComponent(jenisBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jenisKelaminTxt)
                    .addComponent(satuanBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usiaTxt)
                    .addComponent(ukuranBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamatTxt)
                    .addComponent(hargaBeliBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamatTxt1))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batalButton)
                    .addComponent(hapusButton)
                    .addComponent(ubahButton)
                    .addComponent(simpanButton))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jenisBarangTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisBarangTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisBarangTFActionPerformed

    private void namaBarangTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaBarangTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaBarangTFActionPerformed

    private void simpanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanButtonMouseClicked
        if(idBarangTF.getText().isBlank() || namaBarangTF.getText().isBlank() || jenisBarangTF.getText().isBlank() || satuanBarangTF.getText().isBlank()
            || ukuranBarangTF.getText().isBlank() || hargaBeliBarangTF.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Semua kolom wajib diisi!");
            return;
        }
        cB.simpan(); 
    }//GEN-LAST:event_simpanButtonMouseClicked

    private void idBarangTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBarangTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idBarangTFActionPerformed

    private void hapusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusButtonMouseClicked
        cB.hapus();
    }//GEN-LAST:event_hapusButtonMouseClicked

    private void ubahButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubahButtonMouseClicked
        if(idBarangTF.getText().isBlank() || namaBarangTF.getText().isBlank() || jenisBarangTF.getText().isBlank() || satuanBarangTF.getText().isBlank()
            || ukuranBarangTF.getText().isBlank() || hargaBeliBarangTF.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Semua kolom wajib diisi!");
            return;
        }
        cB.ubah();
    }//GEN-LAST:event_ubahButtonMouseClicked

    private void ubahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubahButtonActionPerformed

    private void batalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batalButtonMouseClicked
        cB.kontrolButton();
        cB.bersihkan();
    }//GEN-LAST:event_batalButtonMouseClicked

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batalButtonActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        idBarangTF.setEnabled(false);
        ambilDataTabel();
    }//GEN-LAST:event_tabelBarangMouseClicked

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
    private javax.swing.JLabel alamatTxt;
    private javax.swing.JLabel alamatTxt1;
    private javax.swing.JButton batalButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton hapusButton;
    private javax.swing.JTextField hargaBarangTF;
    private javax.swing.JTextField hargaBeliBarangTF;
    private javax.swing.JTextField idBarangTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jenisBarangTF;
    private javax.swing.JLabel jenisKelaminTxt;
    private javax.swing.JTextField namaBarangTF;
    private javax.swing.JLabel namaPelangganTxt;
    private javax.swing.JLabel noHpTxt;
    private javax.swing.JTextField satuanBarangTF;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JButton ubahButton;
    private javax.swing.JTextField ukuranBarangTF;
    private javax.swing.JLabel usiaTxt;
    // End of variables declaration//GEN-END:variables
}
