/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.nomina;


/**
 *
 * @author Mauricio
 */
public class nominaGestion {
    
     private static final String SQL_SelectNomina = " SELECT * FROM nomina";
   
     public static ArrayList<nomina> getNomina() {
        ArrayList<nomina> listaNomina = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectNomina);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                listaNomina.add(new nomina(rs.getInt(1),
                        rs.getFloat(2),
                        rs.getInt(3),
                        rs.getDate(4)));
            }
        } catch (SQLException e) {
            Logger.getLogger(nominaGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return listaNomina;
    }
    
}
