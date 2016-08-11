/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linkcodev
 */
public class ConexiónBD {
    Connection co;    
    String bd = "inmuebles_schema";
    String login = "root";
    String password = "root";
    String url = "jdbc:mysql://localhost/"+bd;
    
    public ConexiónBD(){    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection(url,login,password);
        }catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }catch (SQLException ex) {
             Logger.getLogger(ConexiónBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConeccion() {
        return this.co;
    }
}
