<%-- 
    Document   : modificarInformacion
    Created on : 04-ago-2016, 14:40:36
    Author     : linkcodev
--%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Actualizacion de datos</title>
        <!-- CSS  -->
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
                <%@include file="barradeNavegacion.jsp"%>
                <div class="section no-pad-bot" id="index-banner">
                    <div class="container">
                        <br><br>
                        <h4> Modificar Información</h4>
                        <div class="row">
                            <form method="post" class="col s12" action="ModificarInformacion" >
                                <div class="input-field col s6">
                                    <input name="nombre" type="text" value="<%=usr.getNombre()%>" class="validate" required="">
                                    <label for="nombre">Nombre</label >
                                </div>
                                <div class="input-field col s6">
                                    <input name="correo" type="email" readonly value ="<%= usr.getCorreo()%>">
                                    <label for="correo">Correo</label>
                                </div>

                                <div class="input-field col s6">
                                    <input name="telefono" type="text" class="validate" value="<%= usr.getTelefono()%>" onkeypress="return valida(event)">
                                    <label for="telefono">Telefono</label>
                                </div> 
                                <div class=" input-field col s6">
                                    <input name="contrasena" type="password" class="validate" required="">
                                    <label for="contrasena">contrasena</label>
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
