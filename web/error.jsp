<%-- 
    Document   : error
    Created on : 3/08/2016, 01:06:04 PM
    Author     : Mateo Ortiz Cano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JError</title>
    </head>
    <body>
        <h1>Mensaje de error :(</h1>
        <%=(String)request.getSession().getAttribute("msg")%>
        <a href="javascript:window.history.go(-1);">Reintentar.</a>
    </body>
</html>
