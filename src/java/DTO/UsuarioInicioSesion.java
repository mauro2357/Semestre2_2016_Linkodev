/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author linkcodev
 */
public class UsuarioInicioSesion {
    private String correo;
    private String contraseña;

    public UsuarioInicioSesion(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
      public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
}
