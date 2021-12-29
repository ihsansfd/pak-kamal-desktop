/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.ihsan_controller;

import ihsan.ihsan_model.ModelTransaksi;
import ihsan.ihsan_view.ViewTransaksi;

/**
 *
 * @author user
 */
public class ControllerTransaksi {
    
    private ModelTransaksi mT;
    private ViewTransaksi vT;
        
    public ControllerTransaksi(ViewTransaksi vT) {
        this.vT = vT;
        
    }
    
    public int simpanTransaksi() {
        mT = new ModelTransaksi();
        mT.setIdPelanggan(vT.getIdPelanggan().getText());
        mT.setNamaPelanggan(vT.getNamaPelanggan().getText());
        mT.setNamaBarang(vT.getNamaBarangTF().getText());
        mT.setQty(vT.getQtyBeliTF().getValue().toString());
        mT.setTotalBayar(vT.getTotalBayarTF().getText());
        mT.setUangBayar(vT.getUangBayarTF().getText());
        
        int idTransaksi = mT.simpanTransaksi();
        
        return idTransaksi;
    }
    
}