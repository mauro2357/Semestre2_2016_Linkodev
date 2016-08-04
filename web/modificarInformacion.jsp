<%-- 
    Document   : modificarInformacion
    Created on : 04-ago-2016, 14:40:36
    Author     : mateohenaocardona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String correo = (String) session.getAttribute("correo");
correo = "ma@gmail.com";
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
  <script>
function valida(e){
    tecla = (document.all) ? e.keyCode : e.which;

    //Tecla de retroceso para borrar, siempre la permite
    if (tecla==8){
        return true;
    }
        
    // Patron de entrada, en este caso solo acepta numeros
    patron =/[0-9]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
}
</script>
</head>
<body>
  <nav class="light-blue lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">IOInmuebles</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="#">Inicio</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="#">Inicio</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h4> Modificar Información</h4>
      <div class="row">
          <form class="col s12" action="modificarInformacion">
              <div class="input-field col s6">
                  <input name="nombre" type="text" class="validate" required >
                <label for="last_name">Nombre</label>
              </div>
              <div class="input-field col s6">
                <input name="apellido" type="text" class="validate">
                <label for="last_name">Apellido</label>
              </div>
              <div class="input-field col s6">
                  <input name="correo" type="email" readonly value = <%=correo%> >
                <label for="last_name">Correo</label>
              </div>
              <div class="input-field col s6">
                  <input name="contrasena" type="password" class="validate" required>
                <label for="password">Contraseña</label>
              </div>
              <div class="input-field col s6">
                <input name="telefono" type="text" class="validate" onkeypress="return valida(event)">
                <label for="password">Telefono</label>
              </div>
              <br>
              <br>
              <br>
              <br>
              <div class="row center col s12">
                <button  type="submit" name="actualizar_boton" class="btn-large waves-effect waves-light orange">Actualizar</button>
              </div>
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        
      </div>

    </div>
    <br><br>

    <div class="section">

    </div>
  </div>

  <footer class="page-footer orange">
    <div class="container">
      <div class="row">
        
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Hecho por <a class="orange-text text-lighten-3" href="fotodeperfil.jsp">Linkcodev</a>
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>

  </body>
</html>