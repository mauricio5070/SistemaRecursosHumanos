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
public class vacacionesHistoricas {

    private int id_empleado;
    private Date fechaSalida;
    private Date fechaEntrada;

    public vacacionesHistoricas() {
    }

    public vacacionesHistoricas(int id_empleado, Date fechaSalida, Date fechaEntrada) {
        this.id_empleado = id_empleado;
        this.fechaSalida = fechaSalida;
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    
}
