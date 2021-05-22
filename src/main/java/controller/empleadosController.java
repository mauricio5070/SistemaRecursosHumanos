
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.empleadosGestion;
import gestion.puestoGestion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import model.empleados;



@Named(value = "empleadosController")
@SessionScoped
public class empleadosController extends empleados implements Serializable {

    /**
     * Creates a new instance of empleadoController
     */
    public empleadosController() {
    }
   
    public List<empleados> getEmpleado() {
        return empleadosGestion.getEmpleado();
    }
    
        public List<empleados> getEmpleadoInactivo() {
        return empleadosGestion.getEmpleadoInactivo();
    }
    
    public String editaEmpleado(String correo){
        empleados empl = empleadosGestion.getEmpleado(correo);
        try {
            if(empl != null){
            this.setId_empleado(empl.getId_empleado());
            this.setNombreEmpleado(empl.getNombreEmpleado());
            this.setApellidosEmpleado(empl.getApellidosEmpleado());
            this.setCorreoEmpleado(empl.getCorreoEmpleado());
            this.setTelefonoEmpleado(empl.getTelefonoEmpleado());
            this.setFecha_nacimientoEmpleado(empl.getFecha_nacimientoEmpleado());
            this.setId_puesto(empl.getId_puesto());
            this.setFechaIngreso(empl.getFechaIngreso());
            this.setEstadoEmpleado(empl.getEstadoEmpleado());
            return "empleado.xhtml";
        }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaEmpleadoForm:id", msg);
        }
        return "empleado.xhtml";
    }
    
        public String editaEmpleadoVacaciones(String correo){
        empleados empl = empleadosGestion.getEmpleado(correo);
        try {
            if(empl != null){
            this.setId_empleado(empl.getId_empleado());
            this.setNombreEmpleado(empl.getNombreEmpleado());
            this.setApellidosEmpleado(empl.getApellidosEmpleado());
            this.setCorreoEmpleado(empl.getCorreoEmpleado());
            this.setTelefonoEmpleado(empl.getTelefonoEmpleado());
            this.setFecha_nacimientoEmpleado(empl.getFecha_nacimientoEmpleado());
            this.setId_puesto(empl.getId_puesto());
            this.setFechaIngreso(empl.getFechaIngreso());
            this.setEstadoEmpleado(empl.getEstadoEmpleado());
            return "vacaciones.xhtml";
        }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("ingresoVacacionesForm:FechaSalida", msg);
        }
        return "vacaciones.xhtml";
    }
    
    public String insertarEmpleado(String puesto){
        actualizarIdPuesto(puesto);
        if(empleadosGestion.insertarEmpleado(this)){
            return "empleado.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al modificar el empleado");
            FacesContext.getCurrentInstance().addMessage("editaEmpleadoForm:id", msg);
            return "empleado.xhtml";
        }
    }
    
    public String actualizarEmpleado(String puesto){
        actualizarIdPuesto(puesto);
        if(empleadosGestion.actualizarEmpleado(this)){
            return "empleado.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al modificar el empleado");
            FacesContext.getCurrentInstance().addMessage("editaEmpleadoForm:nombre", msg);
            
            return "empleado.xhtml";        
        }
    }
    
    public String eliminarEmpleado(){
        if(empleadosGestion.eliminarEmpleado(this)){
            return "empleado.xhtml";
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Ocurrio un error al modificar el empleado");
            FacesContext.getCurrentInstance().addMessage("editaEmpleadoForm:id", msg); 
            return "empleado.xhtml";             
        }
    }
    
    public void actualizarIdPuesto(String puesto){
        System.out.println(puesto);
        this.setId_puesto(empleadosGestion.getIdpuesto(puesto));
    }
    
    public String liqEmpleado(int id){
        empleados empl = empleadosGestion.getEmpleadosId(id);
        try {
            if(empl != null){
            this.setId_empleado(empl.getId_empleado());
            this.setNombreEmpleado(empl.getNombreEmpleado());
            this.setApellidosEmpleado(empl.getApellidosEmpleado());
            this.setCorreoEmpleado(empl.getCorreoEmpleado());
            this.setTelefonoEmpleado(empl.getTelefonoEmpleado());
            this.setFecha_nacimientoEmpleado(empl.getFecha_nacimientoEmpleado());
            this.setId_puesto(empl.getId_puesto());
            this.setFechaIngreso(empl.getFechaIngreso());
            this.setEstadoEmpleado(empl.getEstadoEmpleado());
            return "liquidaEmp.xhtml";
        }
        } catch (Exception e) {
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("liquidaEmpleadoForm:id", msg);
        }
        return "liquidaciones.xhtml";
    }
    
    public void respaldo() {
        ZipOutputStream out = null;
        try {
            String json = empleadosGestion.generarJson();
            File f = new File(FacesContext.getCurrentInstance().
                    getExternalContext().getRealPath("/respaldo") + "empleados.zip");
            out = new ZipOutputStream(new FileOutputStream(f));
            ZipEntry e = new ZipEntry("empleados.json");
            out.putNextEntry(e);
            byte[] data = json.getBytes();
            out.write(data, 0, data.length);
            out.closeEntry();
            out.close();
            File zipPath = new File(FacesContext.getCurrentInstance().
                    getExternalContext().getRealPath("/respaldo") + "empleados.zip");
            byte[] zip = Files.readAllBytes(zipPath.toPath());

            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-disposition", "attachment; filename=empleados.zip");
            ServletOutputStream flujo = respuesta.getOutputStream();
            flujo.write(zip);
            flujo.flush();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(empleadosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(empleadosController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();

            } catch (IOException ex) {
                Logger.getLogger(empleadosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }



}
