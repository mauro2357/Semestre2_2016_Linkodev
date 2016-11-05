<%-- 
    Document   : ModificacionPublicacion
    Created on : 19-ago-2016, 11:27:04
    Author     : MARCS
--%>

<%@page import="DOMAINENTITIES.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesionII = request.getSession();
    Inmueble pub = (Inmueble) sesionII.getAttribute("publicacion");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Publicación</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/newcss.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <script src="js/accionesvarias.js"></script>
        <link rel="shortcut icon" href="/imagenes/logoCasa.png">
    </head>
    <body onload="mandarAlerta()">
        <div id="wrap">
            <div id="main">
                <%@include file="barradeNavegacion.jsp"%>
                <div class="section no-pad-bot" id="index-banner">
                    <div class="container">
                        <br><br>
                        <h4>Edición de publicación</h4>
                        <div class="row">
                            <form class="col s12" action="Modificacionpublicacion" method="">
                                <input  name="id" type="text" class="validate" value="<%=pub.getId()%>" hidden="true">
                                <div class="input-field col s6">
                                    Tipo de oferta:
                                    <select name="tipooferta" required aria-required="true">
                                        <option value="<%=pub.getTipoOferta()%>"><%=pub.getTipoOferta()%></option>
                                        <option value="venta">Venta</option>
                                        <option value="arriendo">Arriendo</option>
                                    </select>
                                </div>
                                <div class="input-field col s6">
                                    Tipo de inmueble:
                                    <select name="tipoinmueble">
                                        <option value="<%=pub.getTipoInmueble()%>"><%=pub.getTipoInmueble()%></option>
                                        <option value="casa">Casa</option>
                                        <option value="apartamento">Apartamento</option>
                                        <option value="habitacion">Habitación</option>
                                        <option value="local">Local</option>
                                        <option value="finca">Finca</option>
                                    </select>
                                </div>
                                <div class="input-field col s6">
                                    Ciudad:
                                    <select name="ciudad">
                                        <option value="<%=pub.getCiudad()%>"><%=pub.getCiudad()%></option>
                                        <option value="Bogota">Bogotá</option>
                                        <option value="Medellin">Medellín</option>
                                    </select>
                                </div>
                                <div class="input-field col s6">
                                    Dirección:
                                    <input  name="direccion" type="text" class="validate" value="<%=pub.getDireccion()%>">
                                </div>
                                <div class="col s6">
                                    Barrio:
                                    <input  name="barrio" type="text" class="validate" value="<%=pub.getBarrio()%>">
                                </div>
                                
                                <div id="map" align="center" style="width: 500px; height: 500px"></div>
                                <script>
                                function myMap() {
                                  var mapCanvas = document.getElementById("map");
                                  var myCenter=new google.maps.LatLng(4.724252074523265,-74.0643310546875);
                                  var mapOptions = {center: myCenter, zoom: 5};
                                  var map = new google.maps.Map(mapCanvas, mapOptions);
                                  google.maps.event.addListener(map, 'click', function(event) {
                                    placeMarker(map, event.latLng);
                                  });
                                }

                                function placeMarker(map, location) {
                                  var marker = new google.maps.Marker({
                                    position: location,
                                    map: map
                                  });
                                  var infowindow = new google.maps.InfoWindow({
                                    content: 'Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng()
                                  });
                                  infowindow.open(map,marker);
                                  document.getElementById('latitud').value = location.lat();
                                  document.getElementById('longitud').value = location.lng();
                                }
                                </script>

                                <script src="https://maps.googleapis.com/maps/api/js?callback=myMap&key=AIzaSyClkrRnbW8WB2Rl7_L_RuXDcJmbhSKPjfM"></script>
                                <br><br>
                                <div>
                                    <input name="latitud" id="latitud" type="text" value="" hidden="true">
                                </div>
                                <div>
                                    <input name="longitud" id="longitud" type="text" value="" hidden="true">
                                </div>
                                
                                
                                <div class="col s6">
                                    Precio:
                                    <input  name="precio" type="text" class="validate" value="<%=pub.getPrecio()%>">
                                </div>
                                <div class="col s6">
                                    Habitaciones:
                                    <input  name="habitaciones" type="number" min="0" max="20" step="1" class="validate" value="<%=pub.getHabitaciones()%>">
                                </div>
                                <div class="col s6">
                                    Baños:
                                    <input  name="banos" type="number" min="0" max="20" step="1" class="validate" value="<%=pub.getBanos()%>">
                                </div>
                                <div class="col s6">
                                    Piso:
                                    <input  name="piso" type="text" class="validate" onkeypress="return valida(event)" value="<%=pub.getPiso()%>">
                                </div>
                                <div class="col s6">
                                    Área:
                                    <input  name="area" type="text" class="validate" onkeypress="return valida(event)" value="<%=pub.getArea()%>">
                                </div>
                                <div class="col s6">
                                    Estrato:
                                    <input  name="estrato" type="text" class="validate" onkeypress="return valida(event)" value="<%=pub.getEstrato()%>">
                                </div>
                                <div class="col s6">
                                    Visitas publicación:
                                    <input   id="contador" name="contador" type="text" class="validate" value="<%=pub.getContadorVisitas()%>" readonly="">
                                </div>
                                <br>
                                <div class="row center col s12">
                                    <button  type="submit" name="publicarboton" class="btn-large waves-effect waves-light orange">Actualizar</button>
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
