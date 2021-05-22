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
import model.liquidaciones;

/**
 *
 * @author Mauricio
 */
public class liquidacionGestion {
    private static final String SQL_SelectLiquidacion = " SELECT * FROM liquidaciones";
     private static final String SQL_insertLiquidacion = "INSERT INTO liquidaciones("
            + "estatusentrega, "
            + "montoLiquidacion,"
            + "id_empleado,"
            + ")VALUES(?,?,?)";
    
        public static ArrayList<liquidaciones> getLiquidacion() {
        ArrayList<liquidaciones> listadoLiquidaciones = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectLiquidacion);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                listadoLiquidaciones.add(new liquidaciones(rs.getBoolean(1),
                        rs.getFloat(2),
                       rs.getInt(3)));
            }
        } catch (SQLException e) {
            Logger.getLogger(liquidacionGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return listadoLiquidaciones;
    }
    
     public static boolean insertarLiquidacion(liquidaciones liq) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_insertLiquidacion);
            pst.setBoolean(1, liq.isEstatudsEntrega());
            pst.setFloat(2, liq.getMontoLiquidacion());
            pst.setObject(3, liq.getId_empleado());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(liquidacionGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    
}
