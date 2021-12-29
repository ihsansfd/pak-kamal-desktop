/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.ihsan_controller;

import exceptions.InputUserNullException;
import exceptions.LoginInvalidException;
import static java.lang.System.exit;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ihsan.ihsan_view.AppUtama;
import ihsan.ihsan_view.ViewLogin;
import ihsan.validasi.LoginDetailsValidation;
import ihsan.validasi.NotNullValidation;

/**
 *
 * @author user
 */
public class ControllerLogin {

    private ViewLogin vL;

    public ControllerLogin(ViewLogin vL) {
        this.vL = vL;
    }
    
    public void validasi() {
        
       String username = vL.getUsernameTF().getText();
       String password = vL.getPasswordTF().getText();
       
       String[] arrays = {username, password};
       var notNullValidation = new NotNullValidation(arrays);
       notNullValidation.setMessage("Silakan masukkan kolom username dan password!");
 
       var loginDetailsValidation = new LoginDetailsValidation(username, password);
        
        try {
            notNullValidation.validasi();
            loginDetailsValidation.validasi();
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 0) {
                JOptionPane.showMessageDialog(vL,"Gagal terkoneksi ke database");
                exit(0);
                return;} 
            else {
                JOptionPane.showMessageDialog(vL, ex.getMessage());
                return; }                 
        } catch (LoginInvalidException ex) {
                JOptionPane.showMessageDialog(vL, ex.getMessage());
                return;} 
         catch (InputUserNullException ex) {
            JOptionPane.showMessageDialog(vL,ex.getMessage());
            return;        
        }
        
        String levelAkses = loginDetailsValidation.getHakAkses();
        AppUtama AU = new AppUtama();  
        if(levelAkses.equals("K")) {
            AU.getMasterBarang().setEnabled(false);
            AU.getMasterPelanggan().setEnabled(false);
            AU.getMasterTransaksi().setEnabled(false);
            AU.getMasterUserProgram().setEnabled(false);
            }        
        AU.setVisible(true);
        vL.dispose();
    }
       
        
        
    }
    

