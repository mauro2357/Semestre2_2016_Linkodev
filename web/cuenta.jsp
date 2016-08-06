<%@page import="DTO.Usuario" %>
<%
    Usuario usr = (Usuario) request.getSession().getAttribute("usuario");

%><!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>IOInmuebles</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
                <ul id="slide-out" class="right side-nav">
                    <li><div class="userView">
                            <a href="#!user"><img class="circle" src="<%=usr.getFotourl()%>"></a>
                            <a href="#!name"><span class="white-text name"><%=usr.getNombre()%></span></a>
                            <a href="#!email"><span class="white-text email"><%=usr.getCorreo()%></span></a>
                            <a href="#!email"><span class="white-text email"><%=usr.getTelefono()%></span></a>
                        </div></li>
                    <li>
                        <a href="modificarInformacion.jsp"><i class="material-icons">settings</i>Actualizar información</a>            
                    </li>
                </ul>
                <ul class="right hide-on-med-and-down">
                    <li><a class="white-text name"><%=usr.getNombre()%></a></li>
                    <li><a data-activates="slide-out" class="button-collapses"><i class="material-icons">person</i></a></li>
                </ul>
            </div>
        </nav>
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <div class="row">
                </div>
            </div>
        </div>

        <div class="container">
            <div class="section">

                <ul id="slide-out" class="right side-nav">
                    <li><div class="userView">
                            <img class="background" src="imagenes/fondo.jpg">
                            <a href="#!user"><img class="circle" src="imagenes/casa.png"></a>
                            <a href="#!name"><span class="white-text name"><%=usr.getNombre()%></span></a>
                            <a href="#!email"><span class="white-text email"><%=usr.getCorreo()%></span></a>
                        </div></li>
                    <li><a href="https://www.upload.ee/image/2299952/facey.swf"><i class="material-icons">cloud</i>First Link With Icon</a></li>
                    <li><a href="modificarInformacion.jsp">Modificar Información</a></li>
                    <li><div class="divider"></div></li>
                    <li><a class="subheader">Subheader</a></li>
                    <li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
                </ul>
                <ul class="right hide-on-med-and-down">
                    <li><a data-activates="slide-out" class="button-collapses"><i class="material-icons">menu</i></a></li>
                </ul>
            </div>
        </div>
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <div class="row">
                </div>
            </div>
        </div>

        <div class="container">
            <div class="section">

                <!--   Icon Section   -->
                <div class="row">

                </div>

            </div>
            <br><br>

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
