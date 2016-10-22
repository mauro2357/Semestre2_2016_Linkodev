<%-- 
    Document   : cuentaHotel
    Created on : 21/10/2016, 02:42:52 PM
    Author     : Mateo Ortiz Cano
--%>

<%@page import="DOMAINENTITIES.UsuarioHotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    UsuarioHotel usr = (UsuarioHotel) sesion.getAttribute("usr");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuenta Hotel</title>
    </head>
    <body>
        <h1>Cuenta</h1>
        <h2><%=usr.getNombre()%></h2>
        <h3><%=usr.getApellido()%></h3>
        <h4><%=usr.getCorreo()%></h4>
        <h4><%=usr.getId()%></h4>
        <h4><%=usr.getTipoPersona()%></h4>
    </body>
</html>
