/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMAINENTITIES;

import CLASESAUXILIARES.EnvioMail;
import CLASESAUXILIARES.GeneracionDeCodigos;
import ConexionBaseDatos.PublicacionDAO;
import ConexionBaseDatos.UsuariosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo Ortiz Cano
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
    
    public void registrar() throws Exception{
        UsuariosDAO NuevoUsuario=new UsuariosDAO();
        try {
            NuevoUsuario.registrarUsuario(this);
        } catch (SQLException ex) {
            throw new Exception("El correo ingresado ya se encuentra registrado");
        }
    }
    
    public Usuario modificarInformacion() throws Exception{
        UsuariosDAO conexion= new UsuariosDAO();
        String contrasenaFromBD=conexion.consultarContraseña(this.getCorreo());
        if(!contrasenaFromBD.equals(this.getContraseña())){
            throw new Exception("La contraseña no coincide con su contraseña actual");
        }
        String url=conexion.obtenerFoto(this.getCorreo());
        Usuario usuarioI;
        try{
            usuarioI=conexion.modificarInformacion(this);
        }catch(SQLException ex){
            throw new Exception("No se realizo correcamente la actualización");
        }
        usuarioI.setFotourl(url);
        return usuarioI;
    }
    
    public Usuario iniciarSesion() throws Exception{
        UsuariosDAO conexion= new UsuariosDAO();
        boolean existenciaUsuario=conexion.consultarCorreo(this.getCorreo());
        if(!existenciaUsuario)
            throw new Exception("El correo ingresado no esta registrado");
        String estadoCuenta=conexion.consultarEstado(this.getCorreo());
        if(estadoCuenta.equals("0"))
            throw new Exception("Su cuenta ha sido desactivada, dirijase al boton activar de la ventana de inicio de sesion");
        String contrasenaFromBD=conexion.consultarContraseña(this.getCorreo());
        if(!contrasenaFromBD.equals(this.getContraseña())){
            throw new Exception("La contraseña no coincide con su contraseña actual");
        }
        Usuario usuario=conexion.obtenerDatos(this.getCorreo());
        return usuario;
    }
    
    public Usuario cambiarContraseña() throws SQLException, Exception{
        UsuariosDAO conexion= new UsuariosDAO();
        String contrasenaFromBD=conexion.consultarContraseña(this.getCorreo());
        if(!contrasenaFromBD.equals(this.getContraseña())){
            throw new Exception("La contraseña no coincide con su contraseña actual");
        }
        try{
            conexion.modificarContrasena(this);
        }catch(SQLException ex){
            throw new Exception("No se realizo correctamente la actualización");
        }
        Usuario usuario=conexion.obtenerDatos(this.getCorreo());
        return usuario;
    }
    
    public void desactivarCuenta() throws SQLException, Exception{
        UsuariosDAO conexion= new UsuariosDAO();
        String contrasenaFromBD=conexion.consultarContraseña(this.getCorreo());
        if(!contrasenaFromBD.equals(this.getContraseña())){
            throw new Exception("La contraseña no coincide con su contraseña actual");
        }
        try{
            conexion.desactivarCuenta(this);
        }catch(SQLException ex){
            throw new Exception("La cuenta no se desactivo correctamente, intente nuevamente");
        }
    }
    
    public String reestablecerContrasena(String correoaBuscar) throws Exception{
        UsuariosDAO conexion = new UsuariosDAO();
        GeneracionDeCodigos gencodigo = new GeneracionDeCodigos();
        String codigo = gencodigo.getPassword();
        EnvioMail mail = new EnvioMail();
        if(!conexion.consultarCorreo(correoaBuscar)){
            throw new Exception("No tenemos ningún usuario registrado con ese correo");
        }
        mail.enviarMail(correoaBuscar,codigo);
        return codigo;
    }
    
    public void verificarCodigoContrasena(String codigouno, String codigodos) throws Exception{
        if(codigouno.equals(codigodos)){
            return;      
        }
        throw new Exception("Los codigos de activación no concuerdan");
    }
    
    public void registrarPublicacion(Publicacion publicacion) throws SQLException{
        PublicacionDAO conexion= new PublicacionDAO();
        try {
            conexion.registrarPublicacion(publicacion);
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
    
    public ArrayList<Publicacion> consultarPublicacionesByUsuario(String correo) throws Exception{
        UsuariosDAO conexUsuario=new UsuariosDAO();
        if(!conexUsuario.consultarCorreo(correo)){
            throw new Exception("El usuario ingresado no existe");
        }
        PublicacionDAO conexion=new PublicacionDAO();
        ArrayList<Publicacion> publicaciones= new ArrayList<>();
        try {
            publicaciones=conexion.consultarByUsuario(correo);
        } catch (SQLException ex) {
            throw new Exception("El usuario: "+correo+" no tiene ningun inmueble publicado");
        }
        return publicaciones;
    }
}
