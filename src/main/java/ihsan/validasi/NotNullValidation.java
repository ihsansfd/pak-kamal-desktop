/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihsan.validasi;

import exceptions.InputUserNullException;
import java.sql.Array;

/**
 *
 * @author user
 */
public class NotNullValidation {
    private String[] arrays;
    private String message = "Silakan input data pada semua kolom!";

    public void setMessage(String message) {
        this.message = message;
    }

    public NotNullValidation(String [] arrays) {
        this.arrays = arrays;
    }
    
    
    
    public void validasi() throws InputUserNullException {
        for(String array : arrays) {
            if(array.isBlank()) {
                throw new InputUserNullException(message);
            }
        }
    }
}
