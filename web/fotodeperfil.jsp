<!DOCTYPE html>

<%@page import="DTO.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usr = (Usuario) request.getSession().getAttribute("usuario");
%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Actualizar Foto</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <script src="js/accionesvarias.js"></script>
        <link rel="shortcut icon" href="imagenes/logoCasa.png">
    </head>
    <body>
        <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="fotodeperfil.jsp">Inicio</a></li>
                    <li><a href="index2.html">Registrese!</a></li>
                    <li><a href="#">Ingrese!</a></li>
                </ul>
                <ul id="nav-mobile" class="side-nav">
                    <li><a href="fotodeperfil.jsp">Inicio</a></li>
                    <li><a href="index2.html">Registrese!</a></li>
                    <li><a href="#">Ingrese!</a></li>
                </ul>
                <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>
        </nav>
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <h4 class="center">Actualiza tu foto</h4>

                <div class="row center col s12">
                    <div class="card-panel fondoActualizarFoto">
                        <i class="medium material-icons">settings</i>
                        <div class="row">
                            <div class="push-l10">
                                <img class="hoverable" id="imagenprev" src="<%=usr.getFotourl()%>" width=250 height=300 />
                            </div>
                            <form method="POST" action="CambioFotoPerfil" enctype="multipart/form-data" onsubmit="return cancelarsubmit()">
                                <div class="file-field input-field">
                                    <div class="btn-large waves-effect waves-light orange">
                                        <span>Elegir foto</span>
                                        <input id="imagenperfil"  type="file" name="inputFile" value="" accept="image/*" onchange="previewFile()"/><br>

                                    </div>
                                    <div class="file-path-wrapper col s3">
                                        <input class="file-path validate" type="text" >
                                    </div>
                                </div>
                                <div class="row center col s12">
                                    <button type="submit" name="cambiarfotoboton" class="btn-large waves-effect waves-light orange">Guardar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                </div>
            </div>
        </div>

        <%@include file="footer.html" %>
        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
</body>
</html>
