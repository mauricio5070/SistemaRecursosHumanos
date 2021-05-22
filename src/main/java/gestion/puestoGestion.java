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
import model.puesto;

/**
 *
 * @author eduar
 */
public class puestoGestion {
    
    private static final String SQL_SelectPuestoEmpleadoId = "SELECT * FROM puesto WHERE id_puesto = ?";
    private static final String SQL_SelectPuestoEmpleado = "SELECT * FROM puesto";
    private static final String SQL_InsertPuesto = "";
    private static final String SQL_DeletePuesto = "";
    private static final String SQL_UpdatePuesto = "";
    private static final String SQL_getIDPuesto = "SELECT A.* FROM puesto A, empleados B "
            + "WHERE A.id_puesto = B.id_puesto AND B.correoEmpleado = ?";
    
    
    public static ArrayList<puesto> getPuesto() {
        ArrayList<puesto> listadoPuestos = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectPuestoEmpleado);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                listadoPuestos.add(new puesto(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3)));
            }
        } catch (SQLException e) {
            Logger.getLogger(puestoGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return listadoPuestos;
    }
    
    public static puesto getPuesto(String correo){
        puesto psto = null;
        try {
                PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_getIDPuesto);
                pst.setString(1, correo);
                ResultSet rs = pst.executeQuery();
                while(rs != null && rs.next()){
                    psto = (new puesto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3)  
                    ));
                }
            } catch (SQLException e) {
                            Logger.getLogger(puestoGestion.class.getName())
                    .log(Level.SEVERE, null, e);
            }
        return psto;
    }
    
    public static int getIdPuesto(){
        int idPuesto = 0;
        try {
            
        } catch (Exception e) {
        }
        return idPuesto;
    }
}
