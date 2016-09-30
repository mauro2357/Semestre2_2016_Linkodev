<%-- 
    Document   : crearpublicacion
    Created on : 9/08/2016, 10:24:01 AM
    Author     : linkcodev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Publicación</title>
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
                        <br><br>
                        <div class="row">
                            <form class="col s12" action="CreacionPublicacion" method="post">
                                <div class="input-field col s6">
                                    Tipo de oferta:
                                    <select name="tipooferta" required aria-required="true">
                                        <option value="">Seleccione</option>
                                        <option value="Venta">Venta</option>
                                        <option value="Arriendo">Arriendo</option>
                                    </select>
                                </div>
                                <div class="input-field col s6">
                                    Tipo de inmueble:
                                    <select name="tipoinmueble">
                                        <option value="">Seleccione</option>
                                        <option value="Casa">Casa</option>
                                        <option value="Apartamento">Apartamento</option>
                                        <option value="Habitacion">Habitación</option>
                                        <option value="Local">Local</option>
                                        <option value="Finca">Finca</option>
                                    </select>
                                </div>
                                <div class="input-field col s6">
                                    Ciudad:
                                    <select name="ciudad">
                                        <option value="">Seleccione</option>
                                        <option value="Bogota">Bogota</option>
                                        <option value="Medellin">Medellín</option>
                                        <option value="Cali">Cali</option>
                                        <option value="Barranquilla">Barranquilla</option>
                                        <option value="Risaralda">Risaralda</option>
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
                                    <input  name="precio" type="text" class="validate" onkeypress="return valida(event)">
                                </div>
                                <div class="col s6">
                                    Habitaciones:
                                    <input  name="habitaciones" type="number" min="0" max="20" step="1" class="validate" onkeypress="return valida(event)">
                                </div>
                                <div class="col s6">
                                    Baños:
                                    <input  name="banos" type="number" min="0" max="20" step="1" class="validate" onkeypress="return valida(event)">
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
                                    <input  name="estrato" type="number" min="1" max="6" class="validate"  onkeypress="return valida(event)">
                                </div>
                                <br>
                                <div class="row center col s12">
                                    <button  type="submit" name="publicarboton" class="btn-large waves-effect waves-light orange">Publicar</button>
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
