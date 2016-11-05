<%@page import="java.util.ArrayList"%>
<%
    HttpSession sesion2 = request.getSession();
    ArrayList<String> mensajes =(ArrayList) sesion2.getAttribute("mensajes");
%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>IOInmuebles</title>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/newcss.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="shortcut icon" href="/imagenes/logoCasa.png">
    </head>
    <body>
        <div id="wrap">
            <div id="main">
                <%@include file="barradeNavegacion.jsp"%>
                <div class="section no-pad-bot" id="index-banner">
                </div>
                <%@include file="FiltroBusqueda.jsp" %>
                <div class="collection">                                     
                    <%                    for (String mens : mensajes) {
                            out.println("<a href='EliminacionNotificacion?mens="+mens+"&correo="+usr.getCorreo()+"' class='collection-item'>"+mens+"</a>");
                        }
                    %>                
                </div>                
            </div>
        </div>
        <%@include file="footer.html" %>
    </body> 
</html>

