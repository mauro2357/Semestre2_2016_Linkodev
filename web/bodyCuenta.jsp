<%-- 
    Document   : bodyCuenta
    Created on : 18/08/2016, 04:51:45 PM
    Author     : Mateo Ortiz Cano
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="DOMAINENTITIES.Publicacion"%>
<%
    HttpSession sesion2 = request.getSession();
    ArrayList<Publicacion> publicaciones = (ArrayList) sesion2.getAttribute("publicaciones");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenidoCuenta" class="container1">
            <div class="section">
                <div class="row">
                    <%                    for (Publicacion pub : publicaciones) {
                            out.println("<div id='publicaciones' class='col s2'>");
                            out.println("<div class='card'>");
                            out.println("<div class='card-image'>");
                            out.println("<img src='imagenes/logoCasa.png'>");                           
                            out.println("</div>");
                            out.println("<div class='card-content'>");
                            out.println("<span class='card-title white-text'>" + pub.getTipoInmueble() + " - " + pub.getTipoOferta() + "</span><br>");
                            out.println("<span class='white-text'> Precio:$ " + pub.getPrecio() + "</span><br>");
                            out.println("<span class='white-text'> Ciudad: " + pub.getCiudad() + "</span>");
                            out.println("</div>");
                            out.println("<div class='card-action'>");                            
                            out.println("<a href='VerDetalles?id="+pub.getId()+"'><i class='material-icons'>more_vert</i></a>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                        }
                    %>
                </div>

                <!--   Icon Section   -->

            </div>
        </div>
    </body>
</html>
