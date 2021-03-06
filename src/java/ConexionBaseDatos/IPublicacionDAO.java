/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBaseDatos;

import DOMAINENTITIES.Inmueble;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mateo Ortiz Cano
 */
public interface IPublicacionDAO {

    public void registrarPublicacion(Inmueble publicacion) throws SQLException;

    public void ModificarPublicacion(Inmueble publicacion) throws SQLException;

    public ArrayList<Inmueble> mostrarPublicaciones() throws SQLException;

    public ArrayList<Inmueble> consultarByUsuario(String correo) throws SQLException;

    public Inmueble Detallar(String id) throws SQLException;

    public void contadorVisitas(String id) throws SQLException;
    
    public ArrayList<Inmueble> filtrarPublicaciones(Inmueble inmueble) throws SQLException;

    public void ActualizarEstadoInmueble(Inmueble inmueble) throws SQLException;

    public void registrarAdquisision(Inmueble inmueble, String correo) throws SQLException;
    
    public void guardarFotosPublicacion(String url,int id)throws SQLException;
    
    public void establecerFotoPublicacion(String url,int id)throws SQLException;
    
    public int consultarIdUltimaPublicacion(String correo) throws SQLException;
    
    public void eliminarPublicacion(String id) throws SQLException;
}
