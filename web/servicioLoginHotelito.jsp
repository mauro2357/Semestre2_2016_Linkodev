<%-- 
    Document   : servicioLoginHotelito
    Created on : 21/10/2016, 01:50:53 PM
    Author     : Mateo Ortiz Cano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresa</title>
    </head>
    <body>
        <h1>Ingresa a Los servicios del Hotel</h1>
        <form action="IngresoHotelito" method="post">
            <h3>Escribe tu correo</h3>
            <input name="correo" required="true" type="email">
            <h3>Escribe tu contraseña</h3>
            <input name="contrasena" required="true" type="password"><br><br>
            <button type="submit">Ingresar</button>
        </form>
    </body>
</html>
