
<!DOCTYPE html>

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
        <link rel="shortcut icon" href="imagenes/logoCasa.png">
    </head>
    <body>
        <div id="wrap">
            <div id="main">
                <nav class="light-blue lighten-1" role="navigation">
                    <div class="nav-wrapper container"><a id="logo-container" href="MuestraPublicacion" class="brand-logo">IOInmuebles</a>
                        <ul id="slide-out" class="right side-nav">
                            <li><div class="userView">
                                    <a><img onClick=" window.location.href = 'fotodeperfil.jsp'" class="circle" src="foto"></a>
                                    <a><span class="white-text name">pablo</span></a>
                                    <a><span class="white-text email">pablo@asf</span></a>
                                    <a><span class="white-text email">54546</span></a>
                                </div>
                            </li>
                            <li><div class="divider"></div></li>
                            <li><a class="waves-effect" href="crearpublicacion.jsp"><i class="material-icons">publish</i>Publicar</a></li>  
                            <li><a class="waves-effect" href="ModificacionContraseña.jsp"><i class="material-icons">vpn_key</i>Cambiar contraseña</a></li>  
                            <li><a class="waves-effect" href="modificarInformacion.jsp"><i class="material-icons">settings</i>Actualizar información</a></li>
                            <li><a class="waves-effect" href="MuestraPublicacionPropia"><i class="material-icons">build</i>Editar publicaciones</a></li>
                            <li><a class="waves-effect" href="DesactivacionCuenta.jsp"><i class="material-icons">delete</i>Desactivar cuenta</a></li>
                            <li><a class="waves-effect" href="CerrarSesion" ><i class="material-icons">input</i>Cerrar sesion</a></li>  
                        </ul>
                        <ul class="right hide-on-med-and-down">                    
                            <li><a data-activates="slide-out" class="button-collapses"><i class="material-icons">person</i></a></li>                    
                        </ul>                
                        <ul class="right hide-on-med-and-down">
                            <li> <%@include file="FiltroBusqueda.jsp" %></li>
                        </ul>
                    </div>                    
                </nav> 
            </div>
        </div>
        <%@include file="footer.html" %>
    </body> 
</html>
