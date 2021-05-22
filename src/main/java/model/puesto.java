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
public class puesto {

    private int id_puesto;
    private String nombrePuesto;
    private float salarioPuesto;
    
    public puesto(){
    
    }

    public puesto(int id_puesto, String nombrePuesto, float salarioPuesto) {
        this.id_puesto = id_puesto;
        this.nombrePuesto = nombrePuesto;
        this.salarioPuesto = salarioPuesto;
    }
    
    @Override
    public String toString(){
        return nombrePuesto;
    }
    
    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public float getSalarioPuesto() {
        return salarioPuesto;
    }

    public void setSalarioPuesto(float salarioPuesto) {
        this.salarioPuesto = salarioPuesto;
    }
}
