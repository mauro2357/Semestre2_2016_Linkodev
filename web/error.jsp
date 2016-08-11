<!DOCTYPE html>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Error!</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="shortcut icon" href="imagenes/logoCasa.png">
        
    </head>
    <body>
        <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="fotodeperfil.jsp">Inicio</a></li>
                    <li><a href="index2.html">Registrese!</a></li>
                    <li><a href="#">Ingrese!</a></li>
                </ul>
                <ul id="nav-mobile" class="side-nav">
                    <li><a href="fotodeperfil.jsp">Inicio</a></li>
                    <li><a href="index2.html">Registrese!</a></li>
                    <li><a href="#">Ingrese!</a></li>
                </ul>
                <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>
        </nav>
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <br><br>
                <h1 class="header center error-text">¡Error!</h1>

                <div class="row center col s12">
                    <div class="card-panel teal lighten-2">
                        <i class="large material-icons">error</i>
                        <p align=center>
                            <%=(String) request.getSession().getAttribute("msg")%>
                            <a href="javascript:window.history.go(-1);">Reintentar.</a>
                        </p>
                    </div>
                </div>
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