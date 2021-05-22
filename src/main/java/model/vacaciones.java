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
public class vacaciones {

    private int id_empleado;
    private int cantidadVacacionesDisponibles;
    private int decisionSolicitud;

    public vacaciones(int id_empleado, int cantidadVacacionesDisponibles) {
        this.id_empleado = id_empleado;
        this.cantidadVacacionesDisponibles = cantidadVacacionesDisponibles;
    }
    
    public vacaciones(int id_empleado, int cantidadVacacionesDisponibles, int decisionSolicitud){
        this.id_empleado = id_empleado;
        this.cantidadVacacionesDisponibles = cantidadVacacionesDisponibles;
        this.decisionSolicitud = decisionSolicitud;
    }

    public vacaciones() {
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getCantidadVacacionesDisponibles() {
        return cantidadVacacionesDisponibles;
    }

    public void setCantidadVacacionesDisponibles(int cantidadVacacionesDisponibles) {
        this.cantidadVacacionesDisponibles = cantidadVacacionesDisponibles;
    }

    public int getDecisionSolicitud() {
        return decisionSolicitud;
    }

    public void setDecisionSolicitud(int decisionSolicitud) {
        this.decisionSolicitud = decisionSolicitud;
    }
    
}
