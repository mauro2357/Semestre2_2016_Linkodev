<%-- 
    Document   : Calificacion
    Created on : 29-sep-2016, 18:48:35
    Author     : mateohenaocardona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="DOMAINENTITIES.Inmueble"%>
<%
    HttpSession sesionI = request.getSession();
    Inmueble pub = (Inmueble) sesionI.getAttribute("publicacion");
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
                        <h4>Calificaciones</h4>
                        <br><br>
                        <div class="row">
                            <form id="formularioDetalles" class="col s12 formCalificacion" action="Calificacion" method="post">
                                <h4>
                                    Felicitaciones has podido negociar!!
                                </h4>
                                
                                <p class="row center col s12">
                                    Calificar al usurio:
                                    <br>
                                    <%out.println(pub.getDueno()); %>
                                </p>
                                <p class="clasificacion">
                                    <input id="radio1" type="radio" name="estrellasVendedor" value="5">
                                        <label for="radio1">&#9733;</label>
                                    <input id="radio2" type="radio" name="estrellasVendedor" value="4">
                                        <label for="radio2">&#9733;</label>
                                    <input id="radio3" type="radio" name="estrellasVendedor" value="3">
                                        <label for="radio3">&#9733;</label>
                                    <input id="radio4" type="radio" name="estrellasVendedor" value="2">
                                        <label for="radio4">&#9733;</label>
                                    <input id="radio5" type="radio" name="estrellasVendedor" value="1">
                                        <label for="radio5">&#9733;</label>
                                </p>
               
                                <p class="row center col s12">
                                    Calificar Publicación
                                </p>
                                <p class="clasificacion">
                                    <input id="radio6" type="radio" name="estrellasInmueble" value="5">
                                        <label for="radio6">&#9733;</label>
                                    <input id="radio7" type="radio" name="estrellasInmueble" value="4">
                                        <label for="radio7">&#9733;</label>
                                    <input id="radio8" type="radio" name="estrellasInmueble" value="3">
                                        <label for="radio8">&#9733;</label>
                                    <input id="radio9" type="radio" name="estrellasInmueble" value="2">
                                        <label for="radio9">&#9733;</label>
                                    <input id="radio10" type="radio" name="estrellasInmueble" value="1">
                                        <label for="radio10">&#9733;</label>
                                </p>
                                <input name="cliente" value="<%=usr.getCorreo()%>" hidden="">
                                <input name="dueno" value="<%=pub.getDueno()%>" hidden="">
                                <input name="publicacion" value="<%=pub.getId()%>" hidden="">
                                <br>
                                <div class="row center col s12">
                                    <button  type="submit" name="calificarButton" class="btn-large waves-effect waves-light orange">Calificar</button>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
