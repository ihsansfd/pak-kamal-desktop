/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.ihsan_database.db;

import static java.awt.PageAttributes.MediaType.C;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class KonfigurasiDatabase {
    private static Connection conn;
    
    private static Properties propert = new Properties();
    
    public static Connection getKoneksi() throws SQLException {
        if(conn == null) {
          
            try {
                propert.load(new FileInputStream("C:\\Users\\user\\Documents\\kuliah\\pemrograman desktop\\tugas\\1.MVC\\src\\main\\java\\ihsan\\ihsan_database\\db\\KonfigurasiDatabase.properties"));
                conn = DriverManager.getConnection(propert.getProperty("jdbc.url"), propert.getProperty("jdbc.username"), propert.getProperty("jdbc.password"));
            } catch (FileNotFoundException ex) {
                System.err.print("file tidak ditemukan: " + ex );
            } catch (IOException ex) {
                System.err.print("eror membaca file: " + ex );
            }        }
        return conn;
    }
      
}
