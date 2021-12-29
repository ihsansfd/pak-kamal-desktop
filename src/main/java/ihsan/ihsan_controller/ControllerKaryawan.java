/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.ihsan_controller;

import ihsan_model.ModelKaryawan;
import ihsan.ihsan_view.ViewInternalKaryawan;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author user
 */
public class ControllerKaryawan {
    private ModelKaryawan mK;
    private ViewInternalKaryawan vIK;
    
        public ControllerKaryawan(ViewInternalKaryawan vIK) {
        this.vIK = vIK ;
    }
    
    public void simpan() {
        mK = new ModelKaryawan();
        mK.setNama(vIK.getNamaTF().getText());    
        String jenisKelamin = vIK.getPriaRB().isSelected()? "Pria" : "Wanita";
        mK.setJenisKelamin(jenisKelamin);
        mK.setJumlahAnak(Integer.valueOf(vIK.getJumlahAnakTF().getText()));
        mK.setLamaBekerja(Integer.valueOf(vIK.getLamaBekerjaTF().getText()));
        mK.setAlamat(vIK.getAlamatTF().getText());

        int tunjangan = 0;
        
       if(mK.getLamaBekerja() > 2 && mK.getLamaBekerja() <= 5 && mK.getJumlahAnak() == 1) {
            tunjangan = 2_000_000;
        } else if(mK.getLamaBekerja() > 5 && mK.getLamaBekerja() <= 9 && mK.getJumlahAnak() > 1 && mK.getJumlahAnak() <= 3) {
            tunjangan = 3_510_000;
        } else if (mK.getLamaBekerja() > 9 && mK.getJumlahAnak() >3) {
            tunjangan = 5_510_000;
        } else if(mK.getLamaBekerja() < 2 && mK.getJumlahAnak() == 0) {
            tunjangan = 10_000;
        }
        JOptionPane.showMessageDialog(vIK, String.format(
                                                         "Nama Karyawan: %s \n" 
                                                        + "Jenis Kelamin: %s \n"
                                                        + "Jumlah Anak : %d \n"
                                                        + "Lama Bekerja : %d tahun \n"
                                                        + "Alamat : %s \n"
                                                        + "Tunjangan : Rp%d \n",
                mK.getNama(),mK.getJenisKelamin(), mK.getJumlahAnak(), mK.getLamaBekerja(), mK.getAlamat(), tunjangan),"Hasil", INFORMATION_MESSAGE);




    }
    
}
