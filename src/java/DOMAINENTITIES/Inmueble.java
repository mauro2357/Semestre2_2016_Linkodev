/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMAINENTITIES;

import ConexionBaseDatos.ICalificacionDAO;
import ConexionBaseDatos.PublicacionDAO;
import ConexionBaseDatos.UsuariosDAOMysql;
import java.sql.SQLException;
import java.io.Serializable;

/**
 *
 * @author Mateo Ortiz Cano
 */
public class Inmueble implements Serializable {
    private String id;
    private String dueno;
    private String tipoOferta;
    private String tipoInmueble;
    private String ciudad;
    private String direccion;
    private String barrio;
    private String latitud;
    private String longitud;
    private String precio;
    private String habitaciones;
    private String banos;
    private String piso;
    private String area;
    private String estrato;
    private String fotourl;
    private int contadorVisitas;
    private int calificacion;
    private int contadorCalificacion;
    private ICalificacionDAO iCalificacionDAO;

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String lalitud) {
        this.latitud = lalitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    
    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getBanos() {
        return banos;
    }

    public void setBanos(String banos) {
        this.banos = banos;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    

    public String getFotourl() {
        return fotourl;
    }

    public void setFotourl(String fotourl) {
        this.fotourl = fotourl;
    }

    public int getContadorVisitas() {
        return contadorVisitas;
    }

    public void setContadorVisitas(int contadorVisitas) {
        this.contadorVisitas = contadorVisitas;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getContadorCalificacion() {
        return contadorCalificacion;
    }

    public void setContadorCalificacion(int contadorCalificacion) {
        this.contadorCalificacion = contadorCalificacion;
    }
    
}
