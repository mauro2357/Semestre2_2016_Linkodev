<%--Document   : DesactivacionCuenta
    Created on : 10/08/2016, 10:13:33 AM
    Author     : linkcodev
--%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Desactivacion de la cuenta</title>
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
                        <h4>¿Esta seguro de querer desactivar la cuenta?</h4>
                        <h5>Sus publicaciones no seran visibles a otros, aunque luego puede reactivar su cuenta iniciando sesion nuevamente</h5>
                        <br><br>
                        <div class="row">
                            <form method="post" class="col s12" action="DesactivacionCuenta" onsubmit="return comprobarClave2()">
                                <div class="input-field col s6">
                                    <input name="correo" type="email" readonly value ="<%= usr.getCorreo()%>">
                                    <label for="correo">Correo</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="contrasena" name="contrasena" type="password" class="validate" required="">
                                    <label for="contrasena">contrasena</label>
                                </div>
                                <div class="row center col s12">
                                    <button  type="submit" name="actualizar_boton" class="btn-large waves-effect waves-light orange">Confirmar desactivacion</button>
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