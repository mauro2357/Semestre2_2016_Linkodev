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
public class PublicacionDAO implements IPublicacionDAO,ICalificacionDAO{

    @Override
    public void registrarPublicacion(Inmueble publicacion) throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        PreparedStatement stm;
        String query = "INSERT INTO publicacion (pub_id,usu_correo,pub_tipooferta,pub_tipoinmueble,pub_ciudad,pub_direccion,pub_barrio,pub_precio,pub_habitaciones,pub_banos,pub_piso,pub_area,pub_estrato,pub_contador,pub_estado,pub_sumacalificacion,pub_contadorcalificadores,pub_latitud,pub_longitud,pub_fotourl) VALUES (" + null + ",?,?,?,?,?,?,?,?,?,?,?,?,0,0,0,0,?,?,0)";
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
        stm.setString(13, publicacion.getLatitud());
        stm.setString(14, publicacion.getLongitud());
        
        try {
            stm.executeUpdate();
            nuevaconexion.getConeccion().close();
            stm.close();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    @Override
    public void ModificarPublicacion(Inmueble publicacion) throws SQLException {
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm = nuevaconexion.getConeccion().createStatement();
        String query = "UPDATE  publicacion SET pub_tipooferta='"+publicacion.getTipoOferta()
                +"', pub_tipoinmueble='"+publicacion.getTipoInmueble()+"', pub_ciudad='"+publicacion.getCiudad()
                +"', pub_direccion='"+publicacion.getDireccion()+"', pub_barrio='"+publicacion.getBarrio()
                +"', pub_precio='"+publicacion.getPrecio()+"',pub_habitaciones='"+publicacion.getHabitaciones()
                +"',pub_banos='"+publicacion.getBanos()+"', pub_area='"+publicacion.getArea()
                +"',pub_estrato='"+publicacion.getEstrato()+"',pub_contador="+publicacion.getContadorVisitas()+"', pub_latitud='"+publicacion.getLatitud()
                +"',pub_longitud='"+publicacion.getLongitud()+" where pub_id="+publicacion.getId();
        stm.executeUpdate(query);
    }

    @Override
    public ArrayList<Inmueble> mostrarPublicaciones() throws SQLException {
        ConexiónBD nuevaconexion = new ConexiónBD();
        Statement stm;
        ResultSet rs;
        Inmueble publicacion;
        ArrayList<Inmueble> arrayPublicaciones = new ArrayList<>();
        stm = nuevaconexion.getConeccion().createStatement();
        String query = "select * from publicacion WHERE pub_estado=0" ;
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
            publicacion.setLongitud(rs.getString("pub_longitud"));
            publicacion.setLatitud(rs.getString("pub_latitud"));
            publicacion.setFotourl(rs.getString("pub_fotourl"));
            arrayPublicaciones.add(publicacion);            
        }
        return arrayPublicaciones;
    }
    
