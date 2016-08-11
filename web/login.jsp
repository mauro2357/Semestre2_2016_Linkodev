<%-- 
    Document   : login
    Created on : 03-ago-2016, 17:27:14
    Author     : linkcodev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Iniciar Sesión</title>

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
                    <li><a href="index2.html">Inicio</a></li>
                    <li><a href="registrar.jsp">Registrese!</a></li>
                </ul>

                <ul id="nav-mobile" class="side-nav">
                    <li><a href="index2.html">Inicio</a></li>
                    <li><a href="registrar.jsp">Registrese!</a></li>
                </ul>
                <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>
        </nav>
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <br><br>
                <h4>Inicia Sesión</h4>
                <div class="row">
                    <form method="post" class="col s12" action="InicioSesion">

                        <div class="input-field col s12">
                            <input name="correo" type="email" class="validate" required="">
                            <label for="last_name">Correo</label>
                        </div>
                        <br>
                        <div class="input-field col s12">
                            <input  name="contrasena" type="password" class="validate" required="">
                            <label for="password">Contraseña</label>
                        </div>
                        <br>
                        <div class="row center col s12">
                            <button type="submit" name="Login_boton" class="btn-large waves-effect waves-light orange">Iniciar Sesión</button>
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
        <br><br><br>

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
