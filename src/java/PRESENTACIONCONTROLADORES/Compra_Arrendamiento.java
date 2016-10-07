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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mateo Ortiz Cano
 */
public class Compra_Arrendamiento extends HttpServlet {

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
        String dueno = request.getParameter("dueno");
        String cliente = request.getParameter("cliente");
        String publicacion = request.getParameter("publicacion");
        if (dueno.equals(cliente)) {
            request.getSession().setAttribute("msg", "No puedes negociar con tus propias publicaciones, si quieres que no aparezca mas eliminala!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        Inmueble inmueble = new Inmueble();
        inmueble.setId(publicacion);
        inmueble.setDueno(dueno);
        Usuario usuario = new Usuario();
        IPublicacionDAO iPublicacionDAO=new PublicacionDAO();
        IUsuarioDAO iUsuarioDAO=new UsuariosDAOMysql();
        usuario.setiPublicacionDAO(iPublicacionDAO);
        usuario.setiUsuarioDAO(iUsuarioDAO);
        usuario.setCorreo(cliente);
        try {
            usuario.adquirir(inmueble);            
            request.getRequestDispatcher("MuestraPublicacion").forward(request, response);
        } catch (SQLException ex) {
            request.getSession().setAttribute("msg", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
