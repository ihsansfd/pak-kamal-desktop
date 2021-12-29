/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.ihsan_controller;

import ihsan.ihsan_model.ModelPelanggan;
//import ihsan_view.ViewPelanggan;
import ihsan.ihsan_view.ViewPelangganInternal;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControllerPelanggan {
    
    private ModelPelanggan mP;
    private ViewPelangganInternal vP;
    
    public ControllerPelanggan(ViewPelangganInternal vP) {
        this.vP = vP ;
    }
    
    public void bersihkan() {
        vP.setIdPelanggan("");
        vP.setNamaPelanggan("");
        vP.setNoHp("");
        vP.setAlamat("");
        vP.setUsia(0);
    }
    
    public void kontrolButton() {
        vP.getSimpanButton().setEnabled(true);
        vP.getBatalButton().setEnabled(true);
        vP.getUbahButton().setEnabled(false);
        vP.getHapusButton().setEnabled(false);
    }
    public void kontrolButton2() {
        vP.getSimpanButton().setEnabled(false);
        vP.getBatalButton().setEnabled(true);
        vP.getUbahButton().setEnabled(true);
        vP.getHapusButton().setEnabled(true);
    }
    
    
    public void simpan() {
        mP = new ModelPelanggan();
        mP.setNamaPelangganModel(vP.getNamaPelanggan());
        mP.setNomorHpModel(vP.getNoHp());
        
        if(vP.getPria()) {
            mP.setJenisKelaminModel("Pria");
                    }
        else { mP.setJenisKelaminModel("Wanita") ;
        }
        mP.setUmur(vP.getUsia());
        mP.setAlamat(vP.getAlamat());
        
        int opsi = JOptionPane.showConfirmDialog(vP, String.format("Nama Pelanggan : %s \n "
                                                        + "Nomor HP : %s \n"
                                                        + "Jenis Kelamin : %s \n"
                                                        + "Usia : %d \n"
                                                        + "Alamat : %s \n",
                mP.getNamaPelangganModel(), mP.getNomorHpModel(), mP.getJenisKelaminModel(), mP.getUmur(), mP.getAlamat()),"Yakin ingin simpan ke database?",JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
             mP.simpanDataPelanggan();
        } else {
            return;
        }
        bersihkan();
        vP.refreshTable();
    }
    
    public void ubah(){
                mP = new ModelPelanggan();
        mP.setNamaPelangganModel(vP.getNamaPelanggan());
        mP.setNomorHpModel(vP.getNoHp());
        mP.setidPelangganModel(vP.getIdPelanggan());
        
        if(vP.getPria()) {
            mP.setJenisKelaminModel("Pria");
                    }
        else { mP.setJenisKelaminModel("Wanita") ;
        }
        mP.setUmur(vP.getUsia());
        mP.setAlamat(vP.getAlamat());
        
        int opsi = JOptionPane.showConfirmDialog(vP, String.format("Nama Pelanggan : %s \n "
                                                        + "Nomor HP : %s \n"
                                                        + "Jenis Kelamin : %s \n"
                                                        + "Usia : %d \n"
                                                        + "Alamat : %s \n",
                mP.getNamaPelangganModel(), mP.getNomorHpModel(), mP.getJenisKelaminModel(), mP.getUmur(), mP.getAlamat()),"Yakin ingin ubah data ini ke database?",JOptionPane.YES_NO_OPTION);
         if (opsi == JOptionPane.YES_OPTION) {
            mP.ubahDataPelanggan();
        } else {
            return;
        }
        bersihkan();
        kontrolButton();
        vP.refreshTable();
    }
    
    public void hapus() {
        mP = new ModelPelanggan();
        mP.setidPelangganModel(vP.getIdPelanggan());
        mP.deleteDataPelanggan();
        bersihkan();
        kontrolButton();
        vP.refreshTable();
    }
    
}
