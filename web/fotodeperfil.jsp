<%-- 
    Document   : fotodeperfil
    Created on : 4/08/2016, 08:24:23 AM
    Author     : felipe
--%>

<%@page import="DTO.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getSession().getAttribute("usuario") == null){
        System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOO");
    }
        
    Usuario usr = (Usuario) request.getSession().getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foto de perfil </title>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <script src="js/accionesvarias.js"></script>
    </head>
    <body>
        <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="#">Inicio</a></li>
                </ul>
                <ul id="nav-mobile" class="side-nav">
                    <li><a href="#">Inicio</a></li>
                </ul>
                <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>

        <div class="container">
            <h4>Foto de Perfil </h4>
            <div class="row">
                <div class="push-l10">
                    <img class="hoverable" id="imagenprev" src="<%=usr.getFotourl()%>" width=250 height=300 />
                </div>
                <form method="POST" action="cambiarfotodeperfil" enctype="multipart/form-data" onsubmit="return cancelarsubmit()">
                    <div class="file-field input-field">
                        <div class="btn-large waves-effect waves-light orange">
                            <span>Elegir foto <%=usr.getFotourl()%></span>
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
    <div class="container">
        <div class="section">

            <!--   Icon Section   -->
            <div class="row">

            </div>
        </div>
        <div class="section">
        </div>
    </div>
    <%@include file="footer.html" %>

    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.js"></script>
    <script src="js/init.js"></script>

</body>
</html>
