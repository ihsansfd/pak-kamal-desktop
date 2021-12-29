/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.ihsan_controller;

import ihsan.ihsan_model.ModelUser;
import ihsan.ihsan_model.ModelPelanggan;
import ihsan.ihsan_view.ViewDataUser;
//import ihsan_view.ViewPelanggan;
import ihsan.ihsan_view.ViewPelangganInternal;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author user
 */
public class ControllerUser {
    
    private ModelUser mU;
    private ViewDataUser vDU;
    
    public ControllerUser(ViewDataUser vDU) {
        this.vDU = vDU ;
    }
    
    public void bersihkan() {
        vDU.setUsernameTF("");
        vDU.setPasswordTF("");
        vDU.setLevelAkses("karyawan");
    }
    
    public void kontrolButton() {
        vDU.getSimpanButton().setEnabled(true);
        vDU.getBatalButton().setEnabled(true);
        vDU.getUbahButton().setEnabled(false);
        vDU.getHapusButton().setEnabled(false);
    }
    public void kontrolButton2() {
        vDU.getSimpanButton().setEnabled(false);
        vDU.getBatalButton().setEnabled(true);
        vDU.getUbahButton().setEnabled(true);
        vDU.getHapusButton().setEnabled(true);
    }
    
    
    public void simpan() {
        mU = new ModelUser();
        mU.setUsername(vDU.getUsernameTF());
        mU.setPassword(vDU.getPasswordTF());
        if(vDU.getKaryawanRB()) {
            mU.setLevelAkses("Karyawan");
        } else {
            mU.setLevelAkses("Admin");
        }

        int opsi = JOptionPane.showConfirmDialog(vDU, String.format("Username : %s \n "
                                                        + "Password: %s \n" 
                                                        + "Level Akses : %s \n"
                                                        ,
                mU.getUsername(),mU.getPassword(), mU.getLevelAkses()),"Yakin ingin simpan ke database?",JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
             mU.simpanDataUser();
        } else {
            return;
        }
        bersihkan();
        vDU.refreshTable();
    }
    
    public void ubah(){
        mU = new ModelUser();
        mU.setPassword(vDU.getPasswordTF());
        mU.setUsername(vDU.getUsernameTF());
        if(vDU.getKaryawanRB()) {
            mU.setLevelAkses("Karyawan");
        } else {
            mU.setLevelAkses("Admin");
        }       
        
        int opsi = JOptionPane.showConfirmDialog(vDU, String.format("Username : %s \n "
                                                        + "Password: %s \n" 
                                                        + "Level Akses : %s \n"
                                                        ,
                mU.getUsername(),mU.getPassword(), mU.getLevelAkses()),"Yakin ingin simpan ke database?",JOptionPane.YES_NO_OPTION);
         if (opsi == JOptionPane.YES_OPTION) {
            mU.ubahDataUser();

        } else {
            return;
        }
        vDU.refreshTable();
        bersihkan();
        kontrolButton();
    }
    
    public void hapus() {
        
        int hasil = JOptionPane.showConfirmDialog(vDU, "Yakin ingin menghapus user ini?", "Peringatan!",YES_NO_OPTION, WARNING_MESSAGE);
        
        if(hasil == YES_OPTION) {
        mU = new ModelUser();
        mU.setUsername(vDU.getUsernameTF());
        mU.deleteDataUser();
        bersihkan();
        kontrolButton();
        vDU.refreshTable();
            
        } else {
            return;
        }
        

    }
    
}
