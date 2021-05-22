/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author eduar
 */
public class fechaPago {
    
    private Date fechaPago;
    private String descripcionFecha;

    public fechaPago() {
    }

    public fechaPago(Date fechaPago, String descripcionFecha) {
        this.fechaPago = fechaPago;
        this.descripcionFecha = descripcionFecha;
    }

    public String getDescripcionFecha() {
        return descripcionFecha;
    }

    public void setDescripcionFecha(String descripcionFecha) {
        this.descripcionFecha = descripcionFecha;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    
    
}
