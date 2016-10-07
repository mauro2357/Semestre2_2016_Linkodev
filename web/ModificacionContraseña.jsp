<%-- 
    Document   : Modificacioncontrasena
    Created on : 10/08/2016, 08:47:04 AM
    Author     : linkcodev
--%>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Cambio de contrasena</title>
        <!-- CSS  -->
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
                        <h4>Cambio de contrasena</h4>
                        <div class="row">
                            <form method="post" class="col s12" action="ModificacionContrasena" onsubmit="return comprobarClave2()">
                                <div class="input-field col s6">
                                    <input name="correo" type="email" readonly value ="<%= usr.getCorreo()%>">
                                    <label for="last_name">Correo</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="contrasena" name="contrasenaNueva" type="password" class="validate" required="">
                                    <label for="password">contrasena Nueva</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="confirmarContrasena" name="confirmarContrasena" type="password" class="validate" required="">
                                    <label for="password">Confirmar contrasena Nueva</label>
                                </div> 
                                <div class=" input-field col s6">
                                    <input name="contrasena" type="password" class="validate" required="">
                                    <label for="password">contrasena actual</label>
                                </div>
                                <div class="row center col s12">
                                    <button  type="submit" name="actualizar_boton" class="btn-large waves-effect waves-light orange">Actualizar</button>
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
