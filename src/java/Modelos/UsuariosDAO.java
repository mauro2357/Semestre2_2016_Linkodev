/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import DTO.Usuario;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mateo Ortiz Cano
 */
public class UsuariosDAO {
    public void RegistrarUsuario(Usuario persona) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm;
        stm = nuevaconexion.getConeccion().createStatement();
        String query="INSERT INTO usuario VALUES ('"+persona.getNombre()+"','"
            +persona.getCorreo()+"','"+persona.getContraseña()+"','"
            +persona.getTelefono()+"')";
        try{
            stm.executeUpdate(query);
        }catch(SQLException ex){
            throw new SQLException("El correo ingresado ya se encuentra registrado");
        }
    }
    
    public void modificarInformacion(Usuario persona) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm;
        stm = nuevaconexion.getConeccion().createStatement();
        String query = "UPDATE usuario SET usu_nombre='"+persona.getNombre()+"', "
                + "usu_contrasena='"+persona.getContraseña()+"', "
                + "usu_telefono ='"+persona.getTelefono() +"' "
                + "where usu_correo = '"+persona.getCorreo()+"'";
        try{
            stm.executeUpdate(query);
        }catch(SQLException ex){
            throw new SQLException("Error! 404");
        }
    }
}
