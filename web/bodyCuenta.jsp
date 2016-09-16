<%-- 
    Document   : bodyCuenta
    Created on : 18/08/2016, 04:51:45 PM
    Author     : Mateo Ortiz Cano
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="DOMAINENTITIES.Inmueble"%>
<%
    HttpSession sesion2 = request.getSession();
    ArrayList<Inmueble> publicaciones = (ArrayList) sesion2.getAttribute("publicaciones");
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
                    <%                    for (Inmueble pub : publicaciones) {
                            out.println("<div id='publicaciones' class='col s2'>");
                            out.println("<div class='card'>");
                            out.println("<div class='card-image'>");
                            out.println("<img src='imagenes/logoCasa.png'>");                           
                            out.println("</div>");
                            out.println("<div class='card-content'>");
                            out.println("<span class='card-title white-text'>" + pub.getTipoInmueble() + "</span><br>");
                            out.println("<span class='card-title white-text'>" + pub.getTipoOferta() + "</span><br>");
                            out.println("<span class='white-text'> Precio:$ " + pub.getPrecio() + "</span><br>");
                            out.println("<span class='white-text'> Ciudad: " + pub.getCiudad() + "</span>");
                            out.println("</div>");
                            out.println("<div class='card-action'>");                            
                            out.println("<a href='VisualizacionDetalles?id="+pub.getId()+"'><i class='material-icons'>more_vert</i></a>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
