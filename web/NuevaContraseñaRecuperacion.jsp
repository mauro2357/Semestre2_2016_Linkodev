<%-- 
    Document   : NuevaContraseñaRecuperacion
    Created on : 19-ago-2016, 14:42:42
    Author     : mateohenaocardona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Recuperar Contraseña</title>
        
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/newcss.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
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
                        <h4>Cambio de contraseña</h4>
                        <div class="row">
                            <form method="post" class="col s12" action="ContrasenaNuevaRecuperacion" onsubmit="return comprobarClave2()">
                                <div class="input-field col s6">
                                    <input name="correo" type="email" readonly value ="<%= usr.getCorreo()%>">
                                    <label for="last_name">Correo</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="contrasena" name="contrasenaNueva" type="password" class="validate" required="">
                                    <label for="password">Contraseña Nueva</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="confirmarContrasena" name="confirmarContrasena" type="password" class="validate" required="">
                                    <label for="password">Confirmar Contraseña Nueva</label>
                                </div> 
                                <div class="row center col s12">
                                    <button  type="submit" name="actualizar_boton" class="btn-large waves-effect waves-light orange">Nueva Contraseña</button>
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
