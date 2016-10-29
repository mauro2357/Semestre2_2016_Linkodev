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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mateo Ortiz Cano
 */
public class VisualizacionDetalles extends HttpServlet {

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
        String id = request.getParameter("id");
        Usuario usr = new Usuario();
        IPublicacionDAO iPublicacionDAO = new PublicacionDAO();
        IUsuarioDAO iUsuarioDAO = new UsuariosDAOMysql();
        usr.setiPublicacionDAO(iPublicacionDAO);
        usr.setiUsuarioDAO(iUsuarioDAO);
        try {
            Inmueble pub = usr.DetallarInmueble(id);
            String directorio = getServletContext().getRealPath("");
            directorio = directorio.replace("build"+ File.separator +"web", "web"+ File.separator +"imagenes"+ File.separator +pub.getDueno()+File.separator+"publicacion"+pub.getId());
            File f = new File(directorio);
            ArrayList<String> fotos = new ArrayList<>(5);
            if (f.exists()){ 
                File[] ficheros = f.listFiles();
                for (File fichero : ficheros) {
                    String fotourl = "imagenes"+File.separator+pub.getDueno()+File.separator+"publicacion"+pub.getId()+File.separator+fichero.getName();
                    fotos.add(fotourl);
                }
                fotos.add(null);
                fotos.add(null);
                fotos.add(null);
                fotos.add(null);
                fotos.add(null);
                
            }
            request.getSession().setAttribute("publicacion", pub);
            request.getSession().setAttribute("fotos", fotos);
            request.getRequestDispatcher("Detalles.jsp").forward(request, response);
        } catch (SQLException ex) {
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
