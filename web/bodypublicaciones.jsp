<%-- 
    Document   : bodyPublicaciones
    Created on : 19-ago-2016, 15:11:30
    Author     : MARCS
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DOMAINENTITIES.Inmueble"%>
<%
    HttpSession sesion3 = request.getSession();
    ArrayList<Inmueble> publicacioneseditables = (ArrayList) sesion3.getAttribute("publicaciones_editables");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Last-Modified" content="0">
        <meta http-equiv="Cache-Control: no-store, no-cache, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicaciones editables</title>
        <script src="js/accionesvarias.js"></script>
    </head>
    <body>
        <div id="contenidoCuenta" class="container1">
            <div class="section">
                <div class="row">
                    <%                    for (Inmueble pub : publicacioneseditables) {
                            out.println("<div id='publicaciones' class='col s2'>");
                            out.println("<div class='card'>");
                            out.println("<div class='card-image'>");
                            out.println("<a onclick='confirmarEliminacion()' class='waves-effect right hoverable red' href='EliminacionPublicacion?id="+pub.getId()+"'><i class='material-icons'>close</i></a>");
                            out.println("<img src='./"+pub.getFotourl()+"' height='150' width='200'>");
                            out.println("</div>");
                            out.println("<div class='card-content'>");
                            out.println("<span class='card-title white-text'>" + pub.getTipoInmueble() + " - " + pub.getTipoOferta() + "</span><br>");
                            out.println("<span class='white-text'> Precio:$ " + pub.getPrecio() + "</span><br>");
                            out.println("<span class='white-text'> Ciudad: " + pub.getCiudad() + "</span>");
                            out.println("</div>");
                            out.println("<div class='card-action'>");
                            out.println("<a href='DetallesPublicacionesEditables?id="+pub.getId()+"'><i class='material-icons'>more_vert</i></a>");
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