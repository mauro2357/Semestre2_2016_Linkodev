/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBaseDatos;

import DOMAINENTITIES.Administrador;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mateohenaocardona
 */
public class AdministradorDAO {
    
    public void registrarAdministrador(Administrador admin) throws SQLException{
        Encriptacion encriptarcontrasena = new Encriptacion();
        String contrasenaEncriptada =encriptarcontrasena.Encriptar(admin.getcontrasena());
        ConexiónBD nuevaconexion=new ConexiónBD();
        Statement stm = nuevaconexion.getConeccion().createStatement();
        String query="INSERT INTO usuario VALUES ('"+admin.getNombre()+"','"
            +admin.getCorreo()+"','"+contrasenaEncriptada+"','1234567890','imagenes/nopic.png',1,1)";
        System.out.println("query: "+query);
        stm.executeUpdate(query);
    }
    
}
