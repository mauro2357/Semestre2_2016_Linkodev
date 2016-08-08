/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DTO.Usuario;
import Modelos.UsuariosDAO;
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
public class ModificarInformacion extends HttpServlet {

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
        processRequest(request, response);
        String nombre=request.getParameter("nombre");
        String correo=request.getParameter("correo");
        String contraseñaNueva=request.getParameter("confirmarContrasena");
        String contraseñaVieja=request.getParameter("contrasena");
        String telefono=request.getParameter("telefono");
        Usuario persona=new Usuario(nombre, correo, contraseñaNueva, telefono);
        UsuariosDAO NuevoUsuario=new UsuariosDAO();
        try{
            Usuario usuarioModificado = NuevoUsuario.modificarInformacionUsuario(persona,contraseñaVieja);
            request.getSession().setAttribute("usuario",usuarioModificado);
            request.getRequestDispatcher("cuenta.jsp").forward(request, response);
        }catch(SQLException e){
            String msgError=e.getMessage();
            request.getSession().setAttribute("msg",msgError ); 
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
