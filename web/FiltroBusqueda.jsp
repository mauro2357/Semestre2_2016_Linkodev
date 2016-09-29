<%-- 
    Document   : FiltroBusqueda
    Created on : 28/09/2016, 01:50:58 PM
    Author     : Pipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="FiltradoBusqueda">
            <div class="browser-default">
                <select name="tipooferta">
                    <option value="" disabled selected></option>
                    <option value="Casa">Casa</option>
                    <option value="2">Apartamento</option>
                    <option value="3">Local</option>
                </select>
                <label>Tipo</label>
            </div>
            <div class="browser-default">
                <select name="ciudad">
                    <option value="" disabled selected></option>
                    <option value="1">Bogota</option>
                    <option value="2">Medellin</option>
                </select>
                <label>Ciudad</label>
            </div>
            <div class="browser-default">
                <select name="precio">
                    <option value="" disabled selected></option>
                    <option value="1">Hasta $100.000.000</option>
                    <option value="2">$100.000.000 a $500.000.000</option>
                    <option value="3">$500.000.000 a $1000.000.000</option>
                </select>
                <label>Precio</label>
            </div>
            <div class="row center col s12">
                <button type="submit" name="buscar" class="btn-large waves-effect waves-light orange">Buscar</button>
            </div>
        </form>
    </body>
</html>
