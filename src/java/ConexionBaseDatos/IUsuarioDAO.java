/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBaseDatos;

import DOMAINENTITIES.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mateo Ortiz Cano
 */
public interface IUsuarioDAO {

    public void registrarUsuario(Usuario persona)throws SQLException;

    public String consultarContraseña(String correoUsuario)throws SQLException, Exception;

    public String obtenerFoto(String correoUsuario)throws SQLException;

    public Usuario modificarInformacion(Usuario persona)throws SQLException;

    public boolean consultarCorreo(String correoUsuario)throws SQLException;

    public String consultarEstado(String correoUsuario)throws SQLException;

    public Usuario obtenerDatos(String correoUsuario)throws SQLException;

    public void modificarContrasena(Usuario usr)throws SQLException;

    public void desactivarCuenta(Usuario usr)throws SQLException;

    public void cambiarFotoDePerfil(String fotourl, String correo)throws SQLException;

    public ArrayList obtenerNotificaciones(String correo) throws SQLException;
}
