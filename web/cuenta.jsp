<%@page import="DTO.Publicacion"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
    HttpSession sesion2 = request.getSession();
    ArrayList<Publicacion> publicaciones = (ArrayList) sesion2.getAttribute("publicaciones");
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
        <link rel="shortcut icon" href="imagenes/logoCasa.png">
    </head>
    <body>
        <%@include file="barradeNavegacion.jsp"%>
        <div class="section no-pad-bot" id="index-banner">
            <div class="container">
                <div class="row">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="section">
                <%                    
                    for (Publicacion pub : publicaciones) {
                        out.println("<a href='#'>");
                        out.println("<div class='materialboxed preloader-wrapper'>");
                        out.println("<span>"+pub.getTipoInmueble()+"</span></br>");
                        out.println("<img src='imagenes/logoCasa.png' width=140 height=110/></br>");
                        out.println("<span>"+pub.getTipoOferta()+"</span></br>");
                        out.println("<span>$"+pub.getPrecio()+"</span></br>");
                        out.println("</div>");
                        out.println("</a>");
                    }
                %>

                <!--   Icon Section   -->
                <div class="row">

                </div>

            </div>
            <br><br>

            <div class="section">
                <div class="row center col s12">
                    <a href="crearpublicacion.jsp"><button  type="button" name="publicarboton" class="btn-large waves-effect waves-light orange">Publicar un inmueble</button></a>
                </div>
            </div>
            
        </div>
        
        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
<<<<<<< HEAD
        <a href="crearpublicacion.jsp" id="view-source" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored mdl-color-text--white">¿Tienes carros para vender?</a>
        <%@include file="footer.html" %>
</body>
=======

    </body>
>>>>>>> 05d59018b7ccea1fa363ab6d9b7e1862615eac6d
</html>
