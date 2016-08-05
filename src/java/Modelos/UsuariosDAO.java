/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import DTO.Usuario;
import DTO.UsuarioInicioSesion;
import java.sql.ResultSet;
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
    public Usuario  inicioSesion(UsuarioInicioSesion personaregistrada) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        String correo=personaregistrada.getCorreo();
        String contraseña=personaregistrada.getContraseña();
        Statement statement=nuevaconexion.getConeccion().createStatement();
        Usuario persona2=new Usuario();
        String query="SELECT * FROM usuario WHERE usu_correo ='"+correo+"'";
	ResultSet res = statement.executeQuery(query);
        if(!res.next())
           throw new SQLException("El usuario no esta registrado");
        else{
            //res.next();
            String pass=res.getString("usu_contrasena");
            if(pass.equals(contraseña)){
                persona2.setNombre(res.getString("usu_nombre"));
                persona2.setCorreo(res.getString("usu_correo"));
                persona2.setTelefono(res.getString("usu_telefono"));
                return persona2;
            }
            else
                throw new SQLException("La contraseña ingresada no es la correcta");
        } 
    }
}
