/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBaseDatos;

import java.sql.SQLException;

/**
 *
 * @author mateohenaocardona
 */
public interface ICalificacionDAO {
    
        public void calificar(int calificacion,String identificador) throws SQLException;
}
