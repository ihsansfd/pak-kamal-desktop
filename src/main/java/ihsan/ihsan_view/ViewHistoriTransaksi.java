/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ihsan.ihsan_view;

import ihsan.ihsan_database.db.KonfigurasiDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class ViewHistoriTransaksi extends javax.swing.JInternalFrame {

    private DefaultTableModel model;
    

    public ViewHistoriTransaksi() {

        initComponents();
        model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Kuantitas");
        model.addColumn("Harga");
        model.addColumn("Total Bayar");
        model.addColumn("Uang Bayar");
        model.addColumn("Tanggal Transaksi");
        tampilDataHistoriTransaksi();
                tabelHistoriTransaksi.setRowHeight(50);
                tabelHistoriTransaksi.setModel(model);


 
        
        
    }
    
    private void tampilDataHistoriTransaksi() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT orders.idTransaksi, orders.namaPelanggan, barang.idBarang, ordersDetail.namaBarang, ordersDetail.qty, ordersDetail.harga, orders.totalBayar, orders.uangBayar, orders.tanggalOrder FROM orders INNER JOIN ordersDetail on (ordersDetail.idTransaksi = orders.idTransaksi) INNER JOIN barang ON (barang.idBarang = ordersDetail.idBarang) ORDER BY orders.idTransaksi DESC";
        

        try {
                Statement stat = (Statement) KonfigurasiDatabase.getKoneksi().createStatement();
                ResultSet res = stat.executeQuery(sql);
                while(res.next()) {
                    Object[] hasil;
                    hasil = new Object[9];
                    hasil[0] = Integer.toString(res.getInt("orders.idTransaksi"));
                    hasil[1] = res.getString("orders.namaPelanggan");
                    hasil[2] = res.getString("barang.idBarang");
                    hasil[3] = res.getString("ordersDetail.namaBarang");
                    hasil[4] = Integer.toString(res.getInt("ordersDetail.qty"));
                    hasil[5] = Integer.toString(res.getInt("ordersDetail.harga"));
                    hasil[6] = Integer.toString(res.getInt("orders.totalBayar"));
                    hasil[7] = Integer.toString(res.getInt("orders.uangBayar"));
                    hasil[8] = res.getDate("orders.tanggalOrder").toString();
                    

                    model.addRow(hasil);
            }
            } catch (SQLException ex) {
                System.err.print("gagal eksekusi:" + ex);
            }
       
       
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelHistoriTransaksi = new javax.swing.JTable();
        hapusTransaksi = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Histori Transaksi");

        tabelHistoriTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelHistoriTransaksi.setFillsViewportHeight(true);
        tabelHistoriTransaksi.setMinimumSize(null);
        tabelHistoriTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelHistoriTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelHistoriTransaksi);

        hapusTransaksi.setText("Hapus Transaksi");
        hapusTransaksi.setEnabled(false);
        hapusTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusTransaksiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hapusTransaksi)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hapusTransaksi)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelHistoriTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelHistoriTransaksiMouseClicked
        hapusTransaksi.setEnabled(true);
    }//GEN-LAST:event_tabelHistoriTransaksiMouseClicked

    private void hapusTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusTransaksiMouseClicked
        // TODO add your handling code here:
        int hasil = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus transaksi ini? Semua transaksi dengan ID Transaksi yang sama juga akan terhapus!", "Peringatan!",YES_NO_OPTION, WARNING_MESSAGE);
        
        if(hasil == YES_OPTION) {
        
        int index = tabelHistoriTransaksi.getSelectedRow();
        int idTransaksi = Integer.valueOf(tabelHistoriTransaksi.getValueAt(index, 0).toString());
        String sql = "DELETE FROM orders WHERE idTransaksi =" + "'"+idTransaksi+"'";
        try {
            
            PreparedStatement eksekusi = KonfigurasiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
            
            tampilDataHistoriTransaksi();
        } catch (SQLException ex) {
            System.err.print("gagal mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal dihapus" + ex);

        }
        } else {
            return;
        }
                
                
    }//GEN-LAST:event_hapusTransaksiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapusTransaksi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelHistoriTransaksi;
    // End of variables declaration//GEN-END:variables
}
