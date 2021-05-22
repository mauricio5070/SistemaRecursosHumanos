/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import gestion.candidatoGestion;
import gestion.puestoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.candidato;

/**
 *
 * @author Mauricio
 */

@Named(value = "candidatoController")
@SessionScoped
public class candidatoController extends candidato implements Serializable {
   
    public candidatoController() {
    }
   
    public List<candidato> getCandidato() {
        return candidatoGestion.getCandidato();
    }
    
    
    public String editaCandidato(String correo){
        candidato empl = candidatoGestion.getCandidato(correo);
        try {
            if(empl != null){
            this.setId_candidato(empl.getId_candidato());
            this.setNombreCandidato(empl.getNombreCandidato());
            this.setApellidosCandidato(empl.getApellidosCandidato());
            this.setCorreoCandidato(empl.getCorreoCandidato());
            this.setTelefonoCandidato(empl.getTelefonoCandidato());
            this.setVacante(empl.getVacante());
            this.setFecha_nacimientoCandidato(empl.getFecha_nacimientoCandidato());
            return "index.xhtml";
        }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaCandidatoForm:id", msg);
        }
       return "index.xhtml";
    }
    
       
    
    public String insertarCandidato(String puesto){
        actualizarPuesto(puesto);
        if(candidatoGestion.insertarCandidato(this)){
          return "exito.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al modificar el candidato");
            FacesContext.getCurrentInstance().addMessage("editaCandidatoForm:id", msg);
            return "index.xhtml";
        }
    }
    
    public String actualizarCandidato(String puesto){
        actualizarPuesto(puesto);
        if(candidatoGestion.actualizarCandidato(this)){
           return "index.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al modificar el candidato");
            FacesContext.getCurrentInstance().addMessage("editaCandidatoForm:nombre", msg);
            
            return "index.xhtml";    
        }
    }
    
    public String eliminarCandidato(){
        if(candidatoGestion.eliminarCandidato(this)){
            return "index.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al modificar el candidato");
            FacesContext.getCurrentInstance().addMessage("editaCandidatoForm:id", msg); 
            return "index.xhtml";          
        }
    }
    
    public void actualizarPuesto(String puesto){
        this.setVacante(puesto);
    }
    
 
}
