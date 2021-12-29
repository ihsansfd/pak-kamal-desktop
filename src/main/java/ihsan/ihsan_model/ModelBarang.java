/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.ihsan_model;

import ihsan.ihsan_database.db.KonfigurasiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModelBarang {
    private String idBarangModel;
    private String namaBarangModel;
    private String jenisBarangModel;
    private String satuanBarangModel;
    private String ukuranBarangModel;
    private String hargaBarangModel;
    private String hargaBeliBarangModel;

   
    KonfigurasiDatabase koneksi = new KonfigurasiDatabase();
    public ModelBarang() { 
    }
    public String getHargaBeliBarangModel() {
        return hargaBeliBarangModel;
    }

    public void setHargaBeliBarangModel(String hargaBeliBarangModel) {
        this.hargaBeliBarangModel = hargaBeliBarangModel;
    }
    public String getIdBarangModel() {
        return idBarangModel;
    }

    public void setIdBarangModel(String idBarangModel) {
        this.idBarangModel = idBarangModel;
    }

    public String getNamaBarangModel() {
        return namaBarangModel;
    }

    public void setNamaBarangModel(String namaBarangModel) {
        this.namaBarangModel = namaBarangModel;
    }

    public String getJenisBarangModel() {
        return jenisBarangModel;
    }

    public void setJenisBarangModel(String jenisBarangModel) {
        this.jenisBarangModel = jenisBarangModel;
    }

    public String getSatuanBarangModel() {
        return satuanBarangModel;
    }

    public void setSatuanBarangModel(String satuanBarangModel) {
        this.satuanBarangModel = satuanBarangModel;
    }

    public String getUkuranBarangModel() {
        return ukuranBarangModel;
    }

    public void setUkuranBarangModel(String ukuranBarangModel) {
        this.ukuranBarangModel = ukuranBarangModel;
    }

    public String getHargaBarangModel() {
        return hargaBarangModel;
    }

    public void setHargaBarangModel(String hargaBarangModel) {
        this.hargaBarangModel = hargaBarangModel;
    }
    
    
    
    public void simpanDataBarang() {
        
        // namaBarang,jenisBarang,satuan,ukuran,harga,idBarang
  
        String sql =  "INSERT INTO barang VALUES ('" +getNamaBarangModel()+"','"+getJenisBarangModel()+"','"+getSatuanBarangModel()+"','"+getUkuranBarangModel()+"','"+getHargaBarangModel() +"','"+getIdBarangModel() +"','"+getHargaBeliBarangModel()+"' )";
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        } catch (SQLException ex) {
            System.err.print("gagal mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal disimpan" + ex);

        }
        
       
        
    }
    
    public void deleteDataBarang() {
        String sql = "DELETE FROM barang WHERE idBarang =" + "'"+getIdBarangModel()+"'";
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
        } catch (SQLException ex) {
            System.err.print("gagal mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal dihapus" + ex);

        }
    }
    
    public void ubahDataBarang() {
          
        String sql =  "UPDATE barang SET namaBarang =  '" +getNamaBarangModel()+"'" + ", jenisBarang = '" +getJenisBarangModel()+ "'" + ", satuan = '"+getSatuanBarangModel()+ "'" + ", ukuran = '"+getUkuranBarangModel()+ "'" + ", harga = '"+getHargaBarangModel()+ "'"+", hargaBeli = '" +getHargaBeliBarangModel()+"'" + " WHERE idBarang = '" +getIdBarangModel()+"'" ;
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil diubah");
        } catch (SQLException ex) {
            System.err.print("gagal mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal diubah" + ex);

        }
        
        
       
        
    }
    
    
    
}
