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
import DOMAINENTITIES.Inmueble;
import DOMAINENTITIES.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author felipe
 */
@WebServlet(name = "MuestraPublicacion", urlPatterns = {"/MuestraPublicacion"})
public class MuestraPublicacion extends HttpServlet {

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
        Usuario usr = new Usuario();
        IPublicacionDAO iPublicacionDAO=new PublicacionDAO();
        IUsuarioDAO iUsuarioDAO=new UsuariosDAOMysql();
        usr.setiPublicacionDAO(iPublicacionDAO);
        usr.setiUsuarioDAO(iUsuarioDAO);
        ArrayList<Inmueble> arrayPublicaciones;
        try {            
            arrayPublicaciones = usr.mostrarPublicaciones();
            HttpSession sesion = request.getSession();
            sesion.setAttribute("publicaciones", arrayPublicaciones);
            request.getRequestDispatcher("cuenta.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(MuestraPublicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        PublicacionDAO publicacion = new PublicacionDAO();
        ArrayList<Inmueble> arrayPublicaciones;
        try {            
            arrayPublicaciones = publicacion.mostrarPublicaciones();
            HttpSession sesion = request.getSession();
            sesion.setAttribute("publicaciones", arrayPublicaciones);
            request.getRequestDispatcher("cuenta.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MuestraPublicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
