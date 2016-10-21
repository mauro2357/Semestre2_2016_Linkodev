<%-- 
    Document   : barradeNavegacion
    Created on : 10-ago-2016, 18:23:27
    Author     : linkcodev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="DOMAINENTITIES.Usuario" %>
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
        <nav class="blue darken-4" role="navigation">
            <div class="nav-wrapper container"><a id="logo-container" href="MuestraPublicacion" class="brand-logo">IOInmuebles</a>
                <ul id="slide-out" class="right side-nav blue darken-4">
                    <li><div class="userView">
                            <a><img onClick=" window.location.href = 'fotodeperfil.jsp'" class="circle" src="http://localhost:8080/Semestre2_2016_Linkodev/<%=usr.getFotourl()%>"></a>
                            <a><span class="white-text name"><%=usr.getNombre()%></span></a>
                            <a><span class="white-text email"><%=usr.getCorreo()%></span></a>
                            <a><span class="white-text email"><%=usr.getTelefono()%></span></a>
                        </div>
                    </li>
                    <li><div class="divider"></div></li>
                    <li><a class="waves-effect" href="crearpublicacion.jsp"><i class="material-icons">publish</i>Publicar</a></li>  
                    <li><a class="waves-effect" href="Modificacioncontrasena.jsp"><i class="material-icons">vpn_key</i>Cambiar contrasena</a></li>  
                    <li><a class="waves-effect" href="modificarInformacion.jsp"><i class="material-icons">settings</i>Actualizar información</a></li>
                    <li><a class="waves-effect" href="MuestraPublicacionPropia"><i class="material-icons">build</i>Editar publicaciones</a></li>
                    <li><a class="waves-effect" href="DesactivacionCuenta.jsp"><i class="material-icons">delete</i>Desactivar cuenta</a></li>
                    <li><a class="waves-effect" href="CerrarSesion" ><i class="material-icons">input</i>Cerrar sesion</a></li>  
                </ul>
                <ul class="right hide-on-med-and-down">                    
                    <li><a data-activates="slide-out" class="button-collapses"><i class="material-icons">person</i></a></li>                    
                    <li><a href="Notificaciones"><i class="material-icons">notifications</i></a></li>                    
                </ul>                
                <ul class="right hide-on-med-and-down">                    
                    <form action="BusquedaByUsuario" method="">
                        <div class="input-field">
                            <input name="usuario" id="search" type="search" required="" placeholder="Buscar">
                            <label for="search"><i class="material-icons">search</i></label>
                            <i class="material-icons">close</i>
                        </div>
                    </form>
                </ul> 
            </div>                    
        </nav>
    </body>
</html>
