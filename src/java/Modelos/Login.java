/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author MARCS
 */
import DTO.ValidarUsuario;
import java.sql.SQLException;
import java.sql.Statement;
public class Login {
    public void  Validar_usuario(ValidarUsuario personaregistrada) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm;
        stm = nuevaconexion.getConeccion().createStatement();
        String query="SELECT * FROM usuario where (usu_correo='"+personaregistrada.getCorreo()+"' and usu_contrasena='"+personaregistrada.getContraseña()+"'";
        try{
            stm.executeUpdate(query);
        }catch(SQLException ex){
            throw new SQLException("usuario no encontrado");
           
        }
    }
    
}
