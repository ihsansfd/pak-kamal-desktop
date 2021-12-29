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

public class ModelPelanggan {
    private int idPelangganModel;
    private String namaPelangganModel;
    private String nomorHpModel;
    private String jenisKelaminModel;
    private int umur;
    private String alamat;
   
    KonfigurasiDatabase koneksi = new KonfigurasiDatabase();
    public ModelPelanggan() { 
    }
    
    public int getidPelangganModel() {
        return idPelangganModel;
    }

    public void setidPelangganModel(int idPelangganModel) {
        this.idPelangganModel = idPelangganModel;
    }


    public String getNamaPelangganModel() {
        return namaPelangganModel;
    }

    public void setNamaPelangganModel(String namaPelangganModel) {
        this.namaPelangganModel = namaPelangganModel;
    }

    public String getNomorHpModel() {
        return nomorHpModel;
    }

    public void setNomorHpModel(String nomorHpModel) {
        this.nomorHpModel = nomorHpModel;
    }

    public String getJenisKelaminModel() {
        return jenisKelaminModel;
    }

    public void setJenisKelaminModel(String jenisKelaminModel) {
        this.jenisKelaminModel = jenisKelaminModel;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void simpanDataPelanggan() {
  
        String sql =  "INSERT INTO pelanggan (namaPelanggan, noHp, jenisKelamin, umur, alamat) " + "VALUES ('" +getNamaPelangganModel()+"','"+getNomorHpModel()+"','"+getJenisKelaminModel()+"','"+getUmur()+"','"+getAlamat() +"')";
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        } catch (SQLException ex) {
            System.err.print("gagal mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal disimpan" + ex);

        }
        
       
        
    }
    
    public void deleteDataPelanggan() {
        String sql = "DELETE FROM pelanggan WHERE id =" + "'"+getidPelangganModel()+"'";
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
        } catch (SQLException ex) {
            System.err.print("gagal mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal dihapus" + ex);

        }
    }
    
    public void ubahDataPelanggan() {
          
        String sql =  "UPDATE pelanggan SET namaPelanggan =  '" +getNamaPelangganModel()+"'" + ", noHp = '" +getNomorHpModel()+ "'" + ", jenisKelamin = '"+getJenisKelaminModel()+ "'" + ", umur = '"+getUmur()+ "'" + ", alamat = '"+getAlamat()+ "'" + " WHERE id = '" +getidPelangganModel()+"'" ;
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
