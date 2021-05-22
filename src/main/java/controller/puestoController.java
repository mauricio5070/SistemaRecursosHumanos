/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.puestoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.puesto;

/**
 *
 * @author eduar
 */
@Named(value = "puestoController")
@SessionScoped
public class puestoController extends puesto implements Serializable {

    public puestoController(){
    
    }
    
    public List<puesto> getPuesto() {
        return puestoGestion.getPuesto();
    }
    
    public void buscarPuesto(String correo) {
        puesto psto = puestoGestion.getPuesto(correo);
        try {
            this.setId_puesto(psto.getId_puesto());
            this.setNombrePuesto(psto.getNombrePuesto());
            this.setSalarioPuesto(psto.getSalarioPuesto());
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaEmpleadoForm:id", msg);
        }
    }
    
}
