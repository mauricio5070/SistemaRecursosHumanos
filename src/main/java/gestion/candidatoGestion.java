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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.candidato;

/**
 *
 * @author Mauricio
 */
public class candidatoGestion {
    private static final String SQL_SelectCandidato = "SELECT * FROM candidatos";  
    private static final String SQL_SelectCandidatoid = "SELECT * FROM candidatos WHERE id_candidato = ?";
    private static final String SQL_deleteCandidato = "Delete from candidatos where id_candidato = ?";
    private static final String SQL_getIdpuestoCandidato = "SELECT id_puesto FROM puesto where nombrePuesto = ?"; 
    private static final String SQL_getNombrePuestoCandidato = "SELECT nombrePuesto FROM puesto where nombrePuesto = ?";
    private static final String SQL_insertCandidato = "INSERT INTO candidatos (nombreCandidato, apellidosCandidato, correoCandidato, telefonoCandidato, vacante, fecha_nacimientoCandidato)VALUES(?,?,?,?,?,?)";
    private static final String SQL_updateCandidato = "UPDATE candidatos set nombreCandidato=?, apellidosCandidato=?, correoCandidato=?, telefonoCandidato=?, vacante=?, fecha_nacimientoCandidato=? WHERE id_candidato=?";
    private static final String SQL_candidatoCorreo = "SELECT * FROM candidatos WHERE correoCandidato = ?";

    public static ArrayList<candidato> getCandidato() {
        ArrayList<candidato> listadoCandidatos = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectCandidato);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                listadoCandidatos.add(new candidato(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7)));
            }
        } catch (SQLException e) {
            Logger.getLogger(candidatoGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return listadoCandidatos;
    }
    
    

    public static boolean insertarCandidato(candidato can) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_insertCandidato);
            pst.setString(1, can.getNombreCandidato());
            pst.setString(2, can.getApellidosCandidato());
            pst.setString(3, can.getCorreoCandidato());
            pst.setString(4, can.getTelefonoCandidato());
            pst.setString(5, can.getVacante());
            pst.setObject(6, can.getFecha_nacimientoCandidato());
        } catch (SQLException e) {
            Logger.getLogger(candidatoGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }

    public static boolean eliminarCandidato(candidato can) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_deleteCandidato);
            pst.setInt(1, can.getId_candidato());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(candidatoGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }
    
        public static boolean actualizarCandidato(candidato can) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_updateCandidato);
            pst.setString(1, can.getNombreCandidato());
            pst.setString(2, can.getApellidosCandidato());
            pst.setString(3, can.getCorreoCandidato());
            pst.setString(4, can.getTelefonoCandidato());
            pst.setString(5, can.getVacante());
            pst.setObject(6, can.getFecha_nacimientoCandidato());;
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(candidatoGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }
        
        public static candidato getCandidato(String correo){
            candidato can = null;
            try {
                PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_candidatoCorreo);
                pst.setString(1, correo);
                ResultSet rs = pst.executeQuery();
                while(rs != null && rs.next()){
                    can = (new candidato(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7) 
                    ));
                }
            } catch (SQLException e) {
                            Logger.getLogger(candidatoGestion.class.getName())
                    .log(Level.SEVERE, null, e);
            }
            return can;
        }
        
        public static candidato getCandidatosId(int id){
            candidato can = null;
            try {
                PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_SelectCandidatoid);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                while(rs != null && rs.next()){
                    can = (new candidato(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7)    
                    ));
                }
            } catch (Exception e) {
            }
    
            return can;
        }
        
        public static int getIdpuesto(String puestoSelect){
            int puesto = 0;
            try {
                PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_getIdpuestoCandidato);
                pst.setString(1, puestoSelect);
                ResultSet rs = pst.executeQuery();
                while(rs != null && rs.next()){
                    puesto = rs.getInt(1);
                    return puesto;
                }
            } catch (SQLException e) {
                        Logger.getLogger(candidatoGestion.class.getName())
                    .log(Level.SEVERE, null, e);
                        
            }
            return puesto;
        }

         public static String getNomPuesto(String puestoSelect){
            String puesto = "";
            try {
                PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_getNombrePuestoCandidato);
                pst.setString(1, puestoSelect);
                ResultSet rs = pst.executeQuery();
                while(rs != null && rs.next()){
                    puesto = rs.getString(1);
                    return puesto;
                }
            } catch (SQLException e) {
                        Logger.getLogger(candidatoGestion.class.getName())
                    .log(Level.SEVERE, null, e);
                        
            }
            return puesto;
        }
        
}
