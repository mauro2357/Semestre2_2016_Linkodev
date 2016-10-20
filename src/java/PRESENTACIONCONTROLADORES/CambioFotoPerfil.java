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
import DOMAINENTITIES.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mateo Ortiz Cano
 */
public class CambioFotoPerfil extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        try {
            FileItemFactory file_factory = new DiskFileItemFactory();
            ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
            List items = servlet_up.parseRequest(request);
            Usuario usr = new Usuario();
            IPublicacionDAO iPublicacionDAO = new PublicacionDAO();
            IUsuarioDAO iUsuarioDAO = new UsuariosDAOMysql();
            usr.setiPublicacionDAO(iPublicacionDAO);
            usr.setiUsuarioDAO(iUsuarioDAO);
            UsuariosDAOMysql usuario = new UsuariosDAOMysql();
            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                if (!item.isFormField()) {
                    if (item.getContentType().equals("image/jpeg") || item.getContentType().equals("image/png")
                            || item.getContentType().equals("image/jpg") || item.getContentType().equals("image/gif")
                            || item.getContentType().equals("image/bmp")) {
                        String direccion = getServletContext().getRealPath("");
                        System.out.println(direccion);
                        direccion = direccion.replace("build/web", "web/imagenes");
                        System.out.println(direccion);
                        File directorio = new File(direccion);
                        directorio.mkdir();
                        File archivo_server = new File(directorio + File.separator + item.getName());
                        item.write(archivo_server);
                        System.out.println("aaaa  "+direccion+ File.separator + item.getName());
                        usr = (Usuario) sesion.getAttribute("usuario");
                        usuario.cambiarFotoDePerfil("imagenes/"+item.getName(),usr.getCorreo());
                        usr.setFotourl("imagenes/"+item.getName());
                        sesion.setAttribute("usuario",usr);
                    }
                }
            }
            request.getRequestDispatcher("MuestraPublicacion").forward(request, response);
        } catch (Exception e) {
            request.getSession().setAttribute("msg", e.getMessage());
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
