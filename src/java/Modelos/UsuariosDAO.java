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
    
    public void registrarUsuario(Usuario persona) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm;
        stm = nuevaconexion.getConeccion().createStatement();
        String query="INSERT INTO usuario VALUES ('"+persona.getNombre()+"','"
            +persona.getCorreo()+"','"+persona.getContraseña()+"','"
            +persona.getTelefono()+"','imagenes/nopic.png', 1)";
        try{
            stm.executeUpdate(query);
        }catch(SQLException ex){
            throw new SQLException("El correo ingresado ya se encuentra registrado");
        }
    }
    
    public Usuario modificarInformacionUsuario(Usuario persona) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm;
        stm = nuevaconexion.getConeccion().createStatement();
        Statement statement=nuevaconexion.getConeccion().createStatement();
        String query="SELECT * FROM usuario WHERE usu_correo ='"+persona.getCorreo()+"'";
        ResultSet res = statement.executeQuery(query);
        res.next();
        String pass=res.getString("usu_contrasena");
        if(pass.equals(persona.getContraseña())){
            String queryModificar = "UPDATE usuario SET usu_nombre='"+persona.getNombre()+"', "
                    + "usu_telefono ='"+persona.getTelefono() +"' "
                    + "where usu_correo = '"+persona.getCorreo()+"'";
            try{
                stm.executeUpdate(queryModificar);
                persona.setFotourl(res.getString("usu_fotourl"));
                return persona;
                
            }catch(SQLException ex){
  
                throw new SQLException("No se realizo correctamente la actualización");
            }
        }
        else
            throw new SQLException("La contraseña no es la correcta");
            
    }
    public Usuario  inicioSesionUsuario(UsuarioInicioSesion personaregistrada) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        String correo=personaregistrada.getCorreo();
        String contraseña=personaregistrada.getContraseña();
        Statement statement=nuevaconexion.getConeccion().createStatement();
        Usuario persona2=new Usuario();
        String query="SELECT * FROM usuario WHERE usu_correo ='"+correo+"'";
	ResultSet res = statement.executeQuery(query);
        if(!res.next()){
            throw new SQLException("El usuario no esta registrado");
        }   
        else{
            //res.next();
            String pass=res.getString("usu_contrasena");
            if(pass.equals(contraseña)){
                persona2.setNombre(res.getString("usu_nombre"));
                persona2.setCorreo(res.getString("usu_correo"));
                persona2.setTelefono(res.getString("usu_telefono"));
                persona2.setFotourl(res.getString("usu_fotourl"));
                return persona2;
            }
            else
                throw new SQLException("La contraseña ingresada no es la correcta");
        } 
    }
    
    public void cambiarFotoDePerfil(String fotourl, String correo) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm;
        stm = nuevaconexion.getConeccion().createStatement();
        String query = "UPDATE usuario SET usu_fotourl ='"+fotourl+"' "
                + "where usu_correo = '"+correo+"'";
        try{
            stm.executeUpdate(query);
        }catch(SQLException ex){
            throw new SQLException("Error! 404");
        }
    }

    public Usuario modificarContrasena(Usuario usr) throws SQLException {
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm;
        stm = nuevaconexion.getConeccion().createStatement();
        Statement statement=nuevaconexion.getConeccion().createStatement();
        String query="SELECT * FROM usuario WHERE usu_correo ='"+usr.getCorreo()+"'";
        ResultSet res = statement.executeQuery(query);
        res.next();
        String pass=res.getString("usu_contrasena");
        if(pass.equals(usr.getContraseña())){
            String queryModificar = "UPDATE usuario SET usu_contrasena='"+usr.getContraseñaCambio()+"' "
                    + "where usu_correo = '"+usr.getCorreo()+"'";
            try{
                stm.executeUpdate(queryModificar);
                usr.setFotourl(res.getString("usu_fotourl"));
                usr.setNombre(res.getString("usu_nombre"));
                usr.setTelefono(res.getString("usu_telefono"));
                usr.setContraseña(usr.getContraseñaCambio());
                return usr;
            }catch(SQLException ex){
                throw new SQLException("No se realizo correctamente la actualización");}
        }
        else
            throw new SQLException("La contraseña antigua no es la correcta");
            
    }

    public void desactivarCuenta(Usuario usr) throws SQLException {
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm;
        stm = nuevaconexion.getConeccion().createStatement();
        Statement statement=nuevaconexion.getConeccion().createStatement();
        String query="SELECT * FROM usuario WHERE usu_correo ='"+usr.getCorreo()+"'";
        ResultSet res = statement.executeQuery(query);
        res.next();
        String pass=res.getString("usu_contrasena");
        if(pass.equals(usr.getContraseña())){
            String queryModificar = "UPDATE usuario SET usu_estado="+0+" "
                    + "where usu_correo = '"+usr.getCorreo()+"'";
            try{
                stm.executeUpdate(queryModificar);
            }catch(SQLException ex){
                throw new SQLException("No se pudo desactivar la cuenta");}
        }
        else
            throw new SQLException("La contraseña antigua no es la correcta"+pass+" "+usr.getContraseña());
            
    }
}
