/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mauricio
 */
public class usuario {

    private int id_usuario;
    private String userName;
    private String pwUsuario;
    private String nombreUsuario;

    public usuario() {
    }

   
    public usuario(int id_usuario, String userName, String pwUsuario, String nombreUsuario) {
        this.id_usuario = id_usuario;
        this.userName = userName;
        this.pwUsuario = pwUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwUsuario() {
        return pwUsuario;
    }

    public void setPwUsuario(String pwUsuario) {
        this.pwUsuario = pwUsuario;
    }
    
}
