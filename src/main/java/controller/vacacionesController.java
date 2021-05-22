/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.vacacionesGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.vacaciones;

/**
 *
 * @author eduar
 */
@Named(value = "vacacionesController")
@SessionScoped
public class vacacionesController extends vacaciones implements Serializable {

    /**
     * Creates a new instance of vacacionesController
     */
    
    public vacacionesController() {
    }
    
    public List<vacaciones> getVacaciones(){
        return vacacionesGestion.getVacaciones();
    }

    public String buscarVacaciones(int idEmpleado){
        vacaciones vcn = vacacionesGestion.getVacaciones(idEmpleado);
        try {
            if(vcn != null){
                this.setCantidadVacacionesDisponibles(vcn.getCantidadVacacionesDisponibles());
                this.setId_empleado(vcn.getId_empleado());
                this.setDecisionSolicitud(2);
            }
            return "vacaciones.xhtml";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("ingresoVacacionesForm:FechaSalida", msg);
        }
        return "vacaciones.xhtml";
    }
}
