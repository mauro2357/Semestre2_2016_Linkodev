/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBaseDatos;

import DOMAINENTITIES.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mateo Ortiz Cano
 */
public class UsuariosDAOMysql implements IUsuarioDAO,ICalificacionDAO{

    /**
     *
     * @param persona
     * @throws SQLException
     */
    @Override
    public void registrarUsuario(Usuario persona) throws SQLException {
        Encriptacion encriptarcontrasena = new Encriptacion();
        String contrasenaEncriptada = encriptarcontrasena.Encriptar(persona.getcontrasena());
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement stm = nuevaconexion.getConeccion().createStatement();
        String query="INSERT INTO usuario VALUES ('"+persona.getNombre()+"','"
            +persona.getCorreo()+"','"+contrasenaEncriptada+"','"
            +persona.getTelefono()+"','imagenes/nopic.png', 1, 0,0,0)";
        stm.executeUpdate(query);
    }

    @Override
    public String consultarcontrasena(String correoUsuario) throws SQLException, Exception {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Encriptacion desencriptarcontrasena = new Encriptacion();
        Statement statement = nuevaconexion.getConeccion().createStatement();
        String query = "SELECT * FROM usuario WHERE usu_correo ='" + correoUsuario + "'";
        ResultSet res = statement.executeQuery(query);
        res.next();
        String contrasena = desencriptarcontrasena.Desencriptar(res.getString("usu_contrasena"));
        return contrasena;
    }

    @Override
    public String obtenerFoto(String correoUsuario) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement statement = nuevaconexion.getConeccion().createStatement();
        String query = "SELECT * FROM usuario WHERE usu_correo ='" + correoUsuario + "'";
        ResultSet res = statement.executeQuery(query);
        res.next();
        String foto = res.getString("usu_fotourl");
        return foto;
    }

    @Override
    public Usuario modificarInformacion(Usuario persona) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement stm = nuevaconexion.getConeccion().createStatement();
        String queryModificar = "UPDATE usuario SET usu_nombre='" + persona.getNombre() + "', "
                + "usu_telefono ='" + persona.getTelefono() + "' "
                + "where usu_correo = '" + persona.getCorreo() + "'";
        stm.executeUpdate(queryModificar);
        return persona;
    }

    @Override
    public boolean consultarCorreo(String correoUsuario) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement statement = nuevaconexion.getConeccion().createStatement();
        String query = "SELECT * FROM usuario WHERE usu_correo ='" + correoUsuario + "'";
        ResultSet res = statement.executeQuery(query);
        if (!res.next()) {
            return false;
        }
        return true;
    }

    @Override
    public String consultarEstado(String correoUsuario) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement statement = nuevaconexion.getConeccion().createStatement();
        String query = "SELECT * FROM usuario WHERE usu_correo ='" + correoUsuario + "'";
        ResultSet res = statement.executeQuery(query);
        res.next();
        String estado = res.getString("usu_estado");
        return estado;
    }

    @Override
    public Usuario obtenerDatos(String correoUsuario) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement statement = nuevaconexion.getConeccion().createStatement();
        String query = "SELECT * FROM usuario WHERE usu_correo ='" + correoUsuario + "'";
        ResultSet res = statement.executeQuery(query);
        res.next();
        Usuario usuario = new Usuario();
        usuario.setNombre(res.getString("usu_nombre"));
        usuario.setCorreo(res.getString("usu_correo"));
        usuario.setTelefono(res.getString("usu_telefono"));
        usuario.setFotourl(res.getString("usu_fotourl"));
        usuario.setCalificacion(res.getInt("usu_sumacalificacion"));
        usuario.setContadorCalificacion(res.getInt("usu_contadorcalificadores"));
        return usuario;
    }

    @Override
    public void modificarContrasena(Usuario usr) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Encriptacion encriptarcontrasena = new Encriptacion();
        System.out.println("contrasena actual" + usr.getcontrasenaCambio());
        System.out.println("contrasena encriptada" + encriptarcontrasena.Encriptar(usr.getcontrasenaCambio()));
        String contrasena = encriptarcontrasena.Encriptar(usr.getcontrasenaCambio());
        Statement stm = nuevaconexion.getConeccion().createStatement();
        String queryModificar = "UPDATE usuario SET usu_contrasena='" + contrasena + "' "
                + "where usu_correo = '" + usr.getCorreo() + "'";
        stm.executeUpdate(queryModificar);
    }

    @Override
    public void desactivarCuenta(Usuario usr) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement stm = nuevaconexion.getConeccion().createStatement();
        String queryModificar = "UPDATE usuario SET usu_estado=" + 0 + " "
                + "where usu_correo = '" + usr.getCorreo() + "'";
        stm.executeUpdate(queryModificar);
    }

    @Override
    public void cambiarFotoDePerfil(String fotourl, String correo) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement stm = nuevaconexion.getConeccion().createStatement();
        String query = "UPDATE usuario SET usu_fotourl ='" + fotourl + "' "
                + "where usu_correo = '" + correo + "'";
        try {
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            throw new SQLException("Error! 404");
        }
    }
    
    private void insertarSuma(int calificacion,String identificador) throws SQLException{
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();                      
        String query = " UPDATE usuario as t1 SET t1.usu_sumacalificacion = "
                + "         (select * from (SELECT t2.usu_sumacalificacion + "+calificacion+" FROM usuario as t2 "
                + "         where t2.usu_correo = '"+identificador+"') as x) where t1.usu_correo ='" + identificador +"'";
        statement.executeUpdate(query);
    }

    @Override
    public void calificar(int calificacion, String identificador) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement(); 
        String query = " UPDATE usuario as t1 SET t1.usu_contadorcalificadores = "
                + "         (select * from (SELECT t2.usu_contadorcalificadores +1 FROM usuario as t2 "
                + "         where t2.usu_correo = '"+identificador+"') as x) where t1.usu_correo ='" + identificador +"'";
        statement.executeUpdate(query);
        insertarSuma(calificacion, identificador);
    }

    @Override
    public ArrayList obtenerNotificaciones(String correo) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        ArrayList mensajes=new ArrayList();        
        Statement statement = nuevaconexion.getConeccion().createStatement();
        String query = "SELECT * FROM notificaciones WHERE dueno ='" + correo + "'";
        ResultSet res = statement.executeQuery(query);
        while (res.next()) {                                    
            mensajes.add(res.getString("mensaje"));          
        }
        return mensajes;
    }
}
