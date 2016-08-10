<%-- 
    Document   : DesactivacionCuenta
    Created on : 10/08/2016, 10:13:33 AM
    Author     : Mateo Ortiz Cano
--%>
<%@page import="DTO.Usuario" %>
<%
    Usuario usr = (Usuario) request.getSession().getAttribute("usuario");

%><!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Desactivacion de la cuenta</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="js/accionesvarias.js"></script>
    </head>
    <body>
        <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
                <ul id="slide-out" class="right side-nav">
                    <li><div class="userView">
                            <a href="#!user"><img onClick=" window.location.href = 'fotodeperfil.jsp'" class="circle" src="<%=usr.getFotourl()%>"></a>
                            <a href="#!name"><span class="white-text name"><%=usr.getNombre()%></span></a>
                            <a href="#!email"><span class="white-text email"><%=usr.getCorreo()%></span></a>
                            <a href="#!email"><span class="white-text email"><%=usr.getTelefono()%></span></a>
                        </div>
                    </li>
                    <li><div class="divider"></div></li>
                    <li><a class="waves-effect" href=""><i class="material-icons">vpn_key</i>Cambio contraseña</a></li>  
                    <li><a class="waves-effect" href="modificarInformacion.jsp"><i class="material-icons">settings</i>Actualizar información</a></li>                        
                    <li><a class="waves-effect" href=""><i class="material-icons">delete</i>Desactivar cuenta</a></li>
                    <li><a class="waves-effect" href=""><i class="material-icons">input</i>Cerrar sesion</a></li>  
                </ul>
                <ul class="right hide-on-med-and-down">
                    <li><a class="white-text name"><%=usr.getNombre()%></a></li>
                    <li><a data-activates="slide-out" class="button-collapses"><i class="material-icons">person</i></a></li>
                </ul>
            </div>
        </nav>
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <br><br>
                <h4>¿Esta seguro de querer desactivar la cuenta?</h4>
                <h5>Sus publicaciones no seran visibles a otros, aunque luego puede reactivar su cuenta iniciando sesion nuevamente</h5>
                <br>
                <br>
                <div class="row">
                    <form method="post" class="col s12" action="DesactivacionCuenta" onsubmit="return comprobarClave2()">
                        <div class="input-field col s6">
                            <input name="correo" type="email" readonly value ="<%= usr.getCorreo()%>">
                            <label for="last_name">Correo</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="contrasena" name="contrasena" type="password" class="validate" required="">
                            <label for="password">Contraseña</label>
                        </div>
                        <br>
                        <br>
                        <br>
                        <br>
                        <div class="row center col s12">
                            <button  type="submit" name="actualizar_boton" class="btn-large waves-effect waves-light orange">Confirmar desactivacion</button>
                        </div>
                    </form>
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