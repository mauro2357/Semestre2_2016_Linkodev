<%-- 
    Document   : crearpublicacion
    Created on : 9/08/2016, 10:24:01 AM
    Author     : linkcodev
--%>

<%@page import="DOMAINENTITIES.Publicacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesionI = request.getSession();
    Publicacion pub = (Publicacion) sesionI.getAttribute("publicacion");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles Publicación</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/newcss.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <script src="js/accionesvarias.js"></script>
        <link rel="shortcut icon" href="imagenes/logoCasa.png">
    </head>
    <body>
        <div id="wrap">
            <div id="main">
                <%@include file="barradeNavegacion.jsp"%>
                <div class="section no-pad-bot" id="index-banner">
                    <div class="container">
                        <br><br>
                        <h4>Detalles publicación</h4>
                        <br><br>
                        <div class="row">
                            <form id="formularioDetalles" class="col s12" action="" method="post">
                                <div class="input-field col s6">
                                    Tipo de oferta:
                                    <input  name="oferta" type="text" class="validate" value="<%=pub.getTipoOferta()%>" readonly="">
                                </div>
                                <div class="input-field col s6">
                                    Tipo de inmueble:
                                    <input  name="tipo" type="text" class="validate" value="<%=pub.getTipoInmueble()%>" readonly="">
                                </div>
                                <div class="input-field col s6" >
                                    Ciudad:
                                    <input  name="ciudad" type="text" class="validate" value="<%=pub.getCiudad()%>" readonly="">
                                </div>
                                <div class="input-field col s6">
                                    Dirección:
                                    <input  name="direccion" type="text" class="validate" value="<%=pub.getDireccion()%>" readonly="">
                                </div>
                                <div class="col s6">
                                    Barrio:
                                    <input  name="barrio" type="text" class="validate" value="<%=pub.getBarrio()%>" readonly="">
                                </div>
                                <div class="col s6">
                                    Precio:
                                    <input  name="precio" type="text" class="validate" value="<%=pub.getPrecio()%>" readonly="">
                                </div>
                                <div class="col s6">
                                    Habitaciones:
                                    <input  name="habitaciones" type="text" class="validate" value="<%=pub.getHabitaciones()%>" readonly="">
                                </div>
                                <div class="col s6">
                                    Baños:
                                    <input  name="banos" type="text" class="validate" value="<%=pub.getBanos()%>" readonly="">
                                </div>
                                <div class="col s6">
                                    Piso:
                                    <input  name="piso" type="text" class="validate" value="<%=pub.getPiso()%>" readonly="">
                                </div>
                                <div class="col s6">
                                    Área:
                                    <input  name="area" type="text" class="validate" value="<%=pub.getArea()%>" readonly="">
                                </div>
                                <div class="col s6">
                                    Estrato:
                                    <input  name="estrato" type="text" class="validate" value="<%=pub.getEstrato()%>" readonly="">
                                </div>
                                <div class="col s6">
                                    Visitas publicación:
                                    <input   id="contador" name="contador" type="text" class="validate" value="<%=pub.getContadorVisitas()%>" readonly="">
                                </div>
                                
                                <br>
                                <div class="row center col s12">
                                   
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.html" %>
    </body>
</html>
