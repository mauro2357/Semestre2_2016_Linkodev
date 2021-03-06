/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACIONCONTROLADORES;

import ConexionBaseDatos.IPublicacionDAO;
import ConexionBaseDatos.IUsuarioDAO;
import ConexionBaseDatos.PublicacionDAO;
import ConexionBaseDatos.UsuariosDAOMysql;
import DOMAINENTITIES.CreadorApartamento;
import DOMAINENTITIES.CreadorBodegas;
import DOMAINENTITIES.CreadorCasas;
import DOMAINENTITIES.CreadorFincas;
import DOMAINENTITIES.CreadorInmuebles;
import DOMAINENTITIES.Inmueble;
import DOMAINENTITIES.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pipe
 */
public class FiltradoBusqueda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        CreadorInmuebles creador;
        ArrayList<Inmueble> arrayPublicaciones;
        Usuario usr = new Usuario();
        IPublicacionDAO iPublicacionDAO=new PublicacionDAO();
        IUsuarioDAO iUsuarioDAO=new UsuariosDAOMysql();
        usr.setiPublicacionDAO(iPublicacionDAO);
        usr.setiUsuarioDAO(iUsuarioDAO);
        //dependiendo de el tipon de inmueble que ingrese en el formulario
        if(request.getParameter("tipoinmueble") != null){
            switch (request.getParameter("tipoinmueble")) {
                case "Casa":
                    creador=new CreadorCasas();
                    break;
                case "Apartamento":
                    creador=new CreadorApartamento();
                    break;
                case "Habitacion":
                    creador=new CreadorCasas();
                    break;
                case "Local":
                    creador=new CreadorBodegas();
                    break;
                case "Finca":
                    creador=new CreadorFincas();
                    break;
                default:
                    throw new AssertionError();
            }
        }else
            creador=new CreadorCasas();
        Inmueble inmueble=creador.factoryMethod();
        inmueble.setTipoOferta(request.getParameter("tipooferta"));
        inmueble.setTipoInmueble(request.getParameter("tipoinmueble"));
        inmueble.setCiudad(request.getParameter("ciudad"));
        inmueble.setDireccion(request.getParameter("direccion"));
        inmueble.setBarrio(request.getParameter("barrio"));
        inmueble.setPrecio(request.getParameter("precio"));
        inmueble.setHabitaciones(request.getParameter("habitaciones"));
        inmueble.setBanos(request.getParameter("banos"));
        inmueble.setPiso(request.getParameter("piso"));
        inmueble.setArea(request.getParameter("area"));
        inmueble.setEstrato(request.getParameter("estrato"));
        try {
            arrayPublicaciones = usr.filtrarPublicaciones(inmueble);
            sesion.setAttribute("publicaciones", arrayPublicaciones);
            request.getRequestDispatcher("/cuenta.jsp").forward(request, response);
        }catch(Exception e){
            sesion.setAttribute("msg",e.getMessage()); 
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
