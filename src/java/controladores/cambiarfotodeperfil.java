/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DTO.Usuario;
import Modelos.UsuariosDAO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author felipe
 */
public class cambiarfotodeperfil extends HttpServlet {

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
        try {
            /*FileItemFactory es una interfaz para crear FileItem*/
            FileItemFactory file_factory = new DiskFileItemFactory();
            /*ServletFileUpload esta clase convierte los input file a FileItem*/
            ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
            /*sacando los FileItem del ServletFileUpload en una lista */
            List items = servlet_up.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
                /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
                FileItem item = (FileItem) items.get(i);
                /*item.isFormField() false=input file; true=text field*/
                if (!item.isFormField()) {
                    //checking content type of file. 
                    if (item.getContentType().equals("image/jpeg") || item.getContentType().equals("image/png")
                            || item.getContentType().equals("image/jpg") || item.getContentType().equals("image/gif")
                            || item.getContentType().equals("image/bmp")) {
                        /*cual sera la ruta al archivo en el servidor*/
                        File directorio = new File(getServletContext().getRealPath("imagenes/"));
                        directorio.mkdir();
                        File archivo_server = new File(directorio + File.separator + item.getName());
                        /*y lo escribimos en el servido*/
                        item.write(archivo_server);
                        UsuariosDAO usuario = new UsuariosDAO();
                        Usuario usr;
                        usr = (Usuario) request.getSession().getAttribute("usuario");
                        usuario.cambiarFotoDePerfil("imagenes/"+item.getName(),usr.getCorreo());
                        /* guardar los datos en la tabla */
 /* fin guardar */
                    }
                }
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("modificarInformacion.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
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
