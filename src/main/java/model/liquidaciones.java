/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author eduar
 */
public class liquidaciones {
    
    private boolean estatudsEntrega;
    private float montoLiquidacion;
    private int id_empleado;

    public liquidaciones(boolean estatudsEntrega, float montoLiquidacion, int id_empleado) {
        this.estatudsEntrega = estatudsEntrega;
        this.montoLiquidacion = montoLiquidacion;
        this.id_empleado = id_empleado;
    }

    public liquidaciones() {
    }

    public boolean isEstatudsEntrega() {
        return estatudsEntrega;
    }

    public void setEstatudsEntrega(boolean estatudsEntrega) {
        this.estatudsEntrega = estatudsEntrega;
    }

    public float getMontoLiquidacion() {
        return montoLiquidacion;
    }

    public void setMontoLiquidacion(float montoLiquidacion) {
        this.montoLiquidacion = montoLiquidacion;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    
    
}
