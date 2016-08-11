<%-- 
    Document   : barradeNavegacion
    Created on : 10-ago-2016, 18:23:27
    Author     : linkcodev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="DTO.Usuario" %>


<%
    HttpSession sesion = request.getSession();
    Usuario usr = (Usuario) sesion.getAttribute("usuario");  
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Barra de navegacion</title>
        <link rel="shortcut icon" href="imagenes/logoCasa.png">
    </head>
    <body>
            <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
                <ul id="slide-out" class="right side-nav">
                    <li><div class="userView">
                            <a href="#!user"><img onClick=" window.location.href = 'fotodeperfil.jsp'" class="circle" src="<%=usr.getFotourl()%>"></a>
                            <a href="#!name"><span class="white-text name"><%=usr.getNombre()%></span></a>
                            <a href="#!email"><span class="white-text email"><%=usr.getCorreo()%></span></a>
                            <a href="#!email"><span class="white-text email"><%=usr.getTelefono()%></span></a>
                        </div>
                    </li>
                    <li><div class="divider"></div></li>
                    <li><a class="waves-effect" href="ModificacionContraseña.jsp"><i class="material-icons">vpn_key</i>Cambio contraseña</a></li>  
                    <li><a class="waves-effect" href="modificarInformacion.jsp"><i class="material-icons">settings</i>Actualizar información</a></li>                        
                    <li><a class="waves-effect" href="DesactivacionCuenta.jsp"><i class="material-icons">delete</i>Desactivar cuenta</a></li>
                    <li><a class="waves-effect" href="CerrarSesion" ><i class="material-icons">input</i>Cerrar sesion</a></li>  
                </ul>
                <ul class="right hide-on-med-and-down">
                    <li><a class="white-text name"><%=usr.getNombre()%></a></li>
                    <li><a data-activates="slide-out" class="button-collapses"><i class="material-icons">person</i></a></li>
                </ul>
            </div>
        </nav>
    </body>
</html>