/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMAINENTITIES;

import CLASESAUXILIARES.EnvioMail;
import CLASESAUXILIARES.GeneracionDeCodigos;
import ConexionBaseDatos.ICalificacionDAO;
import ConexionBaseDatos.IPublicacionDAO;
import ConexionBaseDatos.IUsuarioDAO;
import ConexionBaseDatos.PublicacionDAO;
import ConexionBaseDatos.UsuariosDAOMysql;
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
    private String contrasena;
    private String contrasenaCambio;
    private String telefono;
    private String fotourl;
    private IUsuarioDAO iUsuarioDAO;
    private IPublicacionDAO iPublicacionDAO;
    private ICalificacionDAO iCalificacionDAO;
    private int calificacion;
    private int contadorCalificacion;

    public Usuario(String nombre, String correo, String contrasena, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.iCalificacionDAO = new UsuariosDAOMysql();
    }

    public Usuario(String correo, String contrasena, String contrasenaCambio) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.contrasenaCambio = contrasenaCambio;
        this.iCalificacionDAO = new UsuariosDAOMysql();
        this.contrasena = contrasena;
        this.contrasenaCambio = contrasenaCambio;
    }

    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.iCalificacionDAO = new UsuariosDAOMysql();

        this.contrasena = contrasena;

    }

    public Usuario() {
        this.nombre = "";
        this.correo = "";
        this.contrasena = "";
        this.telefono = "";
        this.fotourl = "";
        this.iCalificacionDAO = new UsuariosDAOMysql();

    }

    public void setiUsuarioDAO(IUsuarioDAO iUsuarioDAO) {
        this.iUsuarioDAO = iUsuarioDAO;
    }

    public void setiPublicacionDAO(IPublicacionDAO iPublicacionDAO) {
        this.iPublicacionDAO = iPublicacionDAO;

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

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getcontrasenaCambio() {
        return contrasenaCambio;
    }

    public void setcontrasenaCambio(String contrasenaCambio) {
        this.contrasenaCambio = contrasenaCambio;
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
    public void registrar() throws Exception {
        try {
            iUsuarioDAO.registrarUsuario(this);
        } catch (SQLException ex) {
            throw new Exception("El correo ingresado ya se encuentra registrado");
        }
    }

    public Usuario modificarInformacion() throws Exception {
        String contrasenaFromBD = iUsuarioDAO.consultarcontrasena(this.getCorreo());
        if (!contrasenaFromBD.equals(this.getcontrasena())) {
            throw new Exception("La contrasena no coincide con su contrasena actual");
        }
        String url = iUsuarioDAO.obtenerFoto(this.getCorreo());
        Usuario usuarioI;
        try {
            usuarioI = iUsuarioDAO.modificarInformacion(this);
        } catch (SQLException ex) {
            throw new Exception("No se realizo correcamente la actualización");
        }
        usuarioI.setFotourl(url);
        return usuarioI;
    }

    public Usuario iniciarSesion() throws Exception {
        boolean existenciaUsuario = iUsuarioDAO.consultarCorreo(this.getCorreo());
        if (!existenciaUsuario) {
            throw new Exception("El correo ingresado no esta registrado");
        }
        String estadoCuenta = iUsuarioDAO.consultarEstado(this.getCorreo());
        if (estadoCuenta.equals("0")) {
            throw new Exception("Su cuenta ha sido desactivada, dirijase al boton activar de la ventana de inicio de sesion");
        }
        String contrasenaFromBD = iUsuarioDAO.consultarcontrasena(this.getCorreo());
        if (!contrasenaFromBD.equals(this.getcontrasena())) {
            throw new Exception("La contrasena no coincide con su contrasena actual");
        }
        Usuario usuario = iUsuarioDAO.obtenerDatos(this.getCorreo());
        return usuario;
    }

    public Usuario cambiarcontrasena() throws SQLException, Exception {
        String contrasenaFromBD = iUsuarioDAO.consultarcontrasena(this.getCorreo());
        if (!contrasenaFromBD.equals(this.getcontrasena())) {
            throw new Exception("La contrasena no coincide con su contrasena actual");
        }
        try {
            iUsuarioDAO.modificarContrasena(this);
        } catch (SQLException ex) {
            throw new Exception("No se realizo correctamente la actualización");
        }
        Usuario usuario = iUsuarioDAO.obtenerDatos(this.getCorreo());
        return usuario;
    }

    public void contrasenaNuevaConfirmacion() throws SQLException, Exception {
        try {
            iUsuarioDAO.modificarContrasena(this);
        } catch (SQLException ex) {
            throw new Exception("No se pudo cambiar a la nueva contrasena");
        }
    }

    public void desactivarCuenta() throws SQLException, Exception {
        String contrasenaFromBD = iUsuarioDAO.consultarcontrasena(this.getCorreo());
        if (!contrasenaFromBD.equals(this.getcontrasena())) {
            throw new Exception("La contrasena no coincide con su contrasena actual");
        }
        try {
            iUsuarioDAO.desactivarCuenta(this);
        } catch (SQLException ex) {
            throw new Exception("La cuenta no se desactivo correctamente, intente nuevamente");
        }
    }

    public String reestablecerContrasena(String correoaBuscar) throws Exception {
        GeneracionDeCodigos gencodigo = new GeneracionDeCodigos();
        String codigo = gencodigo.getPassword();
        EnvioMail mail = new EnvioMail();
        if (!iUsuarioDAO.consultarCorreo(correoaBuscar)) {
            throw new Exception("No tenemos ningún usuario registrado con ese correo");
        }
        mail.enviarMail(correoaBuscar, codigo);
        return codigo;
    }

    public void verificarCodigoContrasena(String codigouno, String codigodos) throws Exception {
        if (codigouno.equals(codigodos)) {
            return;
        }
        throw new Exception("El codigo de activación no concuerda");
    }

    public void registrarPublicacion(Inmueble publicacion) throws SQLException {
        try {
            iPublicacionDAO.registrarPublicacion(publicacion);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public ArrayList<Inmueble> consultarPublicacionesByUsuario(String correo) throws Exception {
        if (!iUsuarioDAO.consultarCorreo(correo)) {
            throw new Exception("El usuario ingresado no existe");
        }
        PublicacionDAO conexion = new PublicacionDAO();
        ArrayList<Inmueble> publicaciones = new ArrayList<>();
        try {
            publicaciones = conexion.consultarByUsuario(correo);
        } catch (SQLException ex) {
            throw new Exception("El usuario: " + correo + " no tiene ningun inmueble publicado");
        }
        return publicaciones;
    }

    public Inmueble DetallarInmueble(String id) throws SQLException {
        Inmueble pub = iPublicacionDAO.Detallar(id);
        return pub;
    }

    public void ModificarPublicacion(Inmueble publicacion) throws SQLException {
        try {
            iPublicacionDAO.ModificarPublicacion(publicacion);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void adquirir(Inmueble inmueble) throws SQLException {
        try {
            iPublicacionDAO.ActualizarEstadoInmueble(inmueble);
        } catch (SQLException ex) {
            throw ex;
        }
        try {
            iPublicacionDAO.registrarAdquisision(inmueble,this.correo);
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public ArrayList obtenerNotificaciones() throws SQLException {
        ArrayList mensajes=new ArrayList<>();
        try {
            mensajes= iUsuarioDAO.obtenerNotificaciones(this.correo);
        } catch (SQLException ex) {
            throw ex;
        }        
        if(mensajes.isEmpty())
            mensajes.add("No tiene notificaciones pendientes");
        return mensajes;
    }
    public ArrayList<Inmueble> filtrarPublicaciones(Inmueble inmueble) throws Exception {
        ArrayList<Inmueble> publicaciones = new ArrayList<>();
        try {
            publicaciones = iPublicacionDAO.filtrarPublicaciones(inmueble);
        } catch (SQLException ex) {
            throw new Exception("No se encontraron publicaciones que coincidan con tu búsqueda ");
        }
        return publicaciones;
    }
    
    public ArrayList<Inmueble> mostrarPublicaciones() throws Exception {
        ArrayList<Inmueble> publicaciones = new ArrayList<>();
        try {
            publicaciones = iPublicacionDAO.mostrarPublicaciones();
        } catch (SQLException ex) {
            throw new Exception("No se encontraron publicaciones que mostrar");
        }
        return publicaciones;
    }
    
    public void eliminarNotificacion(String mensaje) throws Exception{
        try {
            iUsuarioDAO.eliminarNotificacion(mensaje,this.correo);
        } catch (SQLException ex) {
            throw new Exception("Error!");
        }
    }
    
    public int consultarIdUltimaPublicacion(String correo) throws Exception{
        int Idpub = 0;
        try {
            Idpub =iPublicacionDAO.consultarIdUltimaPublicacion(correo);
        } catch (SQLException ex) {
            throw new Exception("Error! "+ex.getMessage());
        }
        return Idpub;
    }
    
    public void guardarFotosPublicacion(String url, int id) throws Exception{
        try {
            iPublicacionDAO.guardarFotosPublicacion(url,id);
        } catch (SQLException ex) {
            throw new Exception("Error! "+ex.getMessage());
        }
    }
    
    public void establecerFotoPublicacion(String url,int id) throws Exception {
        try {
            iPublicacionDAO.establecerFotoPublicacion(url,id);
        } catch (SQLException ex) {
            throw new Exception("Error! "+ex.getMessage());
        }
    }
}
