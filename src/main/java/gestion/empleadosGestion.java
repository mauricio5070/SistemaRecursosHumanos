/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import model.Conexion;
import model.empleados;
import model.estado;

/**
 *
 * @author eduar
 */
public class empleadosGestion {

    private static final String SQL_SelectEmpleado = " SELECT * FROM empleados";
    private static final String SQL_SelectEmpleadoInactivo = " SELECT * FROM empleados AND estadoEmpleado = 0";    
    private static final String SQL_SelectEmpleadoid = "SELECT * FROM empleados WHERE id_empleado = ?";
    private static final String SQL_deleteEmpleado = "Delete from empleados where id_empleado = ?";
    private static final String SQL_getIdpuestoEmpleado = "SELECT id_puesto FROM puesto where nombrePuesto = ?"; 
    private static final String SQL_insertEmpleado = "INSERT INTO empleados("
            + "nombreEmpleado, "
            + "apellidosEmpleado, "
            + "correoEmpleado,"
            + "telefonoEmpleado,"
            + "fecha_nacimientoEmpleado,"
            + "id_puesto,"
            + "fechaIngreso,"
            + "estadoEmpleado"
            + ")VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_updateEmpleado = "UPDATE empleados set nombreEmpleado=?, apellidosEmpleado=?, correoEmpleado=?, telefonoEmpleado=?, fecha_nacimientoEmpleado=?, id_puesto=?, fechaIngreso=?, estadoEmpleado=? WHERE id_empleado=?";
    private static final String SQL_empleadoCorreo = "SELECT * FROM empleados WHERE correoEmpleado = ?";
    
    private static final String SQL_ESTADO = "select estadoEmpleado as estado,count(*) total from empleados group by estado";

    public static ArrayList<empleados> getEmpleado() {
        ArrayList<empleados> listadoEmpleados = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectEmpleado);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                listadoEmpleados.add(new empleados(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getDate(8),
                        rs.getBoolean(9)));
            }
        } catch (SQLException e) {
            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return listadoEmpleados;
    }
    
    public static ArrayList<empleados> getEmpleadoInactivo() {
        ArrayList<empleados> listadoEmpleados = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectEmpleadoInactivo);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                listadoEmpleados.add(new empleados(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getDate(8),
                        rs.getBoolean(9)));
            }
        } catch (SQLException e) {
            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return listadoEmpleados;
    }

    public static boolean insertarEmpleado(empleados emp) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_insertEmpleado);
            pst.setString(1, emp.getNombreEmpleado());
            pst.setString(2, emp.getApellidosEmpleado());
            pst.setString(3, emp.getCorreoEmpleado());
            pst.setString(4, emp.getTelefonoEmpleado());
            pst.setObject(5, emp.getFecha_nacimientoEmpleado());
            pst.setInt(6, emp.getId_puesto());
            pst.setObject(7, emp.getFechaIngreso());
            pst.setBoolean(8, emp.getEstadoEmpleado());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }

    public static boolean eliminarEmpleado(empleados emp) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_deleteEmpleado);
            pst.setInt(1, emp.getId_empleado());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }
    
        public static boolean actualizarEmpleado(empleados emp) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_updateEmpleado);
            pst.setString(1, emp.getNombreEmpleado());
            pst.setString(2, emp.getApellidosEmpleado());
            pst.setString(3, emp.getCorreoEmpleado());
            pst.setString(4, emp.getTelefonoEmpleado());
            pst.setObject(5, emp.getFecha_nacimientoEmpleado());
            pst.setInt(6, emp.getId_puesto());
            pst.setObject(7, emp.getFechaIngreso());
            pst.setBoolean(8, emp.getEstadoEmpleado());
            pst.setInt(9, emp.getId_empleado());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }
        
        public static empleados getEmpleado(String correo){
            empleados emp = null;
            try {
                PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_empleadoCorreo);
                pst.setString(1, correo);
                ResultSet rs = pst.executeQuery();
                while(rs != null && rs.next()){
                    emp = (new empleados(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getDate(8),
                        rs.getBoolean(9)  
                    ));
                }
            } catch (SQLException e) {
                            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, e);
            }
            return emp;
        }
        
        public static empleados getEmpleadosId(int id){
            empleados emp = null;
            try {
                PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectEmpleadoid);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                while(rs != null && rs.next()){
                    emp = (new empleados(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getDate(8),
                        rs.getBoolean(9)  
                    ));
                }
            } catch (Exception e) {
            }
    
            return emp;
        }
        
        public static int getIdpuesto(String puestoSelect){
            int puesto = 0;
            try {
                PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_getIdpuestoEmpleado);
                pst.setString(1, puestoSelect);
                ResultSet rs = pst.executeQuery();
                while(rs != null && rs.next()){
                    puesto = rs.getInt(1);
                    return puesto;
                }
            } catch (SQLException e) {
                        Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, e);
                        
            }
            return puesto;
        }
        
        
        
          public static ArrayList<estado> getEstados() {
        ArrayList<estado> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_ESTADO);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new estado(
                        rs.getInt(1),
                        rs.getBoolean(2)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
            
        }
        return lista;

    }
          
          
          
          public static String generarJson() {
        empleados empleado = null;
        String tiraJson = "";
        String fechaNacimiento = "";
        String fechaIngreso = "";
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_SelectEmpleado);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                empleado = new empleados(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getDate(8),
                        rs.getBoolean(9));
               
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                fechaNacimiento = sdf.format(empleado.getFecha_nacimientoEmpleado());
                fechaIngreso = sdf.format(empleado.getFechaIngreso());
                JsonObjectBuilder creadorJson = Json.createObjectBuilder();
                JsonObject objetoJson = creadorJson.add("id", empleado.getId_empleado())
                        .add("nombre", empleado.getNombreEmpleado())
                        .add("apellidos", empleado.getApellidosEmpleado())
                        .add("correo", empleado.getCorreoEmpleado())
                        .add("telefono", empleado.getTelefonoEmpleado())
                        .add("fechaNacimiento", fechaNacimiento)
                        .add("correo", empleado.getId_puesto())
                        .add("idPuesto", fechaIngreso)
                        .add("estado", empleado.getEstadoEmpleado())
                        .build();
                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(objetoJson);
                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return tiraJson;

    }
        
        
        
}
