/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMAINENTITIES;

import ConexionBaseDatos.AdministradorDAO;
import ConexionBaseDatos.UsuariosDAOMysql;
import java.sql.SQLException;

/**
 *
 * @author mateohenaocardona
 */
public class Administrador {
    private static Administrador INSTANCE = null;
    private String nombre;
    private String correo;
    private String contrasena;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public static Administrador getInstance(String nombre,String correo,String contrasena) {
        if (INSTANCE == null) {
            createInstance(nombre,correo,contrasena);
        }
        return INSTANCE;
    }
    
    public void registrar() throws Exception{
        AdministradorDAO admin = new AdministradorDAO();
        try {
            //if(INSTANCE==null){
                admin.registrarAdministrador(this);
              //  System.out.println("Es la primera hp vez");
            //}
            //else{
              //  System.out.println("ES una vez diferente");
            //}
        } catch (SQLException ex) {
            System.out.println("ex: "+ex);
            throw new Exception("Ya hay un administrador");
        }
    }
    
    private Administrador(String nombre,String correo,String contrasena){
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    private synchronized static void createInstance(String nombre,String correo,String contrasena) {
        if (INSTANCE == null) { 
            INSTANCE = new Administrador(nombre,correo,contrasena);
        }
    }

    
}
