<%-- 
    Document   : ModificacionPublicacion
    Created on : 19-ago-2016, 11:27:04
    Author     : MARCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Publicación</title>
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
                        <h4>Nueva publicación</h4>
                        <div class="row">
                            <form class="col s12" action="ModificacionDePublicacion" method="post">
                                <div class="input-field col s6">
                                    Tipo de oferta:
                                    <select name="tipooferta" required aria-required="true">
                                        <option></option>
                                        <option value="venta">Venta</option>
                                        <option value="arriendo">Arriendo</option>
                                    </select>
                                </div>
                                <div class="input-field col s6">
                                    Tipo de inmueble:
                                    <select name="tipoinmueble">
                                        <option></option>
                                        <option value="casa">Casa</option>
                                        <option value="apartamento">Apartamento</option>
                                        <option value="habitacion">Habitación</option>
                                        <option value="local">Local</option>
                                        <option value="finca">Finca</option>
                                    </select>
                                </div>
                                <div class="input-field col s6">
                                    Ciudad:
                                    <select name="ciudad">
                                        <option value="">Seleccione</option>
                                        <option value="1">Bogotá</option>
                                        <option value="2">Medellín</option>
                                    </select>
                                </div>
                                <div class="input-field col s6">
                                    Dirección:
                                    <input  name="direccion" type="text" class="validate">
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
                                    <input  name="habitaciones" type="number" min="0" max="20" step="1" class="validate">
                                </div>
                                <div class="col s6">
                                    Baños:
                                    <input  name="banos" type="number" min="0" max="20" step="1" class="validate">
                                </div>
                                <div class="col s6">
                                    Piso:
                                    <input  name="piso" type="text" class="validate" onkeypress="return valida(event)">
                                </div>
                                <div class="col s6">
                                    Área:
                                    <input  name="area" type="text" class="validate" onkeypress="return valida(event)">
                                </div>
                                <div class="col s6">
                                    Estrato:
                                    <input  name="estrato" type="text" class="validate" onkeypress="return valida(event)">
                                </div>

                                <br>
                                <div class="row center col s12">
                                    <button  type="submit" name="publicarboton" class="btn-large waves-effect waves-light orange">Editar</button>
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