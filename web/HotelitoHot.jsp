<%-- 
    Document   : calificacionHotel
    Created on : 18/08/2016, 12:31:31 AM
    Author     : julianbautista87
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <link rel="stylesheet" href="Css/Style.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="Css/login.css"/>
        <link rel="stylesheet" type="text/css" href="Css/calificacionStyle.css"  />
    </head>
    <body>        
        <section>
                <article>
                <div id="lo-titulo"><h1>Por favor califique cada uno de los servicios y características que nuestro hotel le brindó</h1></div>
                <div id="lo-forma">
                    <table>
                        <col width="50%">
                        <col width="50%">
                        <tr>
                            <th>Ítem</th>
                            <th>Calificacion</th>
                        </tr>

                        <tr>
                            <td>Le prestaron el servicio de manera cordial.</td>
                            <td>
                                <div class="stars">
                                  <form action="">
                                    <input class="star star-5" id="A-star-5" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem1').value = '5';"/>
                                    <label class="star star-5" for="A-star-5"></label>
                                    <input class="star star-4" id="A-star-4" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem1').value = '4';"/>
                                    <label class="star star-4" for="A-star-4"></label>
                                    <input class="star star-3" id="A-star-3" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem1').value = '3';"/>
                                    <label class="star star-3" for="A-star-3"></label>
                                    <input class="star star-2" id="A-star-2" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem1').value = '2';"/>
                                    <label class="star star-2" for="A-star-2"></label>
                                    <input class="star star-1" id="A-star-1" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem1').value = '1';"/>
                                    <label class="star star-1" for="A-star-1"></label>
                                  </form>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>La presentación y estado de nuestras instalaciones era el adecuado.</td>
                            <td>
                                <div class="stars">
                                  <form action="">
                                    <input class="star star-5" id="B-star-5" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem2').value = '5';"/>
                                    <label class="star star-5" for="B-star-5"></label>
                                    <input class="star star-4" id="B-star-4" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem2').value = '4';"/>
                                    <label class="star star-4" for="B-star-4"></label>
                                    <input class="star star-3" id="B-star-3" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem2').value = '3';"/>
                                    <label class="star star-3" for="B-star-3"></label>
                                    <input class="star star-2" id="B-star-2" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem2').value = '2';"/>
                                    <label class="star star-2" for="B-star-2"></label>
                                    <input class="star star-1" id="B-star-1" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem2').value = '1';"/>
                                    <label class="star star-1" for="B-star-1"></label>
                                  </form>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>El servicio fué rápido y eficaz.</td>
                            <td>
                                <div class="stars">
                                  <form action="">
                                    <input class="star star-5" id="C-star-5" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem3').value = '5';"/>
                                    <label class="star star-5" for="C-star-5"></label>
                                    <input class="star star-4" id="C-star-4" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem3').value = '4';"/>
                                    <label class="star star-4" for="C-star-4"></label>
                                    <input class="star star-3" id="C-star-3" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem3').value = '3';"/>
                                    <label class="star star-3" for="C-star-3"></label>
                                    <input class="star star-2" id="C-star-2" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem3').value = '2';"/>
                                    <label class="star star-2" for="C-star-2"></label>
                                    <input class="star star-1" id="C-star-1" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem3').value = '1';"/>
                                    <label class="star star-1" for="C-star-1"></label>
                                  </form>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Los precios son los adecuados.</td>
                            <td>
                                <div class="stars">
                                  <form action="">
                                    <input class="star star-5" id="D-star-5" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem4').value = '5';"/>
                                    <label class="star star-5" for="D-star-5"></label>
                                    <input class="star star-4" id="D-star-4" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem4').value = '4';"/>
                                    <label class="star star-4" for="D-star-4"></label>
                                    <input class="star star-3" id="D-star-3" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem4').value = '3';"/>
                                    <label class="star star-3" for="D-star-3"></label>
                                    <input class="star star-2" id="D-star-2" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem4').value = '2';"/>
                                    <label class="star star-2" for="D-star-2"></label>
                                    <input class="star star-1" id="D-star-1" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem4').value = '1';"/>
                                    <label class="star star-1" for="D-star-1"></label>
                                  </form>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Encontró con facilidad y en estado limpio y agradable los restaurantes, baños y demas instalaciones dentro de nuestro hotel.</td>
                            <td>
                                <div class="stars">
                                  <form action="">
                                    <input class="star star-5" id="E-star-5" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem5').value = '5';"/>
                                    <label class="star star-5" for="E-star-5"></label>
                                    <input class="star star-4" id="E-star-4" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem5').value = '4';"/>
                                    <label class="star star-4" for="E-star-4"></label>
                                    <input class="star star-3" id="E-star-3" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem5').value = '3';"/>
                                    <label class="star star-3" for="E-star-3"></label>
                                    <input class="star star-2" id="E-star-2" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem5').value = '2';"/>
                                    <label class="star star-2" for="E-star-2"></label>
                                    <input class="star star-1" id="E-star-1" type="radio" name="star" onclick="document.getElementById('FormularioCalificacionItem5').value = '1';"/>
                                    <label class="star star-1" for="E-star-1"></label>
                                  </form>
                                </div>
                            </td>
                        </tr>        
                        <tr>
                            <th colspan="2">Comentarios:</th>
                        </tr>
                        <tr>
                            <th colspan="2">
                                <textarea onchange="document.getElementById('FormularioCalificacionComentarios').value = this.value;"></textarea>
                            </th>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <form action="IngresarCalificacionHotelito" id="FormularioCalificacion">
                                     <input type="Submit" value="Enviar calificación y comentarios">
                                     <input type="number" name="Item1" id="FormularioCalificacionItem1" style="display:none; height: 0px"><br>
                                    <input type="number" name="Item2" id="FormularioCalificacionItem2" style="display:none; height: 0px"><br>
                                    <input type="number" name="Item3" id="FormularioCalificacionItem3" style="display:none; height: 0px"><br>
                                    <input type="number" name="Item4" id="FormularioCalificacionItem4" style="display:none; height: 0px"><br>
                                    <input type="number" name="Item5" id="FormularioCalificacionItem5" style="display:none; height: 0px"><br>
                                    <input type="text" name="Comentarios" id="FormularioCalificacionComentarios" style="display:none; height: 0px"><br> 
                                 </form>
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="lo-aviso"><p></p>
                <p>Lee nuestro 
                <a href="aviso.jsp"  class="enalceRojo"> Aviso de Privacidad</a></div>
          </article>
        </section>        
    </body>
</html>
