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
public class nomina {

    private float monto;
    private int id_pago;
    private int id_fechaPago;
    private Date fechaPago;

    public nomina() {
    }

    public nomina( int id_pago,float monto, int id_fechaPago, Date fechaPago) {
        this.monto = monto;
        this.id_pago = id_pago;
        this.id_fechaPago= id_fechaPago;
        this.fechaPago = fechaPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_fechaPago() {
        return id_fechaPago;
    }

    public void setId_fechaPago(int id_fechaPago) {
        this.id_fechaPago = id_fechaPago;
    }

    
    
}
