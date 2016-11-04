<%-- 
    Document   : crearpublicacion
    Created on : 9/08/2016, 10:24:01 AM
    Author     : linkcodev
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DOMAINENTITIES.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesionI = request.getSession();
    Inmueble pub = (Inmueble) sesionI.getAttribute("publicacion");
    ArrayList<String> fotos = (ArrayList) sesionI.getAttribute("fotos");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles Publicación</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/newcss.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="shortcut icon" href="imagenes/logoCasa.png">
        <script src="js/Mapa.js"></script>
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
                        <%String foto1 = (String) ((fotos.get(0) == null) ? "imagenes/no-imagen.jpg" : fotos.get(0));
                            String foto2 = (String) ((fotos.get(1) == null) ? "imagenes/no-imagen.jpg" : fotos.get(1));
                            String foto3 = (String) ((fotos.get(2) == null) ? "imagenes/no-imagen.jpg" : fotos.get(2));
                            String foto4 = (String) ((fotos.get(3) == null) ? "imagenes/no-imagen.jpg" : fotos.get(3));
                            String foto5 = (String) ((fotos.get(4) == null) ? "imagenes/no-imagen.jpg" : fotos.get(4));
                        %>
                        <div class="carousel">
                            <a class="carousel-item" href="#one!"><img src="<%=foto1%>"></a>
                            <a class="carousel-item" href="#two!"><img src="<%=foto2%>"></a>
                            <a class="carousel-item" href="#three!"><img src="<%=foto3%>"></a>
                            <a class="carousel-item" href="#four!"><img src="<%=foto4%>"></a>
                            <a class="carousel-item" href="#five!"><img src="<%=foto5%>"></a>
                        </div>
                        <div class="row">
                            <form id="formularioDetalles" class="col s12" action="Compra_Arrendamiento" method="post">
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
                                    <input  name="direccion" id="address" type="text" class="validate" value="<%=pub.getDireccion()%>" readonly="">
                                </div>
                                <div class="col s6">
                                    Barrio:
                                    <input  name="barrio" type="text" class="validate" value="<%=pub.getBarrio()%>" readonly="">
                                </div>
                                <div>
                                    <input name="latitud" id="latitud" type="text" value="<%=pub.getLatitud()%>" hidden="true">
                                </div>
                                <div>
                                    <input name="longitud" id="longitud" type="text" value="<%=pub.getLongitud()%>" hidden="true">
                                </div> 
                                <div>
                                    <input name="destino" id="destino" type="text" value="Bogotá, Colombia">
                                    <input id="submit" type="button" value="Buscar">
                                </div>
                                <div id="map" style="width:100%;height:500px"></div>                               
                                <script src="https://maps.googleapis.com/maps/api/js?callback=initMap&key=AIzaSyClkrRnbW8WB2Rl7_L_RuXDcJmbhSKPjfM"></script>                               
                                <br>

                                <br><br>
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
                                <input name="dueno" value="<%=pub.getDueno()%>" hidden="">
                                <input name="cliente" value="<%=usr.getCorreo()%>" hidden="">
                                <input name="publicacion" value="<%=pub.getId()%>" hidden="">
                                <div class="row center col s12">
                                    <button  type="submit" name="compraArrendaButton" class="btn-large waves-effect waves-light orange">¡Lo tomo!</button>
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
