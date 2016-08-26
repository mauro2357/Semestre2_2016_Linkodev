/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOS;

import DOMAINENTITIES.Usuario;
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
@Path("servicio1")
public class ServicioPrueba {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioPrueba
     */
    public ServicioPrueba() {
    }

    /**
     * Retrieves representation of an instance of SERVICIOS.ServicioPrueba
     * @param correo
     * @param contrasena
     * @return an instance of java.lang.String
     * @throws java.lang.Exception
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getXml(@QueryParam ("correo") String correo,@QueryParam ("contrasena") String contrasena) throws Exception {
        Usuario usuario=new Usuario(correo, contrasena);
        usuario=usuario.iniciarSesion();
        return usuario.getNombre()+usuario.getCorreo()+usuario.getTelefono();
    }

    /**
     * PUT method for updating or creating an instance of ServicioPrueba
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
