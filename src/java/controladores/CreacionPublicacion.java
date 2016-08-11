/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DTO.Publicacion;
import DTO.Usuario;
import Modelos.PublicacionDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author felipe
 */
public class CreacionPublicacion extends HttpServlet {

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

        Usuario usr = (Usuario) sesion.getAttribute("usuario");
        Publicacion publicacion = new Publicacion();
        PublicacionDAO nuevapublicacion = new PublicacionDAO();
        publicacion.setDueno(usr.getCorreo());
        publicacion.setTipoOferta(request.getParameter("tipooferta"));
        publicacion.setTipoInmueble(request.getParameter("tipoinmueble"));
        publicacion.setCiudad(request.getParameter("ciudad"));
        publicacion.setDireccion(request.getParameter("direccion"));
        publicacion.setBarrio(request.getParameter("barrio"));
        publicacion.setPrecio(request.getParameter("precio"));
        publicacion.setHabitaciones(request.getParameter("habitaciones"));
        publicacion.setBanos(request.getParameter("banos"));
        publicacion.setPiso(request.getParameter("piso"));
        publicacion.setArea(request.getParameter("area"));
        publicacion.setEstrato(request.getParameter("estrato"));
        try{
            nuevapublicacion.registrarPublicacion(publicacion);
            request.getRequestDispatcher("cuenta.jsp").forward(request, response);
        }catch(SQLException e){
            String msgError=e.getMessage();
            sesion.setAttribute("msg",msgError ); 
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
