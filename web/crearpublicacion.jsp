<%-- 
    Document   : crearpublicacion
    Created on : 9/08/2016, 10:24:01 AM
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Publicación</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
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
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <br><br>
                <h4>Nueva publicación</h4>
                <div class="row">
                    <form class="col s12" action="Registro" method="post" onsubmit="return comprobarClave2()">
                        <div class="input-field col s6">
                            Tipo de oferta:
                            <select>
                                <option value="seleccione">Seleccione</option>
                                <option value="venta">Venta</option>
                                <option value="arriendo">Arriendo</option>
                            </select>
                        </div>
                        <div class="input-field col s6">
                            Tipo de inmueble:
                            <select>
                                <option value="">Seleccione</option>
                                <option value="casa">Casa</option>
                                <option value="apartamento">Apartamento</option>
                                <option value="habitacion">Habitación</option>
                                <option value="local">Local</option>
                                <option value="finca">Finca</option>
                            </select>
                        </div>
                        <div class="input-field col s6">
                            Ciudad:
                            <select>
                                <option value="">Seleccione</option>
                                <option value="1">Bogotá</option>
                                <option value="2">Medellín</option>
                            </select>
                        </div>
                        <div class="input-field col s6">
                            Dirección:
                            <input  name="direccion" type="text" class="validate" >
                        </div>
                        <div class="col s6">
                            Barrio:
                            <input  name="barrio" type="text" class="validate">
                        </div>
                        <div class="col s6">
                            Precio:
                            <input  name="precio" type="text" class="validate">
                        </div>
                        <div class="col s6">
                            Habitaciones:
                            <input  name="precio" type="text" class="validate">
                        </div>
                        <div class="col s6">
                            Baños:
                            <input  name="precio" type="text" class="validate">
                        </div>
                        <div class="col s6">
                            Piso:
                            <input  name="precio" type="text" class="validate">
                        </div>

                        <br>
                        <div class="row center col s12">
                            <button  type="submit" name="publicarboton" class="btn-large waves-effect waves-light orange">Publicar</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <%@include file="prueba footer al fondo.jsp" %>

        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
    </body>
</html>
