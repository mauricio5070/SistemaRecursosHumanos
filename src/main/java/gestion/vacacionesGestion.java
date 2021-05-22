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
import model.vacaciones;

/**
 *
 * @author eduar
 */
public class vacacionesGestion {

    private static final String SQL_INSERTVACACIONES = "INSERT INTO vacaciones(id_empleado, cantidad)";
    private static final String SQL_DELETEVACACIONES = "DELETE vacaciones where id_vacacion = ?";
    private static final String SQL_SelectVacaciones = "SELECT id_empleado, cantidadVacacionesDisponibles FROM vacaciones";
    private static final String SQL_SelectVacacionesEmpleado = "SELECT id_empleado, cantidadVacacionesDisponibles "
            + "FROM vacaciones WHERE id_empleado =?";
    private static final String SQL_UpdateVacaciones = "INSERT vacaciones SET cantidadVacacionesDisponibles WHERE id_empleado ?";
    
    public static ArrayList<vacaciones> getVacaciones(){
        ArrayList<vacaciones> listVac = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectVacaciones);
            ResultSet rs = pst.executeQuery();
            while(rs != null & rs.next()){
                listVac.add(new vacaciones(rs.getInt(1),
                        rs.getInt(2)));
            }
            return listVac;
        } catch (SQLException e) {
            Logger.getLogger(vacacionesGestion.class.getName())
                    .log(Level.SEVERE, null, e);            
        }
        return listVac;
    }
    
    public static vacaciones getVacaciones(int id_empleado){
        vacaciones vac = null;
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectVacacionesEmpleado);
            pst.setInt(1, id_empleado);
            ResultSet rs = pst.executeQuery();
            while(rs != null & rs.next()){
                vac = (new vacaciones(rs.getInt(1),
                        rs.getInt(2)));
            }
            return vac;
        } catch (SQLException e) {
            Logger.getLogger(vacacionesGestion.class.getName())
                    .log(Level.SEVERE, null, e);            
        }
        return vac;
    }
    
}
