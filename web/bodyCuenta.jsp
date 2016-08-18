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
                            <div class="col s12 m9 l9">
                                <a href="crearpublicacion.jsp"><button  type="button" name="publicarboton" class="btn-large waves-effect waves-light orange">Publicar un inmueble</button></a>
                            </div>                         
                            <div class="col hide-on-small-only m3 l3">
                                <div class="card blue-grey darken-1">
                                    <div class="card-content white-text">
                                        <i class="material-icons prefix">account_circle</i><span class="card-title">   Búsqueda</span>
                                        <form action="BusquedaByUsuario">
                                            <div>
                                                <input name="usuario" type="email" class="validate" required="">
                                            </div>   
                                            <button  type="submit" name="registro_boton" class="btn-large waves-effect waves-light orange">Consultar</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                        <%                    for (Publicacion pub : publicaciones) {
                                out.println("<a href='#'>");
                                out.println("<div id='publicaciones' class='col s3'>");
                                out.println("<span>" + pub.getTipoInmueble() + "</span></br>");
                                out.println("<img src='imagenes/logoCasa.png' width=140 height=110/></br>");
                                out.println("<span>" + pub.getTipoOferta() + "</span></br>");
                                out.println("<span>$" + pub.getPrecio() + "</span></br>");
                                out.println("</div>");
                                out.println("</a>");
                            }
                        %>
                        </div>

                        <!--   Icon Section   -->

                    </div>
                </div>
    </body>
</html>
