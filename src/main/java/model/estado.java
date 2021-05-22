/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mauricio
 */
public class estado {
    private int total;
    private boolean estadoEmpleado;

    public estado(int total, boolean estadoEmpleado) {
        this.total = total;
        this.estadoEmpleado = estadoEmpleado;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(boolean estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }
    
    
    
}
