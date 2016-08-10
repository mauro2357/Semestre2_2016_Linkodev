/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import DTO.Publicacion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author felipe
 */
public class PublicacionDAO {
    
    public void registrarPublicacion(Publicacion publicacion) throws SQLException{
        ConexiónBD nuevaconexion=new ConexiónBD();
        PreparedStatement stm;
        stm = (PreparedStatement) nuevaconexion.getConeccion().createStatement();
        String query="INSERT INTO publicacion VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            stm.executeUpdate(query);
            nuevaconexion.getConeccion().close();
            stm.close();
        }catch(SQLException ex){
            throw new SQLException(ex.getMessage());
        }
    }
    
}
