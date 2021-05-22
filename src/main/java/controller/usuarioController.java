package controller;

import gestion.usuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.usuario;

/**
 *
 * @author Mauricio
 */
@Named(value = "usuarioController")
@SessionScoped
public class usuarioController extends usuario implements Serializable{

    /**
     * Creates a new instance of usuarioController
     */
    public usuarioController() {
    }    
    
    public String getUser(){
        usuario user = usuarioGestion.getUser(this.getUserName(), this.getPwUsuario());
        if(user != null){
            this.setNombreUsuario(user.getNombreUsuario());
            return "inicio.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Usuario o contraseña incorrecta");
            FacesContext.getCurrentInstance().addMessage("LoginForm:clave", msg);
            return "index.xhtml";
        }
    }
    
    
    public List<usuario> getUsers() {
        return usuarioGestion.getUsers();
    }
    
    
    public String editaUsuario(String name){
        usuario usr = usuarioGestion.getUsuario(name);
        try {
            if(usr != null){
            this.setId_usuario(usr.getId_usuario());
            this.setUserName(usr.getUserName());
            this.setPwUsuario(usr.getPwUsuario());
            this.setNombreUsuario(usr.getNombreUsuario());
            return "usuario.xhtml";
        }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:id", msg);
        }
        return "usuario.xhtml";
    }
     public String insertarUsuario(){
        if(usuarioGestion.insertarUsuario(this)){
            return "usuario.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al modificar el usuario");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:id", msg);
            return "usuario.xhtml";
        }
    }
    
    public String actualizarUsuario(){
        
        if(usuarioGestion.actualizarUser(this)){
            return "usuario.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al modificar el usuario");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:nombre", msg);
            
            return "usuario.xhtml";        
        }
    }
    
    public String eliminarUsuario(){
        if(usuarioGestion.eliminarUsuario(this)){
            return "usuario.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al modificar el usuario");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:id", msg); 
            return "usuario.xhtml";             
        }
    }
    
}
