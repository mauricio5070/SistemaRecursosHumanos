/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import model.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import model.empleados;
/**
 *
 * @author Mauricio
 */
@Named(value = "reporteController")
@SessionScoped
public class ReporteController implements Serializable {

   
    
    public ReporteController() {
    }

    public void verPDFEmpleados() {
        try {
            File jasper = new File(FacesContext
                    .getCurrentInstance().
                    getExternalContext()
                    .getRealPath("/emplado/emp.jasper"));

            JasperPrint reporteJasper = JasperFillManager.
                    fillReport(jasper.getPath(), null, Conexion.getConexion());

            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();

            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type", "application/pdf");

            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void descargarPDFEmpleados() {
        try {
            File jasper = new File(FacesContext
                    .getCurrentInstance().
                    getExternalContext()
                    .getRealPath("/emplado/emp.jasper"));

            JasperPrint reporteJasper = JasperFillManager.
                    fillReport(jasper.getPath(), null, Conexion.getConexion());

            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();

            respuesta.addHeader("Content-disposition", "attachment; filename=reporteEmpleado.pdf");

            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     public void verPDFPuestos() {
        try {
            File jasper = new File(FacesContext
                    .getCurrentInstance().
                    getExternalContext()
                    .getRealPath("/puestos/pue.jasper"));

            JasperPrint reporteJasper = JasperFillManager.
                    fillReport(jasper.getPath(), null, Conexion.getConexion());

            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();

            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type", "application/pdf");

            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void descargarPDFPuestos() {
        try {
            File jasper = new File(FacesContext
                    .getCurrentInstance().
                    getExternalContext()
                    .getRealPath("/puestos/pue.jasper"));

            JasperPrint reporteJasper = JasperFillManager.
                    fillReport(jasper.getPath(), null, Conexion.getConexion());

            HttpServletResponse respuesta = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();

            respuesta.addHeader("Content-disposition", "attachment; filename=reportePuesto.pdf");

            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException | IOException ex) {
            Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
