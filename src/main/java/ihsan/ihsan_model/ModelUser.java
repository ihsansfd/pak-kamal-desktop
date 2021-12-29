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

public class ModelUser {
    private String username;
    private String password;
    private String levelAkses;

   
    KonfigurasiDatabase koneksi = new KonfigurasiDatabase();
    public ModelUser() { 
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevelAkses() {
        return levelAkses;
    }

    public void setLevelAkses(String levelAkses) {
        this.levelAkses = levelAkses;
    }

   
    public void simpanDataUser() {
        
        // namaBarang,jenisBarang,satuan,ukuran,harga,idBarang
         String leveAksesBaru = getLevelAkses().equals("Karyawan")? "K":"A";
//         JOptionPane.showMessageDialog(null,leveAksesBaru);

        String sql =  "INSERT INTO users VALUES ('" +getUsername()+"','"+getPassword()+"','"+leveAksesBaru+"')";
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        } catch (SQLException ex) {
            System.err.print("gagal mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal disimpan" + ex);

        }
        
       
        
    }
    
    public void deleteDataUser() {
        String sql = "DELETE FROM users WHERE username =" + "'"+getUsername()+"'";
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
        } catch (SQLException ex) {
            System.err.print("gagal mengeksekusi sql" + ex);
            JOptionPane.showMessageDialog(null,"Data gagal dihapus" + ex);

        }
    }
    
    public void ubahDataUser() {
        
         String leveAksesBaru = getLevelAkses().equals("Karyawan")? "K":"A";
          
        String sql =  "UPDATE users SET username =  '" +getUsername()+"'" + ", password = '" +getPassword()+ "'" + ", levelAkses = '"+leveAksesBaru+ "'"  + " WHERE username = '" +getUsername()+"'" ;
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
