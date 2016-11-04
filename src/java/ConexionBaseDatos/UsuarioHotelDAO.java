/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBaseDatos;

import DOMAINENTITIES.Usuario;
import DOMAINENTITIES.UsuarioHotel;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Mateo Ortiz Cano
 */
public class UsuarioHotelDAO {

    public UsuarioHotel IniciarSesion(UsuarioHotel usuarioHotel) throws MalformedURLException, IOException {
        Gson g = new Gson();
        String datosUsuario = g.toJson(usuarioHotel);
        URL url = new URL("http://172.16.100.186:8080/Semestre2_2016_Small_Programmers/serviciosweb/servicioautenticacion?datosUsuario=" + datosUsuario);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;
        String jsonRespuesta = "";
        while ((output = br.readLine()) != null) {
            jsonRespuesta += output;
        }
        conn.disconnect();
        g = new Gson();
        UsuarioHotel usuarioHotel1 = new UsuarioHotel();
        usuarioHotel1 = g.fromJson(jsonRespuesta, UsuarioHotel.class);
        return usuarioHotel1;
    }
}