    @Override
    public ArrayList<Inmueble> consultarByUsuario(String correo) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query = "SELECT * FROM publicacion WHERE usu_correo= '" + correo + "'";
        ResultSet res = statement.executeQuery(query);
        Inmueble publicacion;
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
            publicacion.setLongitud(res.getString("pub_longitud"));
            publicacion.setLatitud(res.getString("pub_latitud"));
            publicacion.setFotourl(res.getString("pub_fotourl"));
            arrayPublicaciones.add(publicacion);
            existencia = true;
        }
        if (!existencia) {
            throw new SQLException("El usuario no tiene publicaciones actualmente");
        }
        return arrayPublicaciones;
    }

    @Override
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
        publicacion.setCalificacion(res.getInt("pub_contadorcalificadores"));
        publicacion.setContadorCalificacion(res.getInt("pub_sumacalificacion"));
        publicacion.setLongitud(res.getString("pub_longitud"));
        publicacion.setLatitud(res.getString("pub_latitud"));
        publicacion.setFotourl(res.getString("pub_fotourl"));
        return publicacion;
    }
    
    
    @Override
    public void contadorVisitas(String id) throws SQLException{
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query1 = "SELECT * FROM publicacion WHERE pub_id= " + id;
        ResultSet res = statement.executeQuery(query1);
        res.next();
        int valor;
        valor = Integer.parseInt(res.getString("pub_contador"));
        valor++;
        String query2 = "UPDATE publicacion SET pub_contador ="+valor+" where pub_id = "+id;
        statement.executeUpdate(query2);
    }
    
    @Override
    public ArrayList<Inmueble> filtrarPublicaciones(Inmueble inmueble) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        boolean tipooferta = false,tipoinmueble = false,ciudad = false,precio = false;
        if(inmueble.getTipoOferta() != null)
            tipooferta = true;
        if(inmueble.getTipoInmueble() != null)
            tipoinmueble = true;
        if(inmueble.getCiudad() != null)
            ciudad = true;
        if(inmueble.getPrecio() != null)
            precio = true;
        String query = "select * from publicacion "
                + "where IF("+tipooferta+", pub_tipooferta = '"+inmueble.getTipoOferta()+"' , true) and "
                + "IF("+tipoinmueble+", pub_tipoinmueble = '"+inmueble.getTipoInmueble()+"' ,true) and "
                + "IF("+ciudad+", pub_ciudad = '"+inmueble.getCiudad()+"' , true) and "
                + "IF("+precio+", pub_precio= '"+inmueble.getPrecio()+"' , true) and pub_estado = 0";
        ResultSet res = statement.executeQuery(query);
        Inmueble publicacion;
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
            publicacion.setLongitud(res.getString("pub_longitud"));
            publicacion.setLatitud(res.getString("pub_latitud"));
            publicacion.setFotourl(res.getString("pub_fotourl"));
            arrayPublicaciones.add(publicacion);
            existencia = true;
        }
        if (!existencia) {
            throw new SQLException("No se encontraron publicaciones que coincidan con tu búsqueda 2");
        }
        return arrayPublicaciones;
    }
    @Override
    public void ActualizarEstadoInmueble(Inmueble inmueble) throws SQLException{
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query = " UPDATE publicacion set pub_estado=1 where pub_id="+inmueble.getId();
        statement.executeUpdate(query);
    }
    
    @Override
    public void registrarAdquisision(Inmueble inmueble,String correo) throws SQLException{
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query = "INSERT INTO Adquisiciones (usu_correo,pub_id) VALUES ('"+correo+"',"+inmueble.getId()+")";
        statement.executeUpdate(query);
        this.agregarNotificacion(inmueble, correo);
    }
    private void agregarNotificacion(Inmueble inmueble,String correo) throws SQLException{
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String mensaje="El usuario "+correo+" ha adquirido tu publicacion "+inmueble.getId();
        String query = "INSERT INTO notificaciones (cliente,dueno,mensaje) VALUES ('"+correo+"','"+inmueble.getDueno()+"','"+mensaje+"')";
        statement.executeUpdate(query);
    }

    private void insertarSuma(int calificacion,String identificador) throws SQLException{
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();  
        String query1 = "SELECT (pub_sumacalificacion) FROM publicacion WHERE pub_id= " + identificador;
        ResultSet res = statement.executeQuery(query1);
        res.next();
        int valor;
        valor = Integer.parseInt(res.getString("pub_sumacalificacion"));
        valor += calificacion;
        String query2 = "UPDATE publicacion SET pub_sumacalificacion ="+valor+" where pub_id = "+identificador;
        statement.executeUpdate(query2);
    }
    
    @Override
    public void calificar(int calificacion,String identificador) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query1 = "SELECT (pub_contadorcalificadores) FROM publicacion WHERE pub_id= " + identificador;
        ResultSet res = statement.executeQuery(query1);
        res.next();
        int valor;
        valor = Integer.parseInt(res.getString("pub_contadorcalificadores"));
        valor += calificacion;
        String query2 = "UPDATE publicacion SET pub_contadorcalificadores ="+valor+" where pub_id = "+identificador;
        statement.executeUpdate(query2);
        insertarSuma(calificacion, identificador);
    }   

    @Override
    public void guardarFotosPublicacion(String url,int id) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query = "INSERT INTO fotos (fot_id,pub_id,fot_url) VALUES(" + null + ",'"+id+"','"+url+"')";
        try {
            statement.executeUpdate(query);
            conexion.getConeccion().close();
            statement.close();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    @Override
    public void establecerFotoPublicacion(String url, int id) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query = "UPDATE publicacion set pub_fotourl = '"+url+"' where pub_id="+id;
        try {
            statement.executeUpdate(query);
            conexion.getConeccion().close();
            statement.close();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    @Override
    public int consultarIdUltimaPublicacion(String correo) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query = "SELECT max(pub_id) from publicacion where usu_correo = '"+correo+"'";
        ResultSet res = statement.executeQuery(query);
        while (res.next()) {
            return res.getInt(1);
        }
        return -1;
    }

    @Override
    public void eliminarPublicacion(String id) throws SQLException {
        ConexiónBD conexion = new ConexiónBD();
        Statement statement = conexion.getConeccion().createStatement();
        String query1 = "DELETE FROM fotos WHERE pub_id ='"+id+"'";
        String query2 = "DELETE FROM publicacion WHERE pub_id ='"+id+"'";
        try {
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

}
