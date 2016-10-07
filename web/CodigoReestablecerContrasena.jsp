<%-- 
    Document   : RecuperacionContrasena
    Created on : 18/08/2016, 11:12:45 AM
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reestablecer contrasena</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/newcss.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <script src="js/accionesvarias.js"></script>
        <link rel="shortcut icon" href="imagenes/logoCasa.png">
    </head>
    <body>
        <div id="wrap">
            <div id="main">
                <nav class="light-blue lighten-1" role="navigation">  
                    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
                        <ul class="right hide-on-med-and-down">
                            <li><a href="index.jsp">Inicio</a></li>
                            <li><a href="registrar.jsp">Registrese!</a></li>
                        </ul>
                        <ul id="nav-mobile" class="side-nav">
                            <li><a href="index.jsp">Inicio</a></li>
                            <li><a href="registrar.jsp">Registrese!</a></li>
                        </ul>
                        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
                    </div>
                </nav>
                <div class="centrototal">
                    <h6 class="small">
                        Ingresa el código que hemos enviado a tu correo
                    </h6>
                    <br/>
                    <hr/>
                    <form action="VerificacionCodigoContrasena" method="post">
                        <div class="input-field col s6">   
                            <input name="codigo" type="text" class="validate" required="">
                            <label for="codigo">Código</label>                            
                        </div>
                        <button type="submit" name="reestablecercontrasena" class="btn  waves-effect waves-light orange">Reestablecer contrasena</button>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="footer.html" %>
    </body>
</html>