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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MARCS
 */
@WebServlet(name = "MuestraPublicacionPropia", urlPatterns = {"/MuestraPublicacionPropia"})
public class MuestraPublicacionPropia extends HttpServlet {

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
        Usuario usuarioSesion = (Usuario) request.getSession().getAttribute("usuario");
        String correo = usuarioSesion.getCorreo();
        Usuario usr = new Usuario();
        IPublicacionDAO iPublicacionDAO=new PublicacionDAO();
        IUsuarioDAO iUsuarioDAO=new UsuariosDAOMysql();
        usr.setiPublicacionDAO(iPublicacionDAO);
        usr.setiUsuarioDAO(iUsuarioDAO);
        try {
            ArrayList<Inmueble> publicaciones = usr.consultarPublicacionesByUsuario(correo);
            request.getSession().setAttribute("publicaciones_editables", publicaciones);
            request.getRequestDispatcher("PublicacionesEditables.jsp").forward(request, response);
        } catch (Exception ex) {
            request.getSession().setAttribute("msg", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
        Usuario usuarioSesion = (Usuario) request.getSession().getAttribute("usuario");
        System.out.println("usuario: "+usuarioSesion.getCorreo());
        String correo = usuarioSesion.getCorreo();
        Usuario usr = new Usuario();

        try {
            ArrayList<Inmueble> publicaciones = usr.consultarPublicacionesByUsuario(correo);
            request.getSession().setAttribute("publicaciones_editables", publicaciones);
            request.getRequestDispatcher("PublicacionesEditables.jsp").forward(request, response);
        } catch (Exception ex) {
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
