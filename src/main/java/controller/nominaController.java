/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import gestion.nominaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.nomina;

/**
 *
 * @author Mauricio
 */
@Named(value = "nominaController")
@SessionScoped
public class nominaController extends nomina implements Serializable {
    public nominaController() {
    }
   
    public List<nomina> getNomina() {
        return nominaGestion.getNomina();
    }
}
