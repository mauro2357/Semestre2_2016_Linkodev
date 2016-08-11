/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import DTO.Publicacion;
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
    
    public void registrarPublicacion(Publicacion publicacion) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        PreparedStatement stm;
        String query="INSERT INTO publicacion VALUES ("+null+",?,?,?,?,?,?,?,?,?,?,?,?)";
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
        try{
            stm.executeUpdate();
            nuevaconexion.getConeccion().close();
            stm.close();
        }catch(SQLException ex){
            throw new SQLException(ex.getMessage());
        }
    }
    
    public ArrayList<Publicacion> mostrarPublicaciones(){
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm;
        ResultSet rs;
        Publicacion publicacion;
        ArrayList<Publicacion> arrayPublicaciones = new ArrayList<>();
        try{
            stm = nuevaconexion.getConeccion().createStatement();
            String query = "select * from publicaciones";
            rs = stm.executeQuery(query);
            while (rs.next()){
                publicacion = new Publicacion();
                publicacion.setTipoOferta(rs.getString("pub_dueno"));
                publicacion.setTipoOferta(rs.getString("pub_tipooferta"));
                publicacion.setTipoOferta(rs.getString("pub_tipoinmueble"));
                publicacion.setTipoOferta(rs.getString("pub_ciudad"));
                publicacion.setTipoOferta(rs.getString("pub_direccion"));
                publicacion.setTipoOferta(rs.getString("pub_barrio"));
                publicacion.setTipoOferta(rs.getString("pub_precio"));
                publicacion.setTipoOferta(rs.getString("pub_habitaciones"));
                publicacion.setTipoOferta(rs.getString("pub_banos"));
                publicacion.setTipoOferta(rs.getString("pub_piso"));
                publicacion.setTipoOferta(rs.getString("pub_area"));
                publicacion.setTipoOferta(rs.getString("pub_estrato"));
                arrayPublicaciones.add(publicacion);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return arrayPublicaciones;
    }
    
}
