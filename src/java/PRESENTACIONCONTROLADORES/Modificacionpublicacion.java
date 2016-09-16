/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACIONCONTROLADORES;

import DOMAINENTITIES.CreadorHabitacion;
import DOMAINENTITIES.CreadorInmuebles;
import DOMAINENTITIES.Inmueble;
import DOMAINENTITIES.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mateo Ortiz Cano
 */
public class Modificacionpublicacion extends HttpServlet {

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
        Usuario usr = (Usuario) sesion.getAttribute("usuario");
        CreadorInmuebles creador;
        //dependiendo de el tipon de inmueble que ingrese en el formulario
        creador=new CreadorHabitacion();
        Inmueble inmueble=creador.factoryMethod();    
        inmueble.setDueno(usr.getCorreo());
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
        inmueble.setContadorVisitas(Integer.parseInt(request.getParameter("contador")));
        inmueble.setId(request.getParameter("id"));
        Usuario usuario=new Usuario();
        try{
            usuario.ModificarPublicacion(inmueble);
            sesion.setAttribute("usuario", usr);
            request.getRequestDispatcher("MuestraPublicacionPropia").forward(request, response);
        }catch(SQLException e){
            sesion.setAttribute("msg",e.getMessage()); 
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
