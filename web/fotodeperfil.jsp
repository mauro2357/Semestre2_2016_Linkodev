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
        <script>
            function cancelarsubmit() {
                if (document.getElementById('imagenperfil').files.length === 0) {
                    alert("Por favor seleccione un archivo");
                    return false;
                }
            }
            function previewFile() {
                var preview = document.querySelector('img');
                var file = document.querySelector('input[type=file]').files[0];
                var reader = new FileReader();

                reader.addEventListener("load", function () {
                    preview.src = reader.result;
                }, false);

                if (file) {
                    reader.readAsDataURL(file);
                }
            }
        </script>
    </head>
    <body>
        <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="fotodeperfil.jsp">Inicio</a></li>
                </ul>
                <ul id="nav-mobile" class="side-nav">
                    <li><a href="fotodeperfil.jsp">Inicio</a></li>
                </ul>
                <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>
        </nav>

        <div class="container">
            <h4>Foto de Perfil</h4>
            <div class="row">
                <div class="push-l10">
                    <img class="hoverable" id="imagenprev" src="" width=250 height=300 />
                </div>
                <form method="POST" action="cambiarfotodeperfil" enctype="multipart/form-data" onsubmit="return cancelarsubmit()">
                    <div class="file-field input-field">
                        <div class="btn-large waves-effect waves-light orange">
                            <span>Elegir foto</span>
                            <input id="imagenperfil"  type="file" name="inputFile" value="" accept="image/*" onchange="previewFile()"/><br>

                        </div>
                        <div class="file-path-wrapper col s3">
                            <input class="file-path validate" type="text" >
                        </div>
                    </div>
                    <div class="row center col s12">
                        <button type="submit" name="cambiarfotoboton" class="btn-large waves-effect waves-light orange">Guardar</button>
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
                Hecho por <a class="orange-text text-lighten-3" href="#">Linkcodev</a>
            </div>
        </div>
    </footer>

    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.js"></script>
    <script src="js/init.js"></script>

</body>
</html>
