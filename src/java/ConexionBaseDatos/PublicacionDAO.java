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
 * @author felipe
 */
public class PublicacionDAO {

    public void registrarPublicacion(Inmueble publicacion) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        PreparedStatement stm;
        String query = "INSERT INTO publicacion VALUES (" + null + ",?,?,?,?,?,?,?,?,?,?,?,?,0)";
        stm = nuevaconexion.getConeccion().prepareStatement(query);
        stm.setString(1, publicacion.getDueno());
        stm.setString(2, publicacion.getTipoOferta());
        stm.setString(3, publicacion.getTipoInmueble());
        stm.setString(4, publicacion.getCiudad());
        stm.setString(5, publicacion.getDireccion());
        stm.setString(6, publicacion.getBarrio());
        stm.setString(7, publicacion.getPrecio());
        stm.setString(8, publicacion.getHabitaciones());
        stm.setString(9, publicacion.getBanos());
        stm.setString(10, publicacion.getPiso());
        stm.setString(11, publicacion.getArea());
        stm.setString(12, publicacion.getEstrato());
        try {
            stm.executeUpdate();
            nuevaconexion.getConeccion().close();
            stm.close();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    public void ModificarPublicacion(Inmueble publicacion) throws SQLException {
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm = nuevaconexion.getConeccion().createStatement();
        String query = "UPDATE  publicacion SET pub_tipooferta='"+publicacion.getTipoOferta()
                +"', pub_tipoinmueble='"+publicacion.getTipoInmueble()+"', pub_ciudad='"+publicacion.getCiudad()
                +"', pub_direccion='"+publicacion.getDireccion()+"', pub_barrio='"+publicacion.getBarrio()
                +"', pub_precio='"+publicacion.getPrecio()+"',pub_habitaciones='"+publicacion.getHabitaciones()
                +"',pub_banos='"+publicacion.getBanos()+"', pub_area='"+publicacion.getArea()
                +"',pub_estrato='"+publicacion.getEstrato()+"',pub_contador="+publicacion.getContadorVisitas()+" where pub_id="+publicacion.getId();
        stm.executeUpdate(query);
    }

    public ArrayList<Inmueble> mostrarPublicaciones() throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement stm;
        ResultSet rs;
        Inmueble publicacion;
        ArrayList<Inmueble> arrayPublicaciones = new ArrayList<>();
        stm = nuevaconexion.getConeccion().createStatement();
        String query = "select * from publicacion";
        rs = stm.executeQuery(query);
        while (rs.next()) {
            publicacion = new Inmueble();
            publicacion.setDueno(rs.getString("usu_correo"));
            publicacion.setTipoOferta(rs.getString("pub_tipooferta"));
            publicacion.setTipoInmueble(rs.getString("pub_tipoinmueble"));
            publicacion.setCiudad(rs.getString("pub_ciudad"));
            publicacion.setDireccion(rs.getString("pub_direccion"));
            publicacion.setBarrio(rs.getString("pub_barrio"));
            publicacion.setPrecio(rs.getString("pub_precio"));
            publicacion.setHabitaciones(rs.getString("pub_habitaciones"));
            publicacion.setBanos(rs.getString("pub_banos"));
            publicacion.setPiso(rs.getString("pub_piso"));
            publicacion.setArea(rs.getString("pub_area"));
            publicacion.setEstrato(rs.getString("pub_estrato"));
            publicacion.setId(rs.getString("pub_id"));
            arrayPublicaciones.add(publicacion);            
        }
        return arrayPublicaciones;
    }
    
    public ArrayList<Inmueble> consultarByUsuario(String correo) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query = "SELECT * FROM publicacion WHERE usu_correo= '" + correo + "'";
        ResultSet res = statement.executeQuery(query);
        Inmueble publicacion = new Inmueble();
        ArrayList<Inmueble> arrayPublicaciones = new ArrayList<>();
        boolean existencia = false;
        while (res.next()) {
            publicacion = new Inmueble();
            publicacion.setDueno(res.getString("usu_correo"));
            publicacion.setTipoOferta(res.getString("pub_tipooferta"));
            publicacion.setTipoInmueble(res.getString("pub_tipoinmueble"));
            publicacion.setCiudad(res.getString("pub_ciudad"));
            publicacion.setDireccion(res.getString("pub_direccion"));
            publicacion.setBarrio(res.getString("pub_barrio"));
            publicacion.setPrecio(res.getString("pub_precio"));
            publicacion.setHabitaciones(res.getString("pub_habitaciones"));
            publicacion.setBanos(res.getString("pub_banos"));
            publicacion.setPiso(res.getString("pub_piso"));
            publicacion.setArea(res.getString("pub_area"));
            publicacion.setEstrato(res.getString("pub_estrato"));
            publicacion.setId(res.getString("pub_id"));
            arrayPublicaciones.add(publicacion);
            existencia = true;
        }
        if (!existencia) {
            throw new SQLException("El usuario no tiene publicaciones actualmente");
        }
        return arrayPublicaciones;
    }

    public Inmueble Detallar(String id) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query = "SELECT * FROM publicacion WHERE pub_id= " + id;
        ResultSet res = statement.executeQuery(query);
        Inmueble publicacion = new Inmueble();
        res.next();
        publicacion.setDueno(res.getString("usu_correo"));
        publicacion.setTipoOferta(res.getString("pub_tipooferta"));
        publicacion.setTipoInmueble(res.getString("pub_tipoinmueble"));
        publicacion.setCiudad(res.getString("pub_ciudad"));
        publicacion.setDireccion(res.getString("pub_direccion"));
        publicacion.setBarrio(res.getString("pub_barrio"));
        publicacion.setPrecio(res.getString("pub_precio"));
        publicacion.setHabitaciones(res.getString("pub_habitaciones"));
        publicacion.setBanos(res.getString("pub_banos"));
        publicacion.setPiso(res.getString("pub_piso"));
        publicacion.setArea(res.getString("pub_area"));
        publicacion.setEstrato(res.getString("pub_estrato"));
        publicacion.setId(res.getString("pub_id"));
        contadorVisitas(id);
        publicacion.setContadorVisitas(res.getInt("pub_contador"));
        return publicacion;
    }
    
    
    public void contadorVisitas(String id) throws SQLException{
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query = " UPDATE publicacion as t1 SET t1.pub_contador = "
                + "         (select * from (SELECT t2.pub_contador + 1 FROM publicacion as t2 "
                + "         where t2.pub_id = '"+id+"') as x) where t1.pub_id ='" + id +"'";
        statement.executeUpdate(query);
    }
    
}
