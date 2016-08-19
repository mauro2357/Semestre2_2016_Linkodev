<%@page import="DOMAINENTITIES.Usuario"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>IOInmuebles</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="css/newcss.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link rel="shortcut icon" href="imagenes/logoCasa.png">

    </head>
    <body>
        <div id="wrap">
            <div id="main">
                <nav class="light-blue lighten-1" role="navigation">
                    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
                        <ul class="right hide-on-med-and-down">
                            <li><a href="registrar.jsp">Registrese!</a></li>
                            <li><a href="login.jsp">Ingrese! </a>
                            </li>
                        </ul>
                        <ul id="nav-mobile" class="side-nav">
                            <li><a href="registrar.jsp">Registrese!</a></li>
                            <li><a href="login.jsp">Ingrese!</a></li>
                        </ul>
                        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
                    </div>
                </nav>
                <%--<%@include file="bodyCuenta.jsp" %>--%>
            </div>   
        </div>
        <%@include file="footer.html" %>
    </body>
</html>
