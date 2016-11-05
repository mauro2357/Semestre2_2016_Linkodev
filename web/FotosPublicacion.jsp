<%-- 
    Document   : FotosPublicacion
    Created on : 21/10/2016, 12:00:36 PM
    Author     : Pipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Registrar Publicacion</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/newcss.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="shortcut icon" href="/imagenes/logoCasa.png">
        <script src="js/accionesvarias.js"></script>
    </head>
    <body>
        <div id="wrap">
            <div id="main">
                <%@include file="barradeNavegacion.jsp"%>
                <br>
                <div class="container"> 
                    <div class="row center col s12">
                        <div class="card-panel fondoActualizarFoto">
                            <div class="row">
                                <h3 class="center">Sube algunas fotos de tu inmueble</h3>
                                <form class="col s12" action="AlmacenamientoFotosPublicacion" method="post" enctype="multipart/form-data" onsubmit="return cancelarsubmit()">
                                    <div class="push-l10">
                                        <img class="hoverable" id="imagenPincipal" src="" width=200 height=200 />
                                    </div>
                                    <div class="file-field input-field col s4 push-l4">
                                        <button class="btn-large waves-effect waves-light orange"><i class="material-icons">add</i>
                                            <input id="casa-foto4"  type="file" name="inputFile" required="" value="" accept="image/*" onchange="previewPictures(this,'imagenPincipal')"/><br>
                                        </button>
                                        <div class="file-path-wrapper">
                                            <input class="file-path validate" type="text" >
                                        </div>
                                    </div>
                                    <div class="col s12"></div>
                                    <br><br><br><br><br>
                                    <div class="col s3">
                                        <img class="hoverable" id="imagen1" src="" width=130 height=130 />
                                    </div>
                                    <div class="col s3">
                                        <img class="hoverable" id="imagen2" src="" width=130 height=130 />
                                    </div>
                                    <div class="col s3">
                                        <img class="hoverable" id="imagen3" src="" width=130 height=130 />
                                    </div>
                                    <div class="col s3">
                                        <img class="hoverable" id="imagen4" src="" width=130 height=130 />
                                    </div>
                                    <div class="col s12"></div>
                                    <div class="file-field input-field col s3">
                                        <button class="btn-large waves-effect waves-light orange "><i class="material-icons">add</i>
                                            <input id="casa-foto1"  type="file" name="inputFile" value="" accept="image/*" onchange="previewPictures(this,'imagen1')"/><br>
                                        </button>
                                        <div class="file-path-wrapper">
                                            <input class="file-path validate" type="text" >
                                        </div>
                                    </div>
                                    <div class="file-field input-field col s3">
                                        <button class="btn-large waves-effect waves-light orange"><i class="material-icons">add</i>
                                            <input id="casa-foto2"  type="file" name="inputFile" value="" accept="image/*" onchange="previewPictures(this,'imagen2')"/><br>
                                        </button>
                                        <div class="file-path-wrapper">
                                            <input class="file-path validate" type="text" >
                                        </div>
                                    </div>
                                    <div class="file-field input-field col s3">
                                        <button class="btn-large waves-effect waves-light orange"><i class="material-icons">add</i>
                                            <input id="casa-foto3"  type="file" name="inputFile" value="" accept="image/*" onchange="previewPictures(this,'imagen3')"/><br>
                                        </button>
                                        <div class="file-path-wrapper">
                                            <input class="file-path validate" type="text" >
                                        </div>
                                    </div>
                                    <div class="file-field input-field col s3">
                                        <button class="btn-large waves-effect waves-light orange"><i class="material-icons">add</i>
                                            <input id="casa-foto4"  type="file" name="inputFile" value="" accept="image/*" onchange="previewPictures(this,'imagen4')"/><br>
                                        </button>
                                        <div class="file-path-wrapper">
                                            <input class="file-path validate" type="text" >
                                        </div>
                                    </div>
                                    <br><br><br>
                                    <div class="row center col s12">
                                        <button type="submit" name="guardarfotos" class="btn-large waves-effect waves-light orange">Guardar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.html" %>
    </body>
</html>
