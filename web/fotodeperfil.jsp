<%-- 
    Document   : fotodeperfil
    Created on : 4/08/2016, 08:24:23 AM
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foto de perfil</title>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="fotodeperfil.jsp">Inicio</a></li>
        <li><a href="index.html">Registrese!</a></li>
        <li><a href="#">Ingrese!</a></li>
      </ul>
      <ul id="nav-mobile" class="side-nav">
        <li><a href="fotodeperfil.jsp">Inicio</a></li>
        <li><a href="index.html">Registrese!</a></li>
        <li><a href="#">Ingrese!</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
        <div class="container right col s6">
            <img src="imagenes/${fileName}"width=250 height=300 />
        </div>
        <div class="col s6">
            <br><br>
            <h4 class="blue-text" >Foto de Perfil</h4>
            <br><br>
            <div class="row">
                <form method="POST" action="cambiarfotodeperfil" enctype="multipart/form-data">
                    <div class="file-field input-field">
                        <div class="btn-large waves-effect waves-light orange">
                            <span>Elegir foto</span>
                            <input type="file" name="inputFile" id="inputFile" value="" accept="image/*"/> 
                        </div>
                        <div class="file-path-wrapper col s3">
                            <input class="file-path validate" type="text">
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
                    <br>
                    <br>
                    <div class="row center col s3">
                        <button name="registro_boton" class="btn-large waves-effect waves-light orange">Cambiar</button>
                    </div>
                </form>
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

    <footer class="page-footer orange">
        <div class="container">
            <div class="row">

            </div>
        </div>
        <div class="footer-copyright">
            <div class="container">
                Hecho por <a class="orange-text text-lighten-3" href="">Linkcodev</a>
            </div>
        </div>
    </footer>

    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.js"></script>
    <script src="js/init.js"></script>

</body>
</html>
