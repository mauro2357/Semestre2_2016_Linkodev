<%-- 
    Document   : FiltroBusqueda
    Created on : 28/09/2016, 01:50:58 PM
    Author     : Pipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="section" id="index">            
            <div class="row">
                <form class="col s12" method="post" action="FiltradoBusqueda">                                                  
                    <div class="input-field col s2">
                        <select name="tipooferta">
                            <option value="" disabled selected></option>
                            <option value="Venta">Venta</option>
                            <option value="Arriendo">Arriendo</option>
                        </select>
                        <label>Tipo Oferta</label>
                    </div>
                    <div class=" input-field col s2">
                        <select name="tipoinmueble">
                            <option value="" disabled selected></option>
                            <option value="Casa">Casa</option>
                            <option value="Apartamento">Apartamento</option>
                            <option value="Habitacion">Habitación</option>
                            <option value="Local">Local</option>
                            <option value="Finca">Finca</option>
                        </select>
                        <label>Tipo Inmueble</label>
                    </div>
                    <div class="input-field col s2">
                        <select name="ciudad">
                            <option value="" disabled selected></option>
                            <option value="Bogota">Bogota</option>
                            <option value="Medellin">Medellín</option>
                            <option value="Cali">Cali</option>
                            <option value="Barranquilla">Barranquilla</option>
                            <option value="Risaralda">Risaralda</option>
                        </select>
                        <label>Ciudad</label>
                    </div>
                    <div class="input-field col s2">
                        <select name="precio">
                            <option value="" disabled selected></option>
                            <option value="1">Hasta $100.000.000</option>
                            <option value="2">$100.000.000 a $500.000.000</option>
                            <option value="3">$500.000.000 a $1000.000.000</option>
                        </select>
                        <label>Precio</label>
                    </div>
                    <div class="col s2">
                        <button type="submit" name="buscar" class="btn-large waves-effect waves-light orange">Buscar</button>
                    </div>
                </form>
            </div>    
        </div>      
    </body>
</html>
