/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.ihsan_model;

import ihsan.ihsan_database.db.KonfigurasiDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;

/**
 *
 * @author user
 */
public class ModelTransaksi {
    private String namaPelanggan;
    private String idPelanggan;
    private String totalBayar;
    private String uangBayar;
    
    private String idTransaksiDetail;
    private String idTransaksi;
    private String namaBarang;
    private String qty;
    private String subtotal;

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(String totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getUangBayar() {
        return uangBayar;
    }

    public void setUangBayar(String uangBayar) {
        this.uangBayar = uangBayar;
    }

    public String getIdTransaksiDetail() {
        return idTransaksiDetail;
    }

    public void setIdTransaksiDetail(String idTransaksiDetail) {
        this.idTransaksiDetail = idTransaksiDetail;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }
    
    public int simpanTransaksi() {
        
//        String sql = "INSERT INTO transaksi (idTransaksi, namaPelanggan, totalBayar, uangBayar)" +
//                " VALUES ('"+getIdTransaksi()+"', '"+getNamaPelanggan()+"','"+getTotalBayar()+"',"+
//                "'"+getUangBayar()+"')";

//        String sql = "INSERT INTO orders (idTransaksi, namaPelanggan, totalBayar, uangBayar)" +
//                " VALUES ('"+getIdTransaksi()+"', '"+getNamaPelanggan()+"','"+getTotalBayar()+"',"+
//                "'"+getUangBayar()+"') returning idTransaksi";

        String sql = "INSERT INTO orders (namaPelanggan, totalBayar, uangBayar)" +
                " VALUES ('"+getNamaPelanggan()+"','"+getTotalBayar()+"',"+
                "'"+getUangBayar()+"')";
    int idTransaksiTerbaru = -1;
        try {
            PreparedStatement eksekusi = KonfigurasiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

//              Statement stmt = (Statement) KonfigurasiDatabase.getKoneksi().createStatement();
            
//              ResultSet res = stmt.executeQuery(sql);
              
//              int idTransaksi = -1;
//              while(res.next()) {
//                 idTransaksi = res.getInt("idTransaksi");
//              }
            
            eksekusi.close();
        } catch (SQLException ex) {
            System.err.print(ex);
         
        }
        
                String sql2 = "SELECT idTransaksi FROM orders ORDER BY idTransaksi DESC LIMIT 1";

        try {


              Statement stmt = (Statement) KonfigurasiDatabase.getKoneksi().createStatement();
            
              ResultSet res = stmt.executeQuery(sql2);
              

              while(res.next()) {
                 idTransaksiTerbaru = res.getInt("idTransaksi");
              }
            
            stmt.close();
        } catch (SQLException ex) {
            System.err.print(ex);         
        }
        return idTransaksiTerbaru;
        
        
    }
    
}
