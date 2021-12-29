/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.validasi;

import exceptions.LoginInvalidException;
import ihsan.ihsan_database.db.KonfigurasiDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class LoginDetailsValidation {
    
    private String username;
    private String password;
    private String hakAkses;

    public String getHakAkses() {
        return hakAkses;
    }

    public LoginDetailsValidation(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
    public void validasi() throws SQLException, LoginInvalidException {
        String sql =  "SELECT * FROM users WHERE username = ? AND password = ?" ;
        PreparedStatement ps = KonfigurasiDatabase.getKoneksi().prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
            hakAkses = rs.getString("levelAkses");
        } else {
            throw new LoginInvalidException();
        }
                
        
    }
    
}
