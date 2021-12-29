/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ihsan.ihsan_view;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ihsan.ihsan_view.ViewLogin;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class ViewLoginTest {
    
    public ViewLoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPasswordTF method, of class ViewLogin.
     */
    @Test
    public void testGetPasswordTF() {
        System.out.println("getPasswordTF");
        ViewLogin instance = new ViewLogin();
        JPasswordField expResult = null;
        JPasswordField result = instance.getPasswordTF();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsernameTF method, of class ViewLogin.
     */
    @Test
    public void testGetUsernameTF() {
        System.out.println("getUsernameTF");
        ViewLogin instance = new ViewLogin();
        JTextField expResult = null;
        JTextField result = instance.getUsernameTF();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
