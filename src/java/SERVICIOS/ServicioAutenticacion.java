/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import ConexionBaseDatos.IUsuarioDAO;
import ConexionBaseDatos.UsuariosDAOMysql;
import DOMAINENTITIES.Usuario;
import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mateo Ortiz Cano
 */
@Path("servicioAutenticacion")
public class ServicioAutenticacion {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioPrueba
     */
    public ServicioAutenticacion() {
    }

    /**
     * Retrieves representation of an instance of SERVICIOS.ServicioAutenticacion
     * @param correo
     * @param contrasena
     * @return an instance of java.lang.String
     * @throws java.lang.Exception
     */
    @GET
    @Produces("application/json")
    public String getXml(@QueryParam ("datosUsuario") String datosUsuario){                
        Gson g=new Gson();        
        Usuario usr=g.fromJson(datosUsuario,Usuario.class);
        IUsuarioDAO iUsuarioDAO=new UsuariosDAOMysql();
        Usuario usuario=new Usuario(usr.getCorreo(),usr.getcontrasena());
        usuario.setiUsuarioDAO(iUsuarioDAO);
        try {              
            usuario=usuario.iniciarSesion();
            String UUSS=g.toJson(usuario);
            return UUSS;
        } catch (Exception ex) { 
            return g.toJson(ex.getMessage());
        }        
    }

    /**
     * PUT method for updating or creating an instance of ServicioAutenticacion
     * @param nombre
     * @param correo
     * @param telefono
     * @param contrasena
     * @throws java.lang.Exception
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putXml(@QueryParam ("correo") String correo,@QueryParam ("nombre") String nombre,@QueryParam ("telefono") String telefono,@QueryParam ("contrasena") String contrasena) throws Exception {
        Usuario usuario= new Usuario(nombre, correo, contrasena, telefono);
        usuario.registrar();
    }
}
