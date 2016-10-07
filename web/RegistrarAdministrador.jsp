<%-- 
    Document   : RegistrarAdministrador
    Created on : 16-sep-2016, 10:33:55
    Author     : mateohenaocardona
--%>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>IOInmuebles</title>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/newcss.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="js/accionesvarias.js"></script> 
    </head>
    <body>
        <div id="wrap">
            <div id="main">
                <nav class="light-blue lighten-1" role="navigation">
                    <div class="nav-wrapper container"><a id="logo-container" href="index.jsp" class="brand-logo">IOInmuebles</a>
                        <ul class="right hide-on-med-and-down">
                            <li><a href="index.jsp">Inicio</a></li>
                            <li><a href="login.jsp">Ingrese!</a></li>
                        </ul>
                        <ul id="nav-mobile" class="side-nav">
                            <li><a href="index.jsp">Inicio</a></li>
                            <li><a href="login.jsp">Ingrese!</a></li>
                        </ul>
                        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
                    </div>
                </nav>
                <div class="section no-pad-bot" id="index-banner">
                    <div class="container">   
                        <br><br>
                        <h4>Registro Administrador</h4>
                        <div class="row">
                            <form class="col s12" action="RegistroAdministrador" method="post" onsubmit="return comprobarClave2()">
                                <div class="input-field col s12">
                                    <input name="nombre" type="text" class="validate" required>
                                    <label for="nombre">Nombre Completo</label >
                                </div>
                                <div class="input-field col s6">
                                    <input name="correo" type="email" class="validate" required>
                                    <label for="correo">Correo</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="contrasena" name="contrasena" type="password" class="validate" required="">
                                    <label for="contrasena">contrasena</label>
                                </div>
                                <div class="input-field col s6">
                                    <input id="confirmarContrasena"  name="contrasena1" type="password" class="validate" required="">
                                    <label for="contrasena2">Confirmar contrasena</label>
                                </div>
                                <div class="row center col s12">
                                    <button  type="submit" name="registro_boton" class="btn-large waves-effect waves-light orange">Registrar</button>
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

