<!DOCTYPE html>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Error!</title>
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
                    <div class="nav-wrapper container"><a id="logo-container" href="index.jsp" class="brand-logo">IOInmuebles</a>                        
                    </div>
                </nav>
                <div class="section no-pad-bot" id="index-banner">
                    <div class="container">                        
                        <h1 class="header center error-text">¡Error!</h1>
                        <div class="row center col s12">
                            <div class="card-panel teal lighten-2">
                                <i class="large material-icons">error</i>
                                <p align=center>
                                    <%=(String) request.getSession().getAttribute("msg")%>
                                    <a href="javascript:window.history.go(-1);"> CLIC AQUÍ PARA REINTENTAR.</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.html" %>
    </body>
</html>