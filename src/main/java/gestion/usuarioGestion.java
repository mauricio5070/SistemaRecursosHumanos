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
import model.usuario;

/**
 *
 * @author Mauricio
 */
public class usuarioGestion {
    
    private static final String SQL_GETUser ="SELECT * FROM usuario WHERE userName =? and pwUsuario =MD5(?)";
    private static final String SQL_GETALL ="SELECT * FROM usuario";
    private static final String SQL_SelectUsers = " SELECT * FROM usuario";
    private static final String SQL_updateUser = "UPDATE usuario set userName=?, pwUsuario=?, nombreUsuario=? WHERE userName=?";
    private static final String SQL_UserName = "SELECT * FROM usuario WHERE userName = ?";
     private static final String SQL_insertUser = "INSERT INTO usuario("
            + "id_usuario"
            + "userName, "
            + "pwUsuario, "
            + "nombreUsuario,"
            + ")VALUES(?,?,?,?)";
    private static final String SQL_deleteUser = "Delete from usuario where userName = ?";
    
    public static usuario getUser(String username, String password){
        usuario user = null;
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_GETUser);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                user = new usuario();
                user.setNombreUsuario(rs.getString(4));
                user.setPwUsuario(password);
                user.setUserName(username);
            }
        } catch (SQLException e) {
            Logger.getLogger(usuarioGestion.class.getName()).log(Level.SEVERE,null,e);
        }
        return user;
    }
    
     public static ArrayList<usuario> getUsers() {
        ArrayList<usuario> listadoUsuarios = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_GETALL);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                listadoUsuarios.add(new usuario(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException e) {
            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return listadoUsuarios;
    }
    
      public static boolean insertarUsuario(usuario usr) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_insertUser);
            pst.setInt(1, usr.getId_usuario());
            pst.setString(2, usr.getUserName());
            pst.setString(3, usr.getPwUsuario());
            pst.setString(4, usr.getNombreUsuario());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(usuarioGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }

    public static boolean eliminarUsuario(usuario usr) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_deleteUser);
            pst.setString(1, usr.getUserName());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(usuarioGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }
    
        public static boolean actualizarUser(usuario usr) {
        try {
            PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_updateUser);
            pst.setInt(1, usr.getId_usuario());
            pst.setString(2, usr.getUserName());
            pst.setString(3, usr.getPwUsuario());  
             pst.setString(4, usr.getNombreUsuario()); 
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(usuarioGestion.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return false;
    }
        
        public static usuario getUsuario(String usrName){
           usuario usr = null;
            try {
                PreparedStatement pst = Conexion.getConexion().prepareStatement(SQL_UserName);
                pst.setString(1, usrName);
                ResultSet rs = pst.executeQuery();
                while(rs != null && rs.next()){
                    usr= (new usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4) 
                    ));
                }
            } catch (SQLException e) {
                            Logger.getLogger(empleadosGestion.class.getName())
                    .log(Level.SEVERE, null, e);
            }
            return usr;
        }
     
}
