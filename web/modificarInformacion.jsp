<%-- 
    Document   : modificarInformacion
    Created on : 04-ago-2016, 14:40:36
    Author     : mateohenaocardona
--%>

<%@page import="DTO.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario usr = (Usuario) request.getSession().getAttribute("usuario");
%>


<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>IOInmuebles</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
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
        </nav>
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <br><br>
                <h4> Modificar Información</h4>
                <div class="row">
                    <form class="col s12" action="ModificarInformacion">
                        <div class="input-field col s6">
                            <input name="nombre" type="text" class="validate" required >
                            <label for="last_name">Nombre</label>
                        </div>
                        <div class="input-field col s6">
                            <input name="apellido" type="text" class="validate">
                            <label for="last_name">Apellido</label>
                        </div>
                        <div class="input-field col s6">
                            <input name="correo" type="email" readonly value = <%= usr.getCorreo()%> >
                            <label for="last_name">Correo</label>
                        </div>
                        <div class="input-field col s6">
                            <input name="contrasena" type="password" class="validate" required>
                            <label for="password">Contraseña</label>
                        </div>
                        <div class="input-field col s6">
                            <input name="telefono" type="text" class="validate" onkeypress="return valida(event)">
                            <label for="password">Telefono</label>
                        </div> 
                        <br>
                        <br>
                        <br>
                        <br>
                        <div class="row center col s12">
                            <button  type="submit" name="actualizar_boton" class="btn-large waves-effect waves-light orange">Actualizar</button>
                        </div>
                    </form>
                    <div class="row center col s6">
                        <button  name="cambiarFoto_boton" onClick=" window.location.href = 'fotodeperfil.jsp'" class="btn-large waves-effect waves-light orange">Cambiar Foto</button>
                    </div>
                </div>
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
