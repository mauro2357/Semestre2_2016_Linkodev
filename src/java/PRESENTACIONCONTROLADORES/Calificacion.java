/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACIONCONTROLADORES;

import ConexionBaseDatos.ICalificacionDAO;
import ConexionBaseDatos.PublicacionDAO;
import ConexionBaseDatos.UsuariosDAOMysql;
import DOMAINENTITIES.Inmueble;
import DOMAINENTITIES.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateohenaocardona
 */
public class Calificacion extends HttpServlet {

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
        int calificacionInmueble = Integer.parseInt(request.getParameter("estrellasInmueble"));
        int calificacionUsuario = Integer.parseInt(request.getParameter("estrellasVendedor"));
        String dueno = request.getParameter("dueno");
        String publicacion = request.getParameter("publicacion");
        ICalificacionDAO iCalificacionDAOPublicacion = new PublicacionDAO();
        ICalificacionDAO iCalificacionDAOUsuario = new UsuariosDAOMysql();
        
        try {
            iCalificacionDAOPublicacion.calificar(calificacionInmueble, publicacion);
            iCalificacionDAOUsuario.calificar(calificacionUsuario,dueno);
            request.getRequestDispatcher("MuestraPublicacion").forward(request, response);
        } catch (SQLException ex) {
            request.getSession().setAttribute("msg", ex.getMessage());
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
