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
public class Usuario {
    private String nombre;
    private String correo;
    private String contraseña;
    private String contraseñaCambio;
    private String telefono;
    private String fotourl;

    public Usuario(String nombre, String correo, String contraseña, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
    }
    
    public Usuario(String correo, String contraseña, String contraseñaCambio) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.contraseñaCambio=contraseñaCambio;
    }
    
     public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Usuario() {
        this.nombre = "";
        this.correo = "";
        this.contraseña = "";
        this.telefono = "";
        this.fotourl = "";
    }
    

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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFotourl() {
        return fotourl;
    }

    public void setFotourl(String fotourl) {
        this.fotourl = fotourl;
    }

    public String getContraseñaCambio() {
        return contraseñaCambio;
    }

    public void setContraseñaCambio(String contraseñaCambio) {
        this.contraseñaCambio = contraseñaCambio;
    }  
}
