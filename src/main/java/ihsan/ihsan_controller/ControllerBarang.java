/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.ihsan_controller;

import ihsan.ihsan_model.ModelBarang;
import ihsan.ihsan_model.ModelPelanggan;
import ihsan.ihsan_view.ViewBarangInternal;
//import ihsan_view.ViewPelanggan;
import ihsan.ihsan_view.ViewPelangganInternal;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author user
 */
public class ControllerBarang {
    
    private ModelBarang mB;
    private ViewBarangInternal vBI;
    
    public ControllerBarang(ViewBarangInternal vBI) {
        this.vBI = vBI ;
    }
    
    public void bersihkan() {
        vBI.setIdBarangTF("");
        vBI.setNamaBarangTF("");
        vBI.setJenisBarangTF("");
        vBI.setSatuanBarangTF("");
        vBI.setUkuranBarangTF("");
        vBI.setHargaBarangTF("");
        vBI.setHargaBeliBarangTF("");

    }
    
    public void kontrolButton() {
        vBI.getSimpanButton().setEnabled(true);
        vBI.getBatalButton().setEnabled(true);
        vBI.getUbahButton().setEnabled(false);
        vBI.getHapusButton().setEnabled(false);
        vBI.getIdBarangField().setEnabled(true);
    }
    public void kontrolButton2() {
        vBI.getSimpanButton().setEnabled(false);
        vBI.getBatalButton().setEnabled(true);
        vBI.getUbahButton().setEnabled(true);
        vBI.getHapusButton().setEnabled(true);
    }
    
    
    public void simpan() {
        mB = new ModelBarang();
        mB.setIdBarangModel(vBI.getIdBarangTF());
        mB.setNamaBarangModel(vBI.getNamaBarangTF());
        mB.setJenisBarangModel(vBI.getJenisBarangTF());
        mB.setSatuanBarangModel(vBI.getSatuanBarangTF());
        mB.setUkuranBarangModel(vBI.getUkuranBarangTF());
        mB.setHargaBarangModel(vBI.getHargaBarangTF());
        mB.setHargaBeliBarangModel(vBI.getHargaBeliBarangTF());
        
        int opsi = JOptionPane.showConfirmDialog(vBI, String.format("Nama Barang : %s \n "
                                                        + "ID Barang: %s \n" 
                                                        + "Jenis Barang : %s \n"
                                                        + "Satuan Barang : %s \n"
                                                        + "Ukuran Barang : %s \n"
                                                        + "Harga Beli Barang : %s \n"
                                                        + "Harga Jual Barang : %s \n",
                mB.getNamaBarangModel(),mB.getIdBarangModel(), mB.getJenisBarangModel(), mB.getSatuanBarangModel(), mB.getUkuranBarangModel(),mB.getHargaBeliBarangModel(), mB.getHargaBarangModel()),"Yakin ingin simpan ke database?",JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
             mB.simpanDataBarang();
        } else {
            return;
        }
        bersihkan();
        vBI.refreshTable();
 

    }
    
    public void ubah(){

        mB = new ModelBarang();
        mB.setNamaBarangModel(vBI.getNamaBarangTF());
        mB.setIdBarangModel(vBI.getIdBarangTF());
        mB.setJenisBarangModel(vBI.getJenisBarangTF());
        mB.setSatuanBarangModel(vBI.getSatuanBarangTF());
        mB.setUkuranBarangModel(vBI.getUkuranBarangTF());
        mB.setHargaBarangModel(vBI.getHargaBarangTF());
        mB.setHargaBeliBarangModel(vBI.getHargaBeliBarangTF());
        
        int opsi = JOptionPane.showConfirmDialog(vBI, String.format("Nama Barang : %s \n "
                                                        + "ID Barang: %s \n" 
                                                        + "Jenis Barang : %s \n"
                                                        + "Satuan Barang : %s \n"
                                                        + "Ukuran Barang : %s \n"
                                                        + "Harga Beli Barang : %s \n"
                                                        + "Harga Jual Barang : %s \n",
                mB.getNamaBarangModel(),mB.getIdBarangModel(), mB.getJenisBarangModel(), mB.getSatuanBarangModel(), mB.getUkuranBarangModel(),mB.getHargaBeliBarangModel(), mB.getHargaBarangModel()),"Yakin ingin simpan ke database?",JOptionPane.YES_NO_OPTION);
         if (opsi == JOptionPane.YES_OPTION) {
            mB.ubahDataBarang();
        } else {
            return;
        }
        bersihkan();
        kontrolButton();
        vBI.refreshTable();
    }
   
    
    public void hapus() {
        
        int hasil = JOptionPane.showConfirmDialog(vBI, "Yakin ingin menghapus barang ini? Semua transaksi yang bersangkutan dengan barang ini juga akan dihapus!", "Peringatan!",YES_NO_OPTION, WARNING_MESSAGE);
        
        if(hasil == YES_OPTION) {
        mB = new ModelBarang();
        mB.setIdBarangModel(vBI.getIdBarangTF());
        mB.deleteDataBarang();
        bersihkan();
        kontrolButton();
        vBI.refreshTable();
            
        } else {
            return;
        }
        

    }
    
}
